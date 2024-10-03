package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Currency;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Unirest;
import picocli.CommandLine;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

@CommandLine.Command(name = "exchange")
public class CurrencyExchangeListSubcommand implements Runnable{

    @CommandLine.Parameters(index = "0")
    private String currentCurrencyType;

//    @CommandLine.Parameters(index = "0")
//    private double value;

    @Override
    public void run() {
        Currency exchangeList = new Currency(0);

        var mapOfRates = exchangeList.exchangeAPI(currentCurrencyType);
        HashMap<String, Float> rates = new HashMap<>();
        rates = (HashMap<String, Float>) mapOfRates.get("rates");
        System.out.println(rates);
//        System.out.println(rates.get("EUR"));
        //rates.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
