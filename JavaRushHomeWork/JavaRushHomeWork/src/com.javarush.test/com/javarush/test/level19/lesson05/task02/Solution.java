package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file_one=new BufferedReader(new FileReader(bufferedReader.readLine()));

        int numberofwords=0;
        String line="";

        while(file_one.ready()){
            line=file_one.readLine().toLowerCase();
            line= line.replaceAll("\\p{Punct}", " ").replaceAll("\\p{Blank}"," ");
            Pattern pattern = Pattern.compile("\\bworld\\b");
            Matcher matcher= pattern.matcher(line);
            while (matcher.find()){
                numberofwords++;
            }
        }
        System.out.println(numberofwords);

        bufferedReader.close();
        file_one.close();
    }
}
