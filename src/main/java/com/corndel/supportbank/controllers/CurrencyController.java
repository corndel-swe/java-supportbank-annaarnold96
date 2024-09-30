package com.corndel.supportbank.controllers;


import com.corndel.supportbank.services.CurrencyConverterSubcommand;
import picocli.CommandLine;

@CommandLine.Command(name = "currency", subcommands = CurrencyConverterSubcommand.class)
public class CurrencyController {

}