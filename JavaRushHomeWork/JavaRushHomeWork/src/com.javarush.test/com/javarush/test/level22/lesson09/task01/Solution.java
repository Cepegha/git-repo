package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args)  {
        String line = "";
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in); BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()))) {
            while ((line = reader.readLine()) != null) {
                list.addAll(Arrays.asList(line.toString().trim().split(" ")));
            }

            //System.out.println(list);

            for (int i = 0; i < list.size() ; i++) {
                String s = list.get(i);
                String reverse = new StringBuffer(s).reverse().toString();
                list.remove(s);
                if (list.indexOf(reverse) != -1 & !s.equals("")) {
                    Pair pair = new Pair();
                    pair.first = s;
                    pair.second = reverse;
                    result.add(pair);
                    //list.remove(s);
                    list.remove(reverse);
                    i--;
                }
            }



            for (Pair pair : result) {
                System.out.println(pair);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
