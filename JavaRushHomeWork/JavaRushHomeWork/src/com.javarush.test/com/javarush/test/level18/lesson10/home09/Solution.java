package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String files=reader.readLine();
        while (!files.equals("exit"))
        {
            if (!exists(files)) {
                files="exit";
            }
            else files = reader.readLine();
        }
        reader.close();
        }

    private static boolean exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
           System.out.println(fileName);
            return false;
        }
        return true;
    }
}
