package com.corndel.supportbank.models;

public class Bill {

    private double price;

    public Bill(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double split(double people) {
        return price / people;
    }

    public double tip(String serviceQuality) {
        if (serviceQuality.equals("great")){
            return price * 0.2;
        }
        else if (serviceQuality.equals("ok")){
            return price * 0.1;
        }
        else return 0;

    }


    @Override
    public String toString() {
        return "Bill{" +
                ", price=" + price +
                '}';
    }
}
