package com.msg.rates.service;

import com.msg.rates.dto.CountryReducedRatesDto;
import com.msg.rates.dto.CountryStandardRateDto;
import com.msg.rates.model.CountryRates;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CountryRatesDiffService {


    public List<CountryStandardRateDto> highestStandardRates(Map<String, CountryRates> rates) {

        return rates
                .values()
                .stream()
                .filter(countryVatRate -> countryVatRate.getStandardRate() != null)
                .sorted(Comparator.comparingDouble(CountryRates::getStandardRate).reversed())
                .limit(3)
                .map(countryRates -> new CountryStandardRateDto(countryRates.getCountry(),countryRates.getStandardRate()))
                .collect(Collectors.toList());

    }

    public List<CountryReducedRatesDto> lowestReducedRates(Map<String, CountryRates> rates)  {

        return rates
                .values()
                .stream()
                .filter(countryVatRate -> countryVatRate.getReducedRate() != null)
                .sorted(Comparator.comparingDouble(CountryRates::getReducedRate))
                .map(countryRates -> new CountryReducedRatesDto(countryRates.getCountry(),countryRates.getReducedRate()))
                .limit(3)
                .collect(Collectors.toList());
    }

}
