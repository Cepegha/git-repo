package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

            InputStream inputStream = new FileInputStream(file);
            load(inputStream);
            inputStream.close();

            OutputStream outputStream = new FileOutputStream(file);
            save(outputStream);
            outputStream.close();

            reader.close();
            reader2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties saveProperties = new Properties(); //создаем properties
        for (Map.Entry<String, String> prop : properties.entrySet()) { //проходимся по mape
            saveProperties.setProperty(prop.getKey(), prop.getValue());//сохраняем данные в наш new prop
        }
        saveProperties.save(outputStream, null); //записываем данные
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties property = new Properties();
        property.load(inputStream);
        Enumeration enumeration = property.keys();
        Enumeration enumeration_val = property.elements();
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement().toString();
            String value = enumeration_val.nextElement().toString();
            // System.out.println(key+" "+value);
            properties.put(key, value);
        }
    }

    //d:/1.properties
/*
    public static void main(String[] args) throws IOException {
        Solution solution=new Solution();
        solution.fillInPropertiesMap();
    }*/
}
