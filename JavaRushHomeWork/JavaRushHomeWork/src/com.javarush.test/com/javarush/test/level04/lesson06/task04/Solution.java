package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение
«Имена идентичны». Если имена разные, но их длины равны – вывести сообщение
– «Длины имен равны».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String one = reader.readLine();
        String two = reader.readLine();

        int a=one.length();
        int b=two.length();

        if (one.equals(two))
            System.out.println("Имена идентичны");
       else {
        if (a==b)
            System.out.println("Длины имен равны");
            }
       /* else {
            if (one.length()==two.length())
                System.out.println("Длины имен равны");
            else
                System.out.println("Имена и их длины не равны");
        }*/
    }
}
