package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String Name = reader.readLine();
        int b=0;
        for (; true; )
        {
            String Name = reader.readLine();
            int Sum= Integer.decode(Name);
            b=b+Sum;
            if (Name.equals("-1"))
                break;
        }
        System.out.println(b);
        /*for (int i=0;i<10;i++) {
            System.out.println(Name+" любит меня.");
        }*/
    }
}
