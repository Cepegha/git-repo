package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Vasilki on 28.09.2015.
 */
public class Plane implements Flyable {
    int passangers;
    public void fly(){};
    Plane(int passangers)
    {
        this.passangers=passangers;
    }
}
