package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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
        String four = reader.readLine();
        int _one = Integer.parseInt(one);
        int _two = Integer.parseInt(two);
        int _three = Integer.parseInt(three);
        int _four = Integer.parseInt(four);
        System.out.println(max(max(_one, _two), max(_three, _four)));
    }
    public static int max(int a, int b) {
        int m;
        m = a > b ? a : b;
        return m;
    }
}