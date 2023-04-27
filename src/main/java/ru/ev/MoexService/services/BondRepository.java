package ru.ev.MoexService.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import ru.ev.MoexService.dto.BondDto;
import ru.ev.MoexService.exeption.LimitRequestsException;
import ru.ev.MoexService.moexclient.CorporateBondsClient;
import ru.ev.MoexService.moexclient.GovBondsClient;
import ru.ev.MoexService.parser.Parser;

import java.util.List;
@Slf4j
@Component
@RequiredArgsConstructor
public class BondRepository {
    private final CorporateBondsClient corporateBondsClient;
    private final GovBondsClient govBondsClient;
    private final Parser parser;
    @Cacheable(value = "corps")
    public List<BondDto> getCorporateBonds(){
        log.info("Getting Corporate bonds from Moex");
        String xmlFromMoex= corporateBondsClient.getBondsFromMoex();
        List<BondDto> bondDtos=parser.parse(xmlFromMoex);
        if(bondDtos.isEmpty()){
            log.error("Moex isn't answering for getting bonds.");
            throw new LimitRequestsException("Moex isn't answering for getting bonds.");

        }
        return bondDtos;
    }
    @Cacheable(value = "govs")
    public List<BondDto> getGovBonds() {
        log.info("Getting government bonds from Moex");
        String xmlFromMoex = govBondsClient.getBondsFromMoex();

        List<BondDto> bonds = parser.parse(xmlFromMoex);
        if (bonds.isEmpty()) {
            log.error("Moex isn't answering for getting government bonds.");
            throw new LimitRequestsException("Moex isn't answering for getting government bonds.");
        }
        return bonds;
    }
}
