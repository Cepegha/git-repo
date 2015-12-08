package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] list=new ArrayList[5];
        ArrayList<String> listik1=new ArrayList<String>();
        listik1.add(0,"sdad");
        listik1.add(0,"asd");
        list[0]=listik1;
        ArrayList<String> listik2=new ArrayList<String>();
        listik2.add(0,"sdad");
        listik2.add(0,"asd");
        list[1]=listik2;
        ArrayList<String> listik3=new ArrayList<String>();
        listik3.add(0,"sdad");
        listik3.add(0,"asd");
        list[2]=listik3;
        ArrayList<String> listik4=new ArrayList<String>();
        listik4.add(0,"sdad");
        listik4.add(0,"asd");
        list[3]=listik4;
        ArrayList<String> listik5=new ArrayList<String>();
        listik5.add(0,"sdad");
        listik5.add(0,"asd");
        list[4]=listik5;

        /*for (int i=0;i<list.length;i++)
        {
            list[i]=listik1;
        }*/

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}