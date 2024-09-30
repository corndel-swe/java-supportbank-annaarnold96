package com.corndel.supportbank.models;

public class Currency {

    private double value;
    private double exchangeValue;

    public Currency(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double convert(String currentCurrencyType, String exchangeCurrencyType) {
        if (currentCurrencyType.equals("GBP")) {
            if (exchangeCurrencyType.equals("USD")) {
                double exchangeValue = value * 5;
            } else if (exchangeCurrencyType.equals("EURO")) {
                double exchangeValue = value * 10;
            }
        } else if (currentCurrencyType.equals("USD")) {
            if (exchangeCurrencyType.equals("GBP")) {
                double exchangeValue = value * 50;
            } else if (exchangeCurrencyType.equals("EURO")) {
                double exchangeValue = value * 100;
            }
        } else if (currentCurrencyType.equals("EURO")) {
            if (exchangeCurrencyType.equals("GBP")) {
                double exchangeValue = value * 20;
            } else if (exchangeCurrencyType.equals("USD")) {
                double exchangeValue = value * 500;
            }
        }
        return exchangeValue;
    }

//        @Override
//    public String toString() {
//        return "Currency{" +
//                ", exchangeValue=" + exchangeValue +
//                '}';
//}
}
