package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.logging.StreamHandler;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str=reader.readLine();
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("January", "1");
        map.put("February", "2");
        map.put("March", "3");
        map.put("April", "4");
        map.put("May", "5");
        map.put("Jun", "6");
        map.put("July", "7");
        map.put("August", "8");
        map.put("September", "9");
        map.put("October", "10");
        map.put("November", "11");
        map.put("December", "12");

        for (Map.Entry<String,String> maps:map.entrySet())
        {
            if (maps.getKey().equals(str))
                System.out.println(str+" is "+maps.getValue()+" month");

        }


    }

}
