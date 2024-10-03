package com.corndel.supportbank.controllers;


import com.corndel.supportbank.services.CurrencyConverterSubcommand;
import com.corndel.supportbank.services.CurrencyExchangeListSubcommand;
import picocli.CommandLine;

@CommandLine.Command(name = "currency", subcommands = {CurrencyConverterSubcommand.class, CurrencyExchangeListSubcommand.class})
public class CurrencyController {

}