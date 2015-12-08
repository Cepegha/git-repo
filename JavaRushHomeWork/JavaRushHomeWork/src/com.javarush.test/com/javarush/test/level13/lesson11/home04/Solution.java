package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Throwable
    {

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file=reader.readLine();

        FileWriter outStream = new FileWriter(file);
        //OutputStream outStream = new FileOutputStream(str);
        //BufferedWriter buf = new BufferedWriter(outStream);
        String str="";
        String lineSeparator=System.lineSeparator();
        while (!str.equals("exit"))
        {
            str=reader.readLine();
            outStream.write(str);
            outStream.write(lineSeparator);
        }

        outStream.close(); //закрываем потоки
        reader.close();

    }
}
