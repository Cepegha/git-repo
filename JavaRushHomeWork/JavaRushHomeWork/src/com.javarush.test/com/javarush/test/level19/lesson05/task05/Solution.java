package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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
            temp=line.replaceAll("\\p{Punct}","");
            //System.out.println(temp);
            file_two.write(temp);
        }

        bufferedReader.close();
        file_one.close();
        file_two.close();
    }
}
