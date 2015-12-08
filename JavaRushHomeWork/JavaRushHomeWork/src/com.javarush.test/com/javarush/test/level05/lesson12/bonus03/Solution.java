package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int qe = Integer.parseInt(reader.readLine());
            if (qe > 0) {
            int first = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= qe - 1; i++) {
                int w = Integer.parseInt(reader.readLine()); // ))))))
                if (w > first) {
                    first = w;
                }
            }
            int maximum = first;
            System.out.print(maximum);}

   /*     int maximum;

        //напишите тут ваш код
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        if (N <= 0) { //проверка условия 1
            System.out.println("Error");
        } else {
            int M = Integer.parseInt(reader.readLine()); //первое сравниваемое число
            if (N == 1) { //исключение одной сравниваемой переменной
                System.out.println(M);
            } else {
                for (int i = 1; i < N-1; i++) {
                int K = Integer.parseInt(reader.readLine());
                maximum = max(M,K); //результат сравнения
                M=max(M,K); // присвоение первой сравниваемой переменной максимума
            }
        }}
        //напишите здесь ваш код
     System.out.println(maximum);
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }*/
        }}


