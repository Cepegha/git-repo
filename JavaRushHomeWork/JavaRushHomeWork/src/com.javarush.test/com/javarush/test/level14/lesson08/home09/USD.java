package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Vasilki on 20.09.2015.
 */
public class USD extends Money{

    public USD(double amount) {
        super(amount);
    }

    public String getCurrencyName()
    {
        return "USD";
    }
}
