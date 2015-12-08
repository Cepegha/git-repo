package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            throw new NullPointerException("demo");
        } catch (NullPointerException e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IllegalAccessException("demo");
        } catch (IllegalAccessException  e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new RuntimeException("demo");
        } catch (RuntimeException  e)
        {
            exceptions.add(e);
        }

        try {throw new ArrayIndexOutOfBoundsException ("demo"); } catch (ArrayIndexOutOfBoundsException e) {exceptions.add(e);}
        try {throw new NumberFormatException ("demo"); } catch (NumberFormatException e) {exceptions.add(e);}
        try {throw new SecurityException ("demo"); } catch (SecurityException e) {exceptions.add(e);}
        try {throw new UnsupportedOperationException ("demo"); } catch (UnsupportedOperationException e) {exceptions.add(e);}
        try {throw new ClassNotFoundException ("demo"); } catch (ClassNotFoundException e) {exceptions.add(e);}
        try {throw new CloneNotSupportedException ("demo"); } catch (CloneNotSupportedException e) {exceptions.add(e);}
    }
}
