package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStreamOne = new FileInputStream(reader.readLine());
        FileOutputStream outputStreamTwo = new FileOutputStream(reader.readLine());
        FileOutputStream outputStreamThree = new FileOutputStream(reader.readLine());

        if (fileInputStreamOne.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[fileInputStreamOne.available()];
            int count = fileInputStreamOne.read(buffer);
            if (count % 2 == 0) {
                outputStreamTwo.write(buffer, 0, count / 2);
                outputStreamThree.write(buffer, count / 2, count / 2);
            } else {
                outputStreamTwo.write(buffer, 0, (count / 2)+1);
                outputStreamThree.write(buffer, (count / 2)+1, (count / 2));
            }
        }
        reader.close();
        fileInputStreamOne.close();
        outputStreamTwo.close();
        outputStreamThree.close();
    }
}
