package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(reader2.readLine()))));

        String s = "";
        StringBuffer stringBuffer=new StringBuffer();

        while (reader.ready()) {
            s = reader.readLine();
           stringBuffer.append(s).reverse();
            System.out.println(stringBuffer.toString());
            stringBuffer.delete(0,stringBuffer.length());
        }
        reader.close();
        reader2.close();
    }
}
