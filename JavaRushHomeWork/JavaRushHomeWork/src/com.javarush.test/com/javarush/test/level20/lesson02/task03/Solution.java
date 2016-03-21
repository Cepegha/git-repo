package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException {
        //implement this method - реализуйте этот метод
        try {
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        File file =new File (reader2.readLine());
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        OutputStream outputStream = new FileOutputStream(file);
        InputStream inputStream = new FileInputStream(file);

            load(inputStream);
           // save(outputStream);


            for (Map.Entry<String, String> stringStringEntry : properties.entrySet()) {
                System.out.println(stringStringEntry.getKey()+" "+stringStringEntry.getValue());
            }

            outputStream.close();
            inputStream.close();
            reader.close();
            reader2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter writer = new PrintWriter(outputStream);
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            writer.println(entry.getKey()+":"+entry.getValue());
        }
        writer.flush();
        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s;

        while (reader.ready()) {
            s = reader.readLine();
            if (s.substring(0,1).equals("\uFEFF")) s=s.substring(1, s.length());
            String[] lines = s.split(":");
            //System.out.println(lines[0]+" "+lines[1]);
            properties.put(lines[0], lines[1]);
        }
        reader.close();
    }

    //d:/1.properties
    public static void main(String[] args) throws IOException {
        Solution solution=new Solution();
        solution.fillInPropertiesMap();

    }
}
