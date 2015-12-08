package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human hum1= new Human();
        Human hum2= new Human();
        Human hum3= new Human();
        Human hum4= new Human();
        Human hum5= new Human();
        Human hum6= new Human();
        Human hum7= new Human();
        Human hum8= new Human();
        Human hum9= new Human();


        hum1.name="Ded1";hum1.age=80;hum1.sex=true;hum1.children.add(0,hum5);
        hum2.name="Ded2";hum2.age=77;hum2.sex=true;hum2.children.add(0,hum6);
        hum3.name="Baba1";hum3.age=78;hum3.sex=false;hum3.children.add(0,hum5);
        hum4.name="Baba2";hum4.age=75;hum4.sex=false;hum4.children.add(0,hum6);
        hum5.name="Dad";hum5.age=55;hum5.sex=true;hum5.children.add(0,hum7);hum5.children.add(0,hum8);hum5.children.add(0,hum9);
        hum6.name="Mom";hum6.age=50;hum6.sex=false;hum6.children.add(0,hum7);hum6.children.add(0,hum8);hum6.children.add(0,hum9);
        hum7.name="Baby1";hum7.age=20;hum6.sex=false;
        hum8.name="Baby2";hum8.age=22;hum6.sex=true;
        hum9.name="Baby3";hum9.age=25;hum6.sex=false;

        System.out.println(hum1.toString());
        System.out.println(hum2.toString());
        System.out.println(hum3.toString());
        System.out.println(hum4.toString());
        System.out.println(hum5.toString());
        System.out.println(hum6.toString());
        System.out.println(hum7.toString());
        System.out.println(hum8.toString());
        System.out.println(hum9.toString());
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children=new ArrayList<Human>();

        /*public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {

        }*/

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
