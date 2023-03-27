package com.msg.rates.controller;


import com.msg.rates.dto.CountryReducedRatesDto;
import com.msg.rates.dto.CountryStandardRateDto;
import com.msg.rates.model.CountryRates;
import com.msg.rates.service.CountryRatesDataService;
import com.msg.rates.service.CountryRatesDiffService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "rates", produces = MediaType.APPLICATION_JSON_VALUE)
@Log4j2
public class RatesController {


    @Autowired
    private CountryRatesDataService contentService;
    @Autowired
    private CountryRatesDiffService diffService;


    @GetMapping(value = "/higheststandardrate")
    public List<CountryStandardRateDto> getHighestStandardRate() throws IOException {
        log.info("Return three EU countries with the highest standard VAT rate");
        Map<String, CountryRates> contriesRates = contentService.getRatesForAllContries();
        return diffService.highestStandardRates(contriesRates);
    }

    @GetMapping(value = "/lowestreducedrates")
    public List<CountryReducedRatesDto> getLowestReducedRates() throws IOException {
        log.info("Return three EU countries with the lowest reduced VAT rates");
        Map<String, CountryRates> contriesRates = contentService.getRatesForAllContries();
        return diffService.lowestReducedRates(contriesRates);
    }

}
