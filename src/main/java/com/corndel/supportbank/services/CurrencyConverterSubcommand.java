package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Currency;
import picocli.CommandLine;

import java.util.HashMap;

@CommandLine.Command(name = "convert")
public class CurrencyConverterSubcommand implements Runnable{

    @CommandLine.Parameters(index = "0")
    private float value;

    @CommandLine.Parameters(index = "1")
    private String currentCurrencyType;

    @CommandLine.Parameters(index = "2")
    private String exchangeCurrencyType;

    @Override
    public void run() {
        Currency exchange = new Currency(value);

        HashMap currentExchangeRate = exchange.exchangeAPI(currentCurrencyType);

        System.out.println(value + " in " + currentCurrencyType + " will be " + exchange.convert(currentCurrencyType,exchangeCurrencyType,currentExchangeRate) + " " + exchangeCurrencyType);
    }
}
