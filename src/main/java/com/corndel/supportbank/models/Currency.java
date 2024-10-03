package com.corndel.supportbank.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
record Exchange(String country, float rate) {
}

public class Currency {

    private double value;
    private double exchangeValue;

    public Currency(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double convert(String currentCurrencyType, String exchangeCurrencyType, HashMap currentExchangeRate) {

        HashMap<String, Double> rates = (HashMap<String, Double>) currentExchangeRate.get("rates");

        if (currentCurrencyType.equals("GBP")) {
            if (exchangeCurrencyType.equals("USD")) {
                exchangeValue = value * rates.get("USD");
            } else if (exchangeCurrencyType.equals("EUR")) {
                exchangeValue = value * rates.get("EUR");
            }
        } else if (currentCurrencyType.equals("USD")) {
            if (exchangeCurrencyType.equals("GBP")) {
                exchangeValue = value * rates.get("GBP");
            } else if (exchangeCurrencyType.equals("EUR")) {
                exchangeValue = value * rates.get("EUR");
            }
        } else if (currentCurrencyType.equals("EUR")) {
            if (exchangeCurrencyType.equals("GBP")) {
                exchangeValue = value * rates.get("GBP");
            } else if (exchangeCurrencyType.equals("USD")) {
                exchangeValue = value * rates.get("USD");
            }
        }
        return exchangeValue;
    }

    public HashMap<String, Object> exchangeAPI(String currentCurrencyType){

        //Get the app api ID
        Dotenv dotenv = Dotenv.load();

        var id = dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");

        var url = "https://openexchangerates.org/api/latest.json?app_id=" + id +"&base=" + currentCurrencyType;

        // run the API request
        var response = Unirest.get(url).header("Accept", "application/json").asString();

        String json = response.getBody();

        try {
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, Object> exchangeTree = (HashMap<String, Object>) mapper.readValue(json, new TypeReference<Map<String,Object>>(){});
            return exchangeTree;

        }catch (Exception e) {
            System.out.println("This didn't work");
            return null;
        }


    }

        @Override
    public String toString() {
        return "Currency{" +
                ", exchangeValue=" + exchangeValue +
                '}';
}
}
