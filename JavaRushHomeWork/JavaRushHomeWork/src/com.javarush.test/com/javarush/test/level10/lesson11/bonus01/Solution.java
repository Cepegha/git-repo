package com.javarush.test.level10.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа демонстрирует работу HashMap: вводит с клавиатуры набор пар (номер и строку),
помещает их в HashMap и выводит на экран содержимое HashMap.
*/

public class Solution {
    HashMap<Integer, String> map=new HashMap<Integer,String>();
    Integer index;
    String name;

    public Solution() {
        this.map = new HashMap<Integer, String>();
      //  map.put(index, name);
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int index3 = Integer.parseInt(reader.readLine());
            String name3 = reader.readLine();
            solution.map.put(index3, name3);
        }

        for (Map.Entry<Integer, String> pair : solution.map.entrySet()) {
            int index2 = pair.getKey();
            String name2 = pair.getValue();
            System.out.println("Id=" + index2 + " Name=" + name2);
        }
    }
}
