package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        File f=new File(bufferedReader.readLine());
        FileReader file_one=new FileReader(f);
        BufferedReader reader=new BufferedReader(file_one);

        int numberofwords=0;
        char[] buffer=new char[(int)f.length()];
        file_one.read(buffer);
/*
        for (int i=0; i<buffer.length-4; i++)
        {
            String temp=" "+buffer[i]+buffer[i+1]+buffer[i+2]+buffer[i+3]+buffer[i+4]+"";
            if (temp.contains("world")){
                numberofwords++;
            }
        }
*/
        String str=Arrays.toString(buffer);
        Pattern pattern = Pattern.compile("world");
        Matcher matcher= pattern.matcher(str);
        while (matcher.find()){
            numberofwords++;
        }
        System.out.println(numberofwords);
        System.out.println(str);

        bufferedReader.close();
        file_one.close();
        reader.close();
    }
}
