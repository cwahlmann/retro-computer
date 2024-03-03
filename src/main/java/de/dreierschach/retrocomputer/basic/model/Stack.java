package de.dreierschach.retrocomputer.basic.model;

import java.util.ArrayList;

public class Stack<T> extends ArrayList<T> {
    public void push(T t) {
        add(t);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        var t = get(size()-1);
        remove(size()-1);
        return t;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return get(size()-1);
    }
}
