package com.corndel.supportbank.exercises;

import picocli.CommandLine;
import picocli.CommandLine.Command;
// import picocli.CommandLine.Parameters;

@Command(name = "hello", description = "A CLI that prints hello")
public class HelloWorld implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello, World!");
    }

}
