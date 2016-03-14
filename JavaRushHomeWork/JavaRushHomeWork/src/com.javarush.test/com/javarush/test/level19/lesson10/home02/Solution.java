package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> treeMap=new TreeMap<String, Double>();

        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));

        String s;
        Double max=0.000;

        while (reader.ready()) {
            s = reader.readLine();
            String[] lines = s.split(" ");
            if (!treeMap.containsKey(lines[0])) {
                treeMap.put(lines[0], Double.parseDouble(lines[1]));
            } else {
                Double value = Double.parseDouble(lines[1]) + treeMap.get(lines[0]);
                treeMap.put(lines[0], value);
            }
        }

        for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
            if (entry.getValue()>max)
                max=entry.getValue();
        }

        for(Map.Entry e : treeMap.entrySet()){
            if (e.getValue()==max){
            System.out.println(e.getKey());}
        }

        reader.close();
    }
}
