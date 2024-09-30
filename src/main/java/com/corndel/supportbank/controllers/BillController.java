package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.BillSplitterSubcommand;
import picocli.CommandLine;

@CommandLine.Command(name = "bill", subcommands = BillSplitterSubcommand.class)
public class BillController {

}
