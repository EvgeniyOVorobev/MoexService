package ru.ev.MoexService.dto;

import lombok.Value;
import ru.ev.MoexService.Model.Stock;

import java.util.List;

@Value
public class StocksDto {
    List<Stock> stocks;
}
