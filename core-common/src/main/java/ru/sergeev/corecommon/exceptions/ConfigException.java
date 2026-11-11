package ru.sergeev.corecommon.exceptions;

public class ConfigException extends RuntimeException {
    private static final String ERROR_MSG = "Конфиг: ";

    public ConfigException(String message, Object ...args) {
        super(ERROR_MSG + (args.length == 0 ? message : String.format(message, args)));
    }
}
