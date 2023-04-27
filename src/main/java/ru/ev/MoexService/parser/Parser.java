package ru.ev.MoexService.parser;

import ru.ev.MoexService.dto.BondDto;

import java.util.List;

public interface Parser {
    List<BondDto> parse(String ratesAsString);
}
