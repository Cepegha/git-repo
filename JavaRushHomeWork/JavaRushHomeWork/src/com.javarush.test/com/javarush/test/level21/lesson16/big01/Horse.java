package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Sergei.Sasinovich on 05.04.2016.
 */
public class Horse {
    private String name;
    private double speed;
    private double distance;

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public void move(){
        distance += speed*Math.random();
    }

    public void print(){
        StringBuilder sb=new StringBuilder();
        for (int i=0; i<(int)getDistance();i++)
        {sb.append(".");}
        System.out.println(sb+getName());
    }

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
}
