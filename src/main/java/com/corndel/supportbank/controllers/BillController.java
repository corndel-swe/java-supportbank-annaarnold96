package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.BillSplitterSubcommand;
import com.corndel.supportbank.services.TipCalculatorSubcommand;
import picocli.CommandLine;

@CommandLine.Command(name = "bill", subcommands = {BillSplitterSubcommand.class, TipCalculatorSubcommand.class})
public class BillController implements Runnable {

    @Override
    public void run() {
        System.out.println("Options for the bill:");
        System.out.println("tip: Calculate the tip");
        System.out.println("splitter: Calculate the split of the bill");
    }
}
