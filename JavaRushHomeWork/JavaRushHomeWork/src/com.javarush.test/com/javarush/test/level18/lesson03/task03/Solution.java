package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        while (fileInputStream.available() > 0) {
            int temp = fileInputStream.read();
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                int value = map.get(temp);
                map.put(temp, value + 1);
            }
        }
        for (Integer perem : map.values()) {
            if (perem > max) max = perem;
        }
        //test
        for (Map.Entry<Integer, Integer> integerEntry : map.entrySet()) {
            if (integerEntry.getValue() == max)
                System.out.print(integerEntry.getKey() + " ");
        }
        fileInputStream.close();
    }
}
