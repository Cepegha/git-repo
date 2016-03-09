package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

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
            temp=line.replaceAll("\\.","!");
            //System.out.println(temp);
            file_two.write(temp);
        }

        bufferedReader.close();
        file_one.close();
        file_two.close();
    }
}
