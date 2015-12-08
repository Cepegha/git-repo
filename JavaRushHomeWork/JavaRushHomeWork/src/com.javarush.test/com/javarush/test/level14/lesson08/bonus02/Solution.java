package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int max = a;
        int min = b;
        int temp, i = 0;
        if (a < b) {
            max = b;
            min = a;
        }
        if (a > b) {
            max = a;
            min = b;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(max);
        list.add(min);
        while (!(list.get(i) % list.get(i + 1) == 0)) {
            list.add(i + 2, (list.get(i) % list.get(i + 1)));
            i++;
        }
        System.out.println(list.get(list.size()-1));

    }
}
