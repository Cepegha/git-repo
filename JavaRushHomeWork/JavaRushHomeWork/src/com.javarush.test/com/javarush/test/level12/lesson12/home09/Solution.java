package com.javarush.test.level12.lesson12.home09;

/* Родитель класса CTO
Добавь такой класс-родитель к классу CTO(технический директор), чтобы класс перестал быть абстрактным.
Добавлять/реализовывать методы в классе CTO запрещается.
*/

import java.util.Objects;

public class Solution
{

    public static void main(String[] args)
    {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman
    {
        public void workHard();
    }

    static class Rod{
        public void workHard()
        {System.out.println("test");};
    };

    public static class CTO extends Rod implements Businessman
    {

    }


}
