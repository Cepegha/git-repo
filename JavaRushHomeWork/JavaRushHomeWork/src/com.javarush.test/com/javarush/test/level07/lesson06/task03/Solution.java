package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5;i++)
        {   String s = reader.readLine();
            list.add(s);}

        int min=list.get(0).length();
        for (int j=0; j<5;j++)
        {if (min>=list.get(j).length())
            min=list.get(j).length();}

        for (int k=0; k<5;k++) {
            if (list.get(k).length() == min) {
                System.out.println(list.get(k));
            }
        }
    }
}
