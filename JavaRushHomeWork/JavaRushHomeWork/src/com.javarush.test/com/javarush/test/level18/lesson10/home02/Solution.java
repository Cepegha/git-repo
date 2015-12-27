package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fis = new FileReader (args[0]);
        int count=0;
        int countAllName=0;
        while (fis.ready()) {
            countAllName++;
            Character ch=(char)fis.read();
            if (String.valueOf(ch).matches(" ")){
                count++;
            }
        }
        fis.close();
        double rezult=((double)count/countAllName*100);
        rezult=rezult*100;
        int i= (int) Math.round(rezult);
        rezult=(double)i/100;
        System.out.println(rezult);
    }
}
