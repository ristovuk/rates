package com.msg.rates.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.msg.rates.model.CountryRates;

import java.io.IOException;

public class CountryRateDeserializer extends JsonDeserializer<CountryRates> {

    @Override
    public CountryRates deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        return new CountryRates(parseStringIfExist(node,"iso_duplicate_of"), parseStringIfExist(node,"country"), parseDoubleIfExist(node,"standard_rate"), parseDoubleIfExist(node, "reduced_rate"), parseDoubleIfExist(node, "reduced_rate_alt"),
                parseDoubleIfExist(node, "super_reduced_rate"), parseDoubleIfExist(node, "parking_rate"));
    }

    private String parseStringIfExist(JsonNode node, String fieldName) {
        return node.has(fieldName) ? node.get(fieldName).asText() : null;
    }

    private Double parseDoubleIfExist(JsonNode node, String fieldName) {
        return node.get(fieldName).isDouble() ? node.get(fieldName).asDouble() : null;
    }
}
