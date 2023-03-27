package com.msg.rates.service;

import com.msg.rates.model.CountryRates;
import com.msg.rates.util.JsonDeserializer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j2
public class CountryRatesDataService {

    private final JsonDeserializer jsonDeserializer;
    @Value("${rates.api.uri}")
    private String url;

    public CountryRatesDataService(JsonDeserializer jsonDeserializer) {
       this.jsonDeserializer = jsonDeserializer;
   }


    public Map<String, CountryRates> getRatesForAllContries() throws IOException {

        String contriesRatesJson = readJsonFromUrl();

        Map<String, CountryRates> rates = jsonDeserializer.deserializeRates(contriesRatesJson).rates();

        return removeISODuplicate(rates);
    }

    private Map<String, CountryRates> removeISODuplicate(Map<String, CountryRates> rates) {
        Map<String, CountryRates> filteredRates = new HashMap<>();

        rates.entrySet()
                .stream()
                .forEach(countryRates -> {
                    if (countryRates.getValue().getIsoDuplicateOf() == null || (countryRates.getValue().getIsoDuplicateOf() != null && !filteredRates.containsKey(countryRates.getValue().getIsoDuplicateOf()))) {
                        filteredRates.put(countryRates.getKey(), countryRates.getValue());
                    }
                });
        return filteredRates;

    }


    public String readJsonFromUrl() throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            Reader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return jsonText;
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}
