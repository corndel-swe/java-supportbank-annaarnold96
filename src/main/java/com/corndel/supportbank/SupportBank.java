package com.corndel.supportbank;

import com.corndel.supportbank.exercises.HelloWorld;
import com.github.tomaslanger.chalk.Chalk;
import picocli.CommandLine;

public class SupportBank {

  public static void main(String[] args) {
    System.out.println(Chalk.on("Build your CLI here!").blue());

    CommandLine cli = new CommandLine(new HelloWorld());
    int exitCode = cli.execute(args);
    System.exit(exitCode);
  }
}
