package com.msg.rates.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryStandardRateDto {

    private String country;

    private Double standardRate;

}
