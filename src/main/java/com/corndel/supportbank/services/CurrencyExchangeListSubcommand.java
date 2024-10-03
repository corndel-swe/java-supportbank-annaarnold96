package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Currency;
import kong.unirest.Unirest;
import picocli.CommandLine;
import io.github.cdimascio.dotenv.Dotenv;

@CommandLine.Command(name = "exchange")
public class CurrencyExchangeListSubcommand implements Runnable{

//    @CommandLine.Parameters(index = "0")
//    private double value;

    @Override
    public void run() {
        //Get the app api ID
        Dotenv dotenv = Dotenv.load();

        var id = dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");

        var url = "https://openexchangerates.org/api/latest.json?app_id=" + id;

        // run the API request
        var response = Unirest.get(url).header("Accept", "application/json").asString();

        String json = response.getBody();

        System.out.println(json);

    }
}
