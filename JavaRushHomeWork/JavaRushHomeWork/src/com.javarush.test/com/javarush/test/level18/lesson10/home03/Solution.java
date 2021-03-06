package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file_one=reader.readLine();
        String file_two=reader.readLine();
        String file_three=reader.readLine();

        FileInputStream inputStream_two=new FileInputStream(file_two);
        FileInputStream inputStream_three=new FileInputStream(file_three);
        FileOutputStream outputStream=new FileOutputStream(file_one, true);

        while ((inputStream_two.available()>0)){
            outputStream.write(inputStream_two.read());
        }

        while ((inputStream_three.available()>0)){
            outputStream.write(inputStream_three.read());
        }

        inputStream_two.close();
        inputStream_three.close();
        outputStream.close();
        reader.close();
    }
}
