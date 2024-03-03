package de.dreierschach.retrocomputer.basic.model;

import de.dreierschach.retrocomputer.basic.RunningContext.PP;

import java.util.List;
import java.util.stream.Collectors;

public class ForExpression extends Expression {
    private PP loopBody;

    @Override
    public Value evaluate() {
        return null;
    }

    public String identifier() {
        return getValue(0).toString();
    }
    public List<Integer> indexes() {
        return getValue(1).toArray().values().stream().map(Value::toNumber).collect(Collectors.toList());
    }

    public Value from() {
        return getValue(2);
    }

    public Value to() {
        return getValue(3);
    }

    public Value step() {
        return size() >= 5 ? getValue(4) : new Value(1);
    }

    public PP loopBody() {
        return loopBody;
    }

    public void loopBody(PP loopBody) {
        this.loopBody = loopBody;
    }
}
