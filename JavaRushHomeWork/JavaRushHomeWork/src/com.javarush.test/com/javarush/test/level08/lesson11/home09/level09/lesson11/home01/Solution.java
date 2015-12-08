package com.javarush.test.level08.lesson11.home09.level09.lesson11.home01;

/* Деление на ноль
Создай метод public static void divisionByZero, в котором подели любое число на ноль и выведи на экран
 результат деления.
Оберни вызов метода divisionByZero в try..catch. Выведи стек-трейс исключения используя метод
 exception.printStackTrace()
*/

public class Solution {

    public static void main(String[] args) {
        try {divisionByZero();}
        catch (ArithmeticException e){e.printStackTrace();}
    }

    public static void divisionByZero() throws ArithmeticException {System.out.println(10/0);}

    public static void printStack(Throwable throwable) {
        System.out.println(throwable);
        for (StackTraceElement element : throwable.getStackTrace()) {
            System.out.println(element);
        }
    }
}
