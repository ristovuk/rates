package com.msg.rates.util;

import com.msg.rates.model.CountryRates;

import java.util.Map;

public record RatesWrapper(String last_updated, String disclaimer, Map<String, CountryRates> rates) {
}
