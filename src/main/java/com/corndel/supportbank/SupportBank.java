package com.corndel.supportbank;

import com.corndel.supportbank.controllers.BillController;
import com.corndel.supportbank.controllers.CurrencyController;
import com.corndel.supportbank.controllers.InvestmentController;
import com.corndel.supportbank.controllers.TransactionController;
import com.corndel.supportbank.exercises.HelloWorld;
import com.github.tomaslanger.chalk.Chalk;
import picocli.CommandLine;


@CommandLine.Command(name = "supportbank", subcommands = {BillController.class, CurrencyController.class, InvestmentController.class, TransactionController.class})
public class SupportBank {

  public static void main(String[] args) {

    CommandLine cli = new CommandLine(new SupportBank());
    int exitCode = cli.execute(args);
    System.exit(exitCode);
  }
}
