package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int y = 5;
        int x = 0;
        if(y % 10 == 5)
            x = 5;
        x += y;
        else
        x = -1;
        System.out.println(x);
    }
}
