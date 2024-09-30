package com.corndel.supportbank.models;

public class Investment {

    private double investValue;

    public Investment(double investValue) {
        this.investValue = investValue;
    }

    public double getPrice() {
        return investValue;
    }

    public void setPrice(double price) {
        this.investValue = investValue;
    }

    public double simpleInterest(double percentageInterest, int years) {
        return (percentageInterest/100 * investValue) * years;
    }



    @Override
    public String toString() {
        return "Investment{" +
                ", investValue=" + investValue +
                '}';
    }
}
