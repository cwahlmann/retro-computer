package de.dreierschach.retrocomputer.basic.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Expression {
    private final List<Value> values = new ArrayList<>();

    abstract public Value evaluate();

    public Value getValue(int index) {
        return index < values.size() ? values.get(index) : Value.UNDEF;
    }

    public int size() {
        return values.size();
    }

    public List<Value> getValues() {
        return values.stream().toList();
    }

    public void addValue(Value value) {
        this.values.add(value);
    }
}
