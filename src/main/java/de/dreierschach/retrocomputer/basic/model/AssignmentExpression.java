package de.dreierschach.retrocomputer.basic.model;

import java.util.List;

public class AssignmentExpression extends Expression {
    @Override
    public Value evaluate() {
        return getValue(2);
    }

    public String identifier() {
        return getValue(0).string();
    }

    public List<Integer> indexes() {
        return getValue(1).array().values().stream().map(Value::toNumber).toList();
    }
}
