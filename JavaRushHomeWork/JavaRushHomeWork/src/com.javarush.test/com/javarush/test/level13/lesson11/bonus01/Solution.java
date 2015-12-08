package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileNAme=reader.readLine();
        BufferedReader is=new BufferedReader(new FileReader(fileNAme));
        //        InputStream is=new FileInputStream(fileNAme);
        ArrayList<Integer> array=new ArrayList<Integer>();
        Scanner scan=new Scanner(fileNAme);
        String line;
        while ((line=is.readLine())!=null)//(is.available()>0)
        {
            array.add(Integer.parseInt(line));
        }

        int temp=array.get(0);
        for (int i=0;i<array.size();i++)
        {
            for (int j=0;j<array.size();j++)
            {
                if (array.get(i)<array.get(j))
                {
                    temp=array.get(i);
                    array.set(i,array.get(j));
                    array.set(j,temp);
                }
            }
        }

        for (int a=0;a<array.size();a++)
        {
            if (array.get(a)%2==0)
            {System.out.println(array.get(a));}
        }
        is.close();
    }
}
