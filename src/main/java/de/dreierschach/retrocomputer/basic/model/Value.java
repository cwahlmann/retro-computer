package de.dreierschach.retrocomputer.basic.model;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Value(String string, int number, double doubleNumber, boolean bool, Type type,
                    SortedMap<Integer, Value> array) {
    public static final Value UNDEF = new Value(0);

    public enum Type {
        STRING, NUMBER, DOUBLE_NUMBER, BOOL, ARRAY
    }

    public Value(String string) {
        this(string, 0, 0, false, Type.STRING, null);
    }

    public Value(int number) {
        this(null, number, 0, false, Type.NUMBER, null);
    }

    public Value(double doubleNumber) {
        this(null, 0, doubleNumber, false, Type.DOUBLE_NUMBER, null);
    }

    public Value(boolean bool) {
        this(null, 0, 0d, bool, Type.BOOL, null);
    }

    public Value(SortedMap<Integer, Value> values) {
        this(null, 0, 0d, false, Type.ARRAY, values);
    }

    public static Value arrayValue(List<Value> values) {
        var map = new TreeMap<Integer, Value>();
        for (int i = 0; i < values.size(); i++) {
            map.put(i, values.get(i));
        }
        return new Value(map);
    }

    public Value toType(Type type) {
        return switch (type) {
            case STRING -> new Value(toString());
            case NUMBER -> new Value(toNumber());
            case DOUBLE_NUMBER -> new Value(toDoubleNumber());
            case BOOL -> new Value(toBool());
            case ARRAY -> this;
        };
    }

    @Override
    public String toString() {
        return switch (type) {
            case STRING -> string();
            case NUMBER -> String.valueOf(number);
            case DOUBLE_NUMBER -> String.valueOf(doubleNumber);
            case BOOL -> String.valueOf(bool).toUpperCase();
            case ARRAY -> arrayToString();
        };
    }

    private String arrayToString() {
        var min = 0;
        var max = array().lastKey();
        return Stream.iterate(min, i -> i <= max, i -> i + 1).map(this::get).map(Value::toString).collect(Collectors.joining(",", "[", "]"));
    }

    public int toNumber() {
        return switch (type) {
            case STRING -> parseOrDefault(() -> Integer.parseInt(string()), 0);
            case NUMBER -> number;
            case DOUBLE_NUMBER -> (int) doubleNumber;
            case BOOL -> bool ? 1 : 0;
            case ARRAY -> array().size();
        };
    }

    public double toDoubleNumber() {
        return switch (type) {
            case STRING -> parseOrDefault(() -> Double.parseDouble(string()), 0d);
            case NUMBER -> number;
            case DOUBLE_NUMBER -> doubleNumber;
            case BOOL -> bool ? 1 : 0;
            case ARRAY -> array().size();
        };
    }

    public boolean toBool() {
        return switch (type) {
            case STRING -> StringUtils.isNotBlank(string) && !"false".equalsIgnoreCase(string);
            case NUMBER -> number != 0;
            case DOUBLE_NUMBER -> doubleNumber != 0;
            case BOOL -> bool;
            case ARRAY -> !array().isEmpty();
        };
    }

    public Map<Integer, Value> toArray() {
        if (type() == Type.ARRAY) {
            return this.array();
        }
        return arrayValue(List.of(this)).array();
    }

    public void set(int i, Value value) {
        array.put(i, value);
    }

    public Value get(int i) {
        return array.getOrDefault(i, Value.UNDEF);
    }

    public Value compute(int i, Value defaultValue) {
        if (!array.containsKey(i)) {
            array.put(i, defaultValue);
        }
        return array.get(i);
    }

    public Value mutate(Function<Value, Value> mutator) {
        var newArray = new TreeMap<Integer, Value>();
        for (int i : array.keySet()) {
            newArray.put(i, mutator.apply(array.get(i)));
        }
        return new Value(newArray);
    }

    private <T> T parseOrDefault(Supplier<T> supplier, T defaultValue) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
