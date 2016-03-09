package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file_one=new BufferedReader(new FileReader(bufferedReader.readLine()));
        FileWriter file_two=new FileWriter(bufferedReader.readLine());

        String line="";
        String temp="";

        while(file_one.ready()){
            line=file_one.readLine();
            //System.out.println(line);
            Pattern pattern = Pattern.compile("\\b[0-9]+\\b");
            Matcher matcher= pattern.matcher(line);
            while (matcher.find()){
                temp= line.substring(matcher.start(), matcher.end()) + " ";
                //System.out.print(temp);
                file_two.write(temp);
            }
        }

        bufferedReader.close();
        file_one.close();
        file_two.close();
    }
}
