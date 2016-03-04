package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        FileReader file_one= new FileReader(reader.readLine());
        FileWriter file_two= new FileWriter(reader.readLine());

        while (file_one.ready())
        {
            int buffer=file_one.read();
            file_two.write(file_one.read());
        }

        reader.close();
        file_one.close();
        file_two.close();
    }
}
