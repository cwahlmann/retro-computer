package de.dreierschach.retrocomputer.basic.model;

public class OperatorExpression extends Expression {

    private Type type;

    public OperatorExpression(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public OperatorExpression withType(Type type) {
        this.type = type;
        return this;
    }

    @Override
    public Value evaluate() {
        var v1 = getValue(0);
        var v2 = getValue(1).toType(v1.type());
        return switch (type) {
            case POW -> pow(v1, v2);
            case DIV -> div(v1, v2);
            case MUL -> mul(v1, v2);
            case MOD -> mod(v1, v2);
            case PLUS -> plus(v1, v2);
            case MINUS -> minus(v1, v2);
            case EQ -> eq(v1, v2);
            case NEQ -> neq(v1, v2);
            case GT -> gt(v1, v2);
            case GE -> ge(v1, v2);
            case LT -> lt(v1, v2);
            case LE -> le(v1, v2);
            case AND -> and(v1, v2);
            case OR -> or(v1, v2);
            case XOR -> xor(v1, v2);
        };
    }

    private Value pow(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(Math.pow(v1.toDoubleNumber(), v2.toDoubleNumber()));
            case NUMBER -> new Value((int) Math.pow(v1.number(), v2.number()));
            case DOUBLE_NUMBER -> new Value(Math.pow(v1.doubleNumber(), v2.doubleNumber()));
            case BOOL -> new Value(v1.bool() || !v2.bool()); // x^1=x, x^0=1
            case ARRAY -> Value.UNDEF;
        };
    }

    private Value div(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(v1.toDoubleNumber() / v2.toDoubleNumber());
            case NUMBER -> new Value(v1.number() / v2.number());
            case DOUBLE_NUMBER -> new Value(v1.doubleNumber() / v2.doubleNumber());
            case BOOL -> new Value(v1.bool() & v2.bool()); // 0/x=0, 1/1=1
            case ARRAY -> Value.UNDEF;
        };
    }

    private Value mul(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(v1.toDoubleNumber() / v2.toDoubleNumber());
            case NUMBER -> new Value(v1.number() * v2.number());
            case DOUBLE_NUMBER -> new Value(v1.doubleNumber() * v2.doubleNumber());
            case BOOL -> new Value(v1.bool() & v2.bool()); // 0*x=x*0=0, 1*1=1
            case ARRAY -> Value.UNDEF;
        };
    }

    private Value mod(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(v1.toNumber() % v2.toNumber());
            case NUMBER -> new Value(v1.number() % v2.number());
            case DOUBLE_NUMBER -> new Value(v1.doubleNumber() % v2.doubleNumber());
            case BOOL -> new Value(v1.bool() & v2.bool()); // 0*x=x*0=0, 1*1=1
            case ARRAY -> Value.UNDEF;
        };
    }

    private Value plus(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(v1.string() + v2.string());
            case NUMBER -> new Value(v1.number() + v2.number());
            case DOUBLE_NUMBER -> new Value(v1.doubleNumber() + v2.doubleNumber());
            case BOOL -> new Value(v1.bool() ^ v2.bool()); // 0+1=1+0=1; 1+1=0
            case ARRAY -> Value.UNDEF;
        };
    }

    private Value minus(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(v1.toDoubleNumber() - v2.toDoubleNumber());
            case NUMBER -> new Value(v1.number() - v2.number());
            case DOUBLE_NUMBER -> new Value(v1.doubleNumber() - v2.doubleNumber());
            case BOOL -> new Value(v1.bool() ^ v2.bool()); // 0-1=1-0=1; 1-1=0
            case ARRAY -> Value.UNDEF;
        };
    }

    private Value eq(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(v1.string().equals(v2.string()));
            case NUMBER -> new Value(v1.number() == v2.number());
            case DOUBLE_NUMBER -> new Value(v1.doubleNumber() == v2.doubleNumber());
            case BOOL -> new Value(v1.bool() == v2.bool());
            case ARRAY -> Value.UNDEF;
        };
    }

    private Value neq(Value v1, Value v2) {
        return new Value(!eq(v1, v2).bool());
    }

    private Value lt(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(v1.string().compareTo(v2.string()) < 0);
            case NUMBER -> new Value(v1.number() < v2.number());
            case DOUBLE_NUMBER -> new Value(v1.doubleNumber() < v2.doubleNumber());
            case BOOL -> new Value(v1.bool() & !v2.bool());
            case ARRAY -> Value.UNDEF;
        };
    }

    private Value gt(Value v1, Value v2) {
        return lt(v2, v1);
    }

    private Value ge(Value v1, Value v2) {
        return new Value(!lt(v1, v2).bool());
    }

    private Value le(Value v1, Value v2) {
        return new Value(!lt(v2, v1).bool());
    }

    private Value and(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(v1.toBool() & v2.toBool());
            case NUMBER -> new Value(v1.number() & v2.number());
            case DOUBLE_NUMBER -> new Value(v1.toNumber() & v2.toNumber());
            case BOOL -> new Value(v1.bool() & v2.bool());
            case ARRAY -> Value.UNDEF;
        };
    }

    private Value or(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(v1.toBool() | v2.toBool());
            case NUMBER -> new Value(v1.number() | v2.number());
            case DOUBLE_NUMBER -> new Value(v1.toNumber() | v2.toNumber());
            case BOOL -> new Value(v1.bool() | v2.bool());
            case ARRAY -> Value.UNDEF;
        };
    }

    private Value xor(Value v1, Value v2) {
        return switch (v1.type()) {
            case STRING -> new Value(v1.toBool() ^ v2.toBool());
            case NUMBER -> new Value(v1.number() ^ v2.number());
            case DOUBLE_NUMBER -> new Value(v1.toNumber() ^ v2.toNumber());
            case BOOL -> new Value(v1.bool() ^ v2.bool());
            case ARRAY -> Value.UNDEF;
        };
    }
    
    public enum Type {
        POW, MUL, MOD, DIV, PLUS, MINUS, EQ, NEQ, LT, LE, GT, GE, AND, OR, XOR
    }
}
