package com.msg.rates.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryReducedRatesDto {

    private String country;

    private Double reducedRate;
}

