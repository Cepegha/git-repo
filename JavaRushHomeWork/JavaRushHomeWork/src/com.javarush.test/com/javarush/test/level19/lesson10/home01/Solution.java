package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> treeMap=new TreeMap<String, Double>();

        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));

        String s;

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

        for(Map.Entry e : treeMap.entrySet()){

            System.out.println(e.getKey()+" "+ e.getValue());
        }

        reader.close();
    }
}
