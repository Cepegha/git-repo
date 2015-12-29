package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file_one=reader.readLine();
        String file_two=reader.readLine();

        FileInputStream inputStream_two=new FileInputStream(file_two);
        FileOutputStream outputStream=new FileOutputStream(file_one, true);

        while ((inputStream_two.available()>0)){
            byte[] buffer = new byte[inputStream_two.available()];
            int count = inputStream_two.read(buffer);
            outputStream.write(buffer,0,count);
        }

        inputStream_two.close();
        outputStream.close();
        reader.close();
    }
}
