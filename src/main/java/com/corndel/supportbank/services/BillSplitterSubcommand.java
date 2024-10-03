package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Bill;
import picocli.CommandLine;

@CommandLine.Command(name="splitter")
public class BillSplitterSubcommand implements Runnable{

    @CommandLine.Parameters(index = "0")
    private double price;

    @CommandLine.Parameters(index = "1")
    private double people;

    public void run() {
        Bill bill = new Bill(price);
        System.out.println(bill);
        System.out.println("The bill will be £" + bill.split(people) + " per person");
    }

}
