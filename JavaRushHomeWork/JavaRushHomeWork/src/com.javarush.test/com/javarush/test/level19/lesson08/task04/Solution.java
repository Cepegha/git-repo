package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
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
        StringBuilder stringBuilder = new StringBuilder(result);

        Pattern pattern = Pattern.compile("\\b[0-9]+\\b");
        Matcher matcher= pattern.matcher(stringBuilder);
        matcher.find();
        int temp= Integer.parseInt(stringBuilder.substring(matcher.start(), matcher.end()));
        matcher.find();
        int temp2= Integer.parseInt(stringBuilder.substring(matcher.start(), matcher.end()));

        Pattern pattern2 = Pattern.compile("[\\+,\\-,\\*]");
        Matcher matcher2= pattern2.matcher(stringBuilder);
        matcher2.find();
        String temp3 = stringBuilder.substring(matcher2.start(), matcher2.end());

        //Возвращаем все как было
        System.setOut(consoleStream);

        //выводим ее в консоль
        switch (temp3) {
            case "+": System.out.print(temp+" "+temp3+" "+temp2+" = "+(temp+temp2));break;
            case "-": System.out.print(temp+" "+temp3+" "+temp2+" = "+(temp-temp2));break;
            case "*": System.out.print(temp+" "+temp3+" "+temp2+" = "+(temp*temp2));break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

