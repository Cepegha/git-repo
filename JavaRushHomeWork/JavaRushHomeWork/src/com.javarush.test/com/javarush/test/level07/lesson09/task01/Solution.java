package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3,
 потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();

        for (int i=0; i<20;i++)
        {   list.add(Integer.parseInt(reader.readLine()));}

        for (int i=0; i<20;i++)
        {
            int x = list.get(i);
            if (x % 3 == 0)  //проверяем, что остаток от деления на два равен нулю
                list3.add(x);          //добавление в конец
            if (x % 2 == 0)  //проверяем, что остаток от деления на два равен нулю
                list2.add(x);          //добавление в конец
            if ((x % 3 != 0)&&(x % 2 != 0))  //проверяем, что остаток от деления на два равен нулю
                list1.add(x);          //добавление в конец
        }
        printList(list3);
        printList(list2);
        printList(list1);
    }

    public static void printList(List<Integer> list)
    {
        //напишите тут ваш код
        for (int i=0;i<list.size();i++)
        System.out.println(list.get(i));
    }
}
