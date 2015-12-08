package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Vasilki on 20.09.2015.
 */
public class Computer {
    private Keyboard keyb= new Keyboard();
    private Monitor mon=new Monitor();
    private Mouse mou=new Mouse();


    public Computer() {
        this.keyb = keyb;
        this.mon = mon;
        this.mou = mou;
    }

    public Keyboard getKeyboard() {
        return keyb;
    }

    public Monitor getMonitor() {
        return mon;
    }

    public Mouse getMouse() {
        return mou;
    }
}
