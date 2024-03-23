package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.basic.model.Value;
import de.dreierschach.retrocomputer.ui.Renderer;

import java.util.List;
import java.util.Map;

import static de.dreierschach.retrocomputer.basic.model.Value.arrayValue;

public interface BasicListenerHelper {
    RunningContext getContext();
    Renderer getRenderer();

    Map<String, Value> CONSTANTS = Map.of(
            "PI", new Value(Math.PI)
    );

    default void setValueByIdentifier(String identifier, List<Integer> indexes, Value value) {
        if (indexes.isEmpty()) {
            getContext().memory().set(identifier, value);
            return;
        }
        var arrayValue = getContext().memory().find(identifier).map(v -> v.toType(Value.Type.ARRAY)).orElse(arrayValue(List.of()));
        var current = arrayValue;
        for (var i = 0; i < indexes.size() - 1; i++) {
            var child = current.compute(indexes.get(i), arrayValue(List.of()));
            if (child.type() != Value.Type.ARRAY) {
                child = child.toType(Value.Type.ARRAY);
                current.set(indexes.get(i), child);
            }
            current = child;
        }
        current.set(indexes.get(indexes.size() - 1), value);
        getContext().memory().set(identifier, arrayValue);
    }

    default Value getValueByIdentifier(String identifier, List<Integer> indexes) {
        if (indexes.isEmpty()) {
            return CONSTANTS.getOrDefault(identifier, getContext().memory().get(identifier));
        }
        if (!getContext().memory().contains(identifier)) {
            return Value.UNDEF;
        }
        var current = getContext().memory().get(identifier);
        for (Integer index : indexes) {
            if (current.type() != Value.Type.ARRAY) {
                return Value.UNDEF;
            }
            current = current.get(index);
        }
        return current;
    }

    default Value not(Value v) {
        return switch (v.type()) {
            case BOOL -> new Value(!v.bool());
            case DOUBLE_NUMBER -> new Value(-v.doubleNumber());
            case NUMBER -> new Value(-v.number());
            case STRING -> new Value(!v.toBool());
            case ARRAY -> v.mutate(this::not);
        };
    }

    default Value neg(Value v) {
        return switch (v.type()) {
            case BOOL -> new Value(!v.bool());
            case DOUBLE_NUMBER -> new Value(-v.doubleNumber());
            case NUMBER -> new Value(-v.number());
            case STRING -> new Value("undefined");
            case ARRAY -> v.mutate(this::neg);
        };
    }
    default void assertTextMode() {
        if (!getRenderer().isTextMode()) {
            throw new BasicError(BasicError.Type.FUNCTION_ERROR, getContext().getPp());
        }
    }

    default void assertGfxMode() {
        if (!getRenderer().isGfxMode()) {
            throw new BasicError(BasicError.Type.FUNCTION_ERROR, getContext().getPp());
        }
    }

}
