package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        String three = reader.readLine();
        int _one = Integer.parseInt(one);
        int _two = Integer.parseInt(two);
        int _three = Integer.parseInt(three);
        if (_one>=_two && _one>=_three)
        {
            if (_two>=_three)
                System.out.println(_one+" "+_two+" "+_three);
            else
                System.out.println(_one+" "+_three+" "+_two);
        }
        if (_two>=_one && _two>=_three)
        {
            if (_one>=_three)
                System.out.println(_two+" "+_one+" "+_three);
            else
                System.out.println( two+" "+_three+" "+_one);
        }
        if (_three>=_one && _three>=_two)
        {
            if (_one>=_two)
                System.out.println(_three+" "+_one+" "+_two);
            else
                System.out.println( three+" "+_two+" "+_one);
        }

  /*      System.out.println(max(_one,_two),_three));
    }
    public static int max(int a, int b) {
        int m;
        m = a > b ? a : b;
        return m;
    }
}*/
    }
}
