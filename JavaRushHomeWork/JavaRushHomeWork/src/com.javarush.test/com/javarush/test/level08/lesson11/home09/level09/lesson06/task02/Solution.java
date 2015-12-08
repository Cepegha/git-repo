package com.javarush.test.level08.lesson11.home09.level09.lesson06.task02;

/* Исключение при работе со строками
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
String s = null;
String m = s.toLowerCase();
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        try {
            String s = null;
            String m = s.toLowerCase();
        }
        catch (NullPointerException e)
        {
            System.out.println(e);
        }
        //напишите тут ваш код

    }
}
