package com.corndel.supportbank.models;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction {

    private String fileName;


    public Map<String ,Double> summarise(String fileName) {
        try {
            Path filePath = Paths.get("src", "data", "transactions", fileName);
            List<String> lines = Files.readAllLines(filePath);

            Map<String, Double> accounts = new HashMap<>();
//            double sumTotal = 0;
//            double sumMinus = 0;

            for (var i = 1; i < lines.size(); i++) {
                String[] person = lines.get(i).split(",");
                double amount = Double.parseDouble(person[4]);
                String usernameFrom = person[1];
                String usernameTo = person[2];
                // ************ Printing transactions ***************
//                System.out.println(usernameFrom + " : " + amount);

//                // **********Checking correct amounts**************
//                if (usernameFrom.equals("Sarah T")){
//                    sumTotal -= amount;
//                }
//                if (usernameTo.equals("Sarah T")){
//                    sumMinus += amount;
//                }
//                System.out.println(sumMinus +  sumTotal + " = " + (sumMinus + sumTotal));


                double oldBalance = accounts.containsKey(usernameFrom) ? accounts.get(usernameFrom) : 0.0;
                double newBalance = oldBalance - amount;
                accounts.put(usernameFrom, newBalance);

                double oldBalanceTo = accounts.containsKey(usernameTo) ? accounts.get(usernameTo) : 0.0;
                double newBalanceTo = oldBalanceTo + amount;
                accounts.put(usernameTo, newBalanceTo);

            }return accounts;
        }

        catch (Exception e){
            System.out.println("This did not work :(");
            return null;
        }


    }



}


//    @Override
//    public String toString() {
//        return "Bill{" +
//                ", price=" + price +
//                '}';
//    }
//}
