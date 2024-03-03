package de.dreierschach.retrocomputer.basic.model;

public class ValueExpression extends Expression {
    @Override
    public Value evaluate() {
        return getValue(0);
    }
}
