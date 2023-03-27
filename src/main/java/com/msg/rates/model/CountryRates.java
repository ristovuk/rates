package com.msg.rates.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.msg.rates.util.CountryRateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = CountryRateDeserializer.class)
public class CountryRates {

    @JsonProperty("iso_duplicate_of")
    private String isoDuplicateOf;
    @JsonProperty("country")
    private String country;
    @JsonProperty("standard_rate")
    private Double standardRate;
    @JsonProperty("reduced_rate")
    private Double reducedRate;
    @JsonProperty("reduced_rate_alt")
    private Double reducedRateAlt;
    @JsonProperty("super_reduced_rate")
    private Double superReducedRate;
    @JsonProperty("parking_rate")
    private Double parkingRate;
}
