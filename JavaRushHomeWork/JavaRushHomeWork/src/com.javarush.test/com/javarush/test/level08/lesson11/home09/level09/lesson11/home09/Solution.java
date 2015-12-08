package com.javarush.test.level08.lesson11.home09.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        HashMap<String, Cat> map =new HashMap<String, Cat>();
        Cat cat1=new Cat("cat1");
        Cat cat2=new Cat("cat2");
        Cat cat3=new Cat("cat3");
        Cat cat4=new Cat("cat4");
        Cat cat5=new Cat("cat5");
        Cat cat6=new Cat("cat6");
        Cat cat7=new Cat("cat7");
        Cat cat8=new Cat("cat8");
        Cat cat9=new Cat("cat9");
        Cat cat10=new Cat("cat10");
        map.put("Cat1", cat1);
        map.put("Cat2",cat2);
        map.put("Cat3",cat3);
        map.put("Cat4",cat4);
        map.put("Cat5",cat5);
        map.put("Cat6",cat6);
        map.put("Cat7",cat7);
        map.put("Cat8",cat8);
        map.put("Cat9",cat9);
        map.put("Cat10",cat10);

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> set =new HashSet<Cat>();
        for (Map.Entry<String,Cat> mapsik:map.entrySet())
        {
            set.add(mapsik.getValue());
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
