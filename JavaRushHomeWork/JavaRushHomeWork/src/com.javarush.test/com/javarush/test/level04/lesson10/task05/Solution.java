package com.javarush.test.level04.lesson10.task05;

import java.io.*;

/* Таблица умножения
Вывести на экран таблицу умножения 10х10 используя цикл while.
Числа разделить пробелом.
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int s=1;
        int t=1;
        while (s<11) {
            while (t<11) {
                System.out.print(s*t+" ");
                t++;
            }
            t=1;
            System.out.println();
            s++;
        }
    }
}
