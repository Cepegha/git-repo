package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStreamOne = new FileInputStream(reader.readLine());
        FileOutputStream outputStreamTwo = new FileOutputStream(reader.readLine());

        if (fileInputStreamOne.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[fileInputStreamOne.available()];
            int count = fileInputStreamOne.read(buffer);
            byte perem;

            for (int temp = 0; temp < buffer.length / 2; temp++) {
                perem = buffer[temp];
                buffer[temp] = buffer[buffer.length - 1 - temp];
                buffer[buffer.length - 1 - temp] = perem;
            }
            outputStreamTwo.write(buffer, 0, count);
        }
        reader.close();
        fileInputStreamOne.close();
        outputStreamTwo.close();
    }
}
