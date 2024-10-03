package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.BillSplitterSubcommand;
import com.corndel.supportbank.services.ListTransactionSubcommand;
import com.corndel.supportbank.services.SummariseSubcommand;
import com.corndel.supportbank.services.TipCalculatorSubcommand;
import picocli.CommandLine;

@CommandLine.Command(name = "transaction", subcommands = {SummariseSubcommand.class, ListTransactionSubcommand.class})
public class TransactionController implements Runnable {

    @Override
    public void run() {
        System.out.println("Options for transaction:");
        System.out.println("summarise:  should output the names of each person, and their current balance according to the given file");
        System.out.println("list: should print a list of every transaction, with the date and narrative, for that person’s account.");
    }
}
