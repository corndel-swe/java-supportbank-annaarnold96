package com.corndel.supportbank.exercises;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;



@Command(name = "hello", description = "A CLI that prints hello")
public class HelloWorld implements Runnable{

    @Parameters(index = "0", description = "The name to greet", defaultValue = "World")
    private String name;

    @Override
    public void run() {
        String msg = String.format("Hello, %s!", name);
        System.out.println(msg);
    }

}
