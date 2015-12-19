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
            while ((line = reader2.readLine()) != null) {
                forRemoveLines.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void joinData() throws CorruptedDataException {
        int countIinJ = 0;

        for (String s2 : forRemoveLines) {
            if (allLines.contains(s2)) countIinJ++;
        }
        if (countIinJ == forRemoveLines.size()) {
            for (int i = 0; i < forRemoveLines.size(); i++) {
                for (int j = 0; j < allLines.size(); j++) {
                    if (allLines.get(j).contains(forRemoveLines.get(i))) allLines.remove(forRemoveLines.get(i));
                }
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
