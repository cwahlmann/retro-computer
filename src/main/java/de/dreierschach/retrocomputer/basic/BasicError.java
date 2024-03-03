package de.dreierschach.retrocomputer.basic;

import de.dreierschach.retrocomputer.basic.RunningContext.PP;

public class BasicError extends RuntimeException {

    public enum Type {
        RETURN_WITHOUT_GOSUB,
        SYNTAX_ERROR,
        LOADING_ERROR,
        SAVING_ERROR,
        DELETE_ERROR,
        FUNCTION_ERROR,
    }

    public BasicError(Type type, PP pp) {
        super("?" + type.name() + " at " + pp.line());
    }
}
