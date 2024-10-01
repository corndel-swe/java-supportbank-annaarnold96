package com.corndel.supportbank.services;

import com.corndel.supportbank.exercises.Adder;
import com.corndel.supportbank.models.Bill;
import com.corndel.supportbank.models.Transaction;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * List
 * create a hashmap to store names and amounts (str, double)
 * for each row in file check if name is in from or to
 * if true, add to transaction list
 * print list
 *
 * */

@CommandLine.Command(name="list")
public class ListTransactionSubcommand implements Runnable{

    @CommandLine.Parameters(index = "0")
    private String fileName;

    @CommandLine.Parameters(index = "1")
    private String accountName;


    Map<String, Double> accounts = new HashMap<>();

    public void run() {
        Transaction transaction = new Transaction();
        System.out.println(transaction.summarise(fileName));
    }
}
