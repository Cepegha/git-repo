package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1]))));
        String s="";
        StringBuffer stringBuffer=new StringBuffer();

        while (reader.ready()) {
            s = reader.readLine();
            String[] lines = s.split(" ");

            for (String line : lines) {
                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()){
                matcher.appendTail(stringBuffer).append(" ");}
            }
        }
       // System.out.println(stringBuffer);
        writer.write(stringBuffer.toString().substring(0,stringBuffer.length()-1));
        reader.close();
        writer.close();
    }
}
