package ru.ev.MoexService.exeption;

public class LimitRequestsException extends RuntimeException {
    public LimitRequestsException(String message) {
        super(message);
    }
}

