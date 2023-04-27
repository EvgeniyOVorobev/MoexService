package ru.ev.MoexService.dto;

import lombok.Value;

@Value
public class BondDto {
    String ticker;
    String name;
    Double price;
}
