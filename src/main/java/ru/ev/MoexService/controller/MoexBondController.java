package ru.ev.MoexService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ev.MoexService.dto.FigiesDto;
import ru.ev.MoexService.dto.StocksDto;
import ru.ev.MoexService.dto.StocksPricesDto;
import ru.ev.MoexService.dto.TickersDto;
import ru.ev.MoexService.services.BondService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bonds")
public class MoexBondController {
    private final BondService bondService;
    @PostMapping("/getBondsByTickers")
 public StocksDto getBondsFromMoex(@RequestBody TickersDto tickersDto){
     return bondService.getBondsFromMoex(tickersDto);
 }

    @PostMapping("/prices")
    public StocksPricesDto getPricesByFigies(@RequestBody FigiesDto figiesDto) {
        return bondService.getPricesByFigies(figiesDto);
    }
}
