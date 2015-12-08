package com.javarush.test.level04.lesson16.home04;

import java.io.*;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String Name = reader.readLine();
        String y = reader.readLine();
        String m = reader.readLine();
        String d = reader.readLine();

        int A = Integer.parseInt(d);
        int B = Integer.parseInt(m);
        int C = Integer.parseInt(y);

        System.out.println("Меня зовут "+Name);
        System.out.println("Я родился "+A+"."+B+"."+C);

       /* int b=0;
        for (; true; )
        {
            String Name = reader.readLine();
            int Sum= Integer.decode(Name);
            b=b+Sum;
            if (Name.equals("-1"))
                break;
        }
        System.out.println(b);*/
    }
}
