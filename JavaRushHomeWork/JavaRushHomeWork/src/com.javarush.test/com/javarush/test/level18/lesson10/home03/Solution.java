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
        //String file_three=reader.readLine();

        FileInputStream inputStream_two=new FileInputStream(file_two);
        FileInputStream inputStream_one=new FileInputStream(file_one);
        FileOutputStream outputStream=new FileOutputStream(file_one);

        int leng=0;
        while ((inputStream_one.available()>0)){
            leng++;
        }
        System.out.println(leng);

        byte[] buffer=new byte[inputStream_two.available()];
        while (inputStream_two.available()>0){
            int count=inputStream_two.read(buffer);
            outputStream.write(buffer);
        }

        inputStream_two.close();
        inputStream_one.close();
        outputStream.close();
        reader.close();
    }
}
