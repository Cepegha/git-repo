package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile_one = new BufferedReader(new InputStreamReader(new FileInputStream(new File(reader.readLine()))));
        BufferedReader readerFile_two = new BufferedReader(new InputStreamReader(new FileInputStream(new File(reader.readLine()))));

        //read 1 file
        while (readerFile_one.ready()) {
            String s1 = readerFile_one.readLine();
            String[] lines_one = s1.split("\n");

            //test 1 and 2 file
            for (int i=0; i<lines_one.length; i++) {
                lines.add(i, new LineItem(Type.SAME, lines_one[i]));
            }
        }
        //read 2 file
        String[] lines_two=new String[(int)readerFile_two.lines().count()];
        while (readerFile_two.ready()) {
            String s2 = readerFile_two.readLine();
            lines_two = s2.split("\n");
        }

        //test lines
        for (int i=0; i<lines.size(); i++) {
            System.out.println(lines.get(i).line);
        }
    }


        public static enum Type {
            ADDED,        //добавлена новая строка
            REMOVED,      //удалена строка
            SAME          //без изменений
        }

        public static class LineItem {
            public Type type;
            public String line;

            public LineItem(Type type, String line) {
                this.type = type;
                this.line = line;
            }
        }
    }
