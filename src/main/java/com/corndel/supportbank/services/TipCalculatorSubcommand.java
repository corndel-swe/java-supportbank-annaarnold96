package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Bill;
import picocli.CommandLine;

@CommandLine.Command(name="tip")
public class TipCalculatorSubcommand implements Runnable{

    @CommandLine.Parameters(index = "0")
    private double price;

    @CommandLine.Parameters(index = "1")
    private String serviceQuality;

    public void run() {
        Bill bill = new Bill(price);
        double tipOnly = bill.tip(serviceQuality);
        double billIncTip = tipOnly + price;
        System.out.println("The tip will be £" + tipOnly + ", bringing the total to £" + billIncTip);
    }

}
