package de.dreierschach.retrocomputer.basic.model;

public class IfExpression extends Expression {
    @Override
    public Value evaluate() {
        return getValue(0).toType(Value.Type.BOOL);
    }
}
