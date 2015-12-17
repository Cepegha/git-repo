package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            reader.close();

            BufferedReader reader2 = new BufferedReader(new FileReader(firstFileName));
            String line = "";
            while ((line = reader2.readLine()) != null) {
                allLines.add(line);
            }

            reader2 = new BufferedReader(new FileReader(secondFileName));
            line = "";
            while ((line = reader2.readLine()) != null) {
                forRemoveLines.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e)
        { System.out.println("File not found");}
        catch (IOException e) {
            e.printStackTrace();}
        joinData();
        for (String s : allLines) {
            System.out.println(s);
        }
        for (String s : forRemoveLines) {
            System.out.println(s);
        }
    }


    public static void joinData() throws CorruptedDataException {
        for (String line : allLines) {
            for (String s2 : forRemoveLines) {
                if (line.contains(s2)) {
                    allLines.remove(line);
                }
            }
        }
    }
}
