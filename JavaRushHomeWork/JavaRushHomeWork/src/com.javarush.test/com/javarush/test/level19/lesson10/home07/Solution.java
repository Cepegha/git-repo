package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1]))));
        String s = "";
        StringBuffer stringBuffer = new StringBuffer();

        while (reader.ready()) {
            s = reader.readLine();
            String[] lines = s.split(" ");
            for (int i=0; i<lines.length; i++){
                if (lines[i].length()>6) {
                    stringBuffer=stringBuffer.append(lines[i]+",");

                }
                }
            }

        writer.write(stringBuffer.toString().substring(0,stringBuffer.length()-1));
        reader.close();
        writer.close();
        }

    }