package ru.ev.MoexService.exeption;

public class BondNotFoundException extends RuntimeException {
    public BondNotFoundException(String m) {
        super(m);
    }
}