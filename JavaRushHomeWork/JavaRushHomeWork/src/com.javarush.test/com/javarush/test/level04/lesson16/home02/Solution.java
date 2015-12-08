package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      /*  String n = reader.readLine();
        String m = reader.readLine();
        String l = reader.readLine();
        int a = Integer.parseInt(n);
        int b = Integer.parseInt(m);
        int c = Integer.parseInt(l);

        if (a>b) {
            System.out.println("asdasd");
        }
        if ((a>c)&&(c>b)) {System.out.println(c);}
        if ((c>a)&&(a>b)) {System.out.println(a);}*/
        String one = reader.readLine();
        String two = reader.readLine();
        String three = reader.readLine();
        int _one = Integer.parseInt(one);
        int _two = Integer.parseInt(two);
        int _three = Integer.parseInt(three);
        if (_one>=_two && _one>=_three)
        {
            if (_two>=_three)
                System.out.println(_two);
            else
                System.out.println(_three);
        }
        if (_two>=_one && _two>=_three)
        {
            if (_one>=_three)
                System.out.println(_one);
            else
                System.out.println(_three);
        }
        if (_three>=_one && _three>=_two)
        {
            if (_one>=_two)
                System.out.println(_two);
            else
                System.out.println(_two);
        }
    }
}
