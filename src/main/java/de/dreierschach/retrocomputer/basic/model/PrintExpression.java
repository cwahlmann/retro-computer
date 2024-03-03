package de.dreierschach.retrocomputer.basic.model;

import java.util.stream.Collectors;

public class PrintExpression extends Expression {
    @Override
    public Value evaluate() {
        return new Value(getValues().stream().map(Value::toString).collect(Collectors.joining()));
    }

    public Value evaluate(int skip) {
        return new Value(getValues().stream().skip(skip).map(Value::toString).collect(Collectors.joining()));
    }
}
