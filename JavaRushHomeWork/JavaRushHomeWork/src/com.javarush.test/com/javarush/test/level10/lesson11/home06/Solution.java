package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        boolean sex;
        String LastName;
        int height;
        int wight;

        Human (String name)
        {
            this.name=name;
        }
        Human (int age)
        {
            this.age=age;
        }
        Human (boolean sex)
        {
            this.sex=sex;
        }
        Human (String name,int age)
        {
            this.name=name;
            this.age=age;
        }
        Human (String name,boolean sex)
        {
            this.name=name;
            this.sex=sex;
        }
        Human (boolean sex,String name)
        {
            this.name=name;
            this.sex=sex;
        }
        Human (int age, boolean sex)
        {
            this.age=age;
            this.sex=sex;
        }
        Human (boolean sex,int age)
        {
            this.age=age;
            this.sex=sex;
        }
        Human (String name,int age,boolean sex)
        {
            this.name=name;
            this.age=age;
            this.sex=sex;
        }
        Human (int age,boolean sex,String name)
        {
            this.name=name;
            this.age=age;
            this.sex=sex;
        }
    }
}
