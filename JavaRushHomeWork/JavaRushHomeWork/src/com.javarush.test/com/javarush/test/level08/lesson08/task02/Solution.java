package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        Set<Integer> set=new HashSet<Integer>();
        set.add(10);
        set.add(11);
        set.add(12);
        set.add(13);
        set.add(14);
        set.add(15);
        set.add(16);
        set.add(17);
        set.add(9);
        set.add(18);
        set.add(7);
        set.add(1);
        set.add(20);
        set.add(5);
        set.add(4);
        set.add(3);
        set.add(21);
        set.add(31);
        set.add(32);
        set.add(33);
        return (HashSet<Integer>) set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
       Iterator<Integer> iterator=set.iterator();
        while (iterator.hasNext())
        {
            int i=iterator.next();
            if (i>10)
                iterator.remove();
        }

        return (HashSet<Integer>)set;
    }
}
