package de.dreierschach.retrocomputer.basic.model;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Memory {
    private final SortedMap<Integer, String> lines = new TreeMap<>();
    private final Map<String, Value> values = new HashMap<>();

    public void clearValues() {
        values.clear();
    }

    public void clearAll() {
        lines.clear();
        values.clear();
    }

    public Value get(String name) {
        return values.getOrDefault(name, new Value(0));
    }

    public boolean contains(String name) {
        return values.containsKey(name);
    }

    public Optional<Value> find(String name) {
        return Optional.ofNullable(values.get(name));
    }

    public void set(String name, Value value) {
        values.put(name, value);
    }

    public Memory withLines(String... lines) {
        for (String line : lines) {
            this.lines.put(getLineNumber(line.trim()), line.trim());
        }
        return this;
    }

    public Memory removeLine(int id) {
        lines.remove(id);
        return this;
    }

    public Collection<String> lines() {
        return lines.values();
    }

    public String line(int id) {
        return lines.getOrDefault(id, "");
    }

    public Collection<String> linesFrom(int id) {
        return lines.tailMap(id).values();
    }

    public Collection<String> linesTo(int id) {
        return lines.headMap(id + 1).values();
    }

    public Collection<String> linesFromTo(int fromId, int toId) {
        return lines.subMap(fromId, toId + 1).values();
    }

    public static int getLineNumber(String line) {
        int i = 0;
        while (i < line.length() && Character.isDigit(line.charAt(i))) {
            i++;
        }
        return Integer.parseInt(line.substring(0, i));
    }
}
