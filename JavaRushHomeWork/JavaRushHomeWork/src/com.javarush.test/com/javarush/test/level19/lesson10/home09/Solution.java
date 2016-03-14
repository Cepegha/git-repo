package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        //разворачиваем строку
        String temp3="";
        StringBuilder stringBuilder = new StringBuilder(result);
        Pattern pattern = Pattern.compile("\\n");
        Matcher matcher= pattern.matcher(stringBuilder);
        boolean resultMatch = matcher.find();
        //if (resultMatch) {
         //   do {
                //matcher.find();
                //stringBuilder.insert(matcher.end(), "JavaRush - курсы Java онлайн\n");
        while (matcher.find())
        {System.out.println(stringBuilder.replace(matcher.end(), matcher.end(), "JavaRush - курсы Java онлайн\n"));
        matcher.find()=false;}
                //temp3=stringBuilder.substring(0, matcher.start()-1)+"JavaRush - курсы Java онлайн\n"+stringBuilder.substring(matcher.end());
                //resultMatch = matcher.find();
          //  } while (resultMatch);
        //}

        //Возвращаем все как было
        System.setOut(consoleStream);

        //выводим ее в консоль+
        System.out.println(stringBuilder);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
