package com.corndel.supportbank.controllers;


import com.corndel.supportbank.services.SimpleInterestSubcommand;
import picocli.CommandLine;

@CommandLine.Command(name = "invest", subcommands = SimpleInterestSubcommand.class)
public class InvestmentController {

}