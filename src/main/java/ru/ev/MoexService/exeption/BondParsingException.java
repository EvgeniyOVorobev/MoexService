package ru.ev.MoexService.exeption;

public class BondParsingException extends RuntimeException {
    public BondParsingException(Exception ex) {
        super(ex);
    }
}