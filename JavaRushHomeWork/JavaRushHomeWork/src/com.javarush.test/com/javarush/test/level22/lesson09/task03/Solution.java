package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        //...
        String line;
        String[] word;
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in); BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()))) {
            while ((line = reader.readLine()) != null) {
                list.addAll(Arrays.asList(line.toString().substring(0).trim().split(" ")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        word= new String[list.size()];
        int i=0;
        for (String s : list) {
        word[i]=s;
            i++;
        }
        StringBuilder result = getLine(word);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);

        int count_words_in_line= words.length;
        ArrayList<String> list = new ArrayList<String>();
        int count=1;
        StringBuilder result= new StringBuilder("");
        do {
            for (int i=0; i<words.length; i++) {
                list.add(words[i]);
            }
            //перемешать
            Collections.shuffle(list);
            //добавить первое слово
            result.append(list.get(0));
            //удалить первое слово из списка
            list.remove(0);
            //перебор оставшихся слов
            int temp=0;
            for (int i=0; list.size()>0;i++) {
                temp++;
                if (i >= list.size()) i = 0;
                if ((result.substring(result.length()-1)).toUpperCase().equals((list.get(i).substring(0,1).toUpperCase()))) {
                   // System.out.println(result.substring(result.length()-1).toUpperCase()+" *** "+list.get(i).toUpperCase().charAt(i));
                        result.append(" " + list.get(i));
                        list.remove(i);
                        count++;
                }
                if (temp>count_words_in_line*count_words_in_line) break;
            }

            if (count!=count_words_in_line) {
                count=1;
                result.replace(0,result.length(),"");
            }
        } while (count!=count_words_in_line);

        return result;
    }
}
