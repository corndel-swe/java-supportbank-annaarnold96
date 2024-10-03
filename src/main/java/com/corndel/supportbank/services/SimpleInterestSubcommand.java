package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Bill;
import com.corndel.supportbank.models.Investment;
import picocli.CommandLine;

@CommandLine.Command(name="simple")
public class SimpleInterestSubcommand implements Runnable{

    @CommandLine.Parameters(index = "0")
    private double investValue;

    @CommandLine.Parameters(index = "1")
    private double percentageInterest;

    @CommandLine.Parameters(index = "2")
    private int years;

    public void run() {
        Investment interest = new Investment(investValue);
        System.out.println(String.format("After %d years with %.2f percent interest, you will earn ", years, percentageInterest) + interest.simpleInterest(percentageInterest,years));
    }

}
