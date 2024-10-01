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
 * Summarise
 * create a hashmap to store names and amounts (str, double)
 * for each row in file (each index in list)
 *
 * */

@CommandLine.Command(name="summarise")
public class SummariseSubcommand implements Runnable{

    @CommandLine.Parameters(index = "0")
    private String fileName;

    public void run() {
    Transaction transaction = new Transaction();
        System.out.println(transaction.summarise(fileName));
    }
}
