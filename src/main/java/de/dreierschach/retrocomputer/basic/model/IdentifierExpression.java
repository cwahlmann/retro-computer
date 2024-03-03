package de.dreierschach.retrocomputer.basic.model;

import java.util.List;
import java.util.stream.Collectors;

public class IdentifierExpression extends Expression {

    @Override
    public Value evaluate() {
        return new Value(getValues().stream().map(Value::toString).collect(Collectors.joining(".")));
    }
}
