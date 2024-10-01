package com.corndel.supportbank.exercises;

// import java.nio.file.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Adder {
  /**
   * This method reads a file line by line and adds up the numbers on each line.
   * It uses try/catch to print "Something went wrong" and
   * returns 0 in case of an exception.
   *
   * @param fileName The name of the file to be read.
   * @return The sum of the numbers in the file.
   */
  public int add(String fileName){

    try{
    // TODO: Read the file
    // Hint: Use Paths.get() and Files.readAllLines()
    var filePath = Paths.get("src","data", fileName);
    List<String> lines = Files.readAllLines(filePath);

    // TODO: Add up the numbers
    // Hint: Use a loop
    // Hint: Use Integer.parseInt
    int sum = 0;
    for (String i: lines){
      sum += Integer.parseInt(i);
    }

    // TODO: Return the sum
    return sum;}

    catch (Exception e){
      System.err.println("Something went wrong");
      return 0;
    }

  }

  /**
   * Calls the add method and prints the result.
   * This method is for debugging purposes only.
   */
  public static void main(String[] args){
    Adder adder = new Adder();
    System.out.println(adder.add("nums.txt"));


  }
}
