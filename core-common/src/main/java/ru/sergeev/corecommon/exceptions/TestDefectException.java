package ru.sergeev.corecommon.exceptions;

public class TestDefectException extends RuntimeException {
    private static final String ERROR_MSG = "Дефект теста: ";

    public TestDefectException(String message, Object ...args) {
        super(ERROR_MSG + (args.length == 0 ? message : String.format(message, args)));
    }
}
