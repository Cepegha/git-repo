package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String file=reader.readLine();

        while (!file.equals("exit"))
        {
            new ReadThread(file).start();
            file=reader.readLine();
        }
        //test Map
        /*for (Map.Entry<String, Integer>pair:resultMap.entrySet())
        {
            System.out.println(pair.getKey()+" "+pair.getValue());
        }*/
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName=fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try{
                FileInputStream inputStream = new FileInputStream(fileName);

                Map<Integer, Integer> table = new LinkedHashMap<Integer, Integer>();
                if (inputStream.available()==0)resultMap.put(fileName,0);
                while(inputStream.available()>0)
                {
                    int data=inputStream.read();
                    //System.out.println(buffer);
                    if (!table.containsKey(data))table.put(data,1);
                    else
                    {
                        table.put(data,table.get(data)+1);
                    }
                    int maxFreq=0;
                    for (int c:table.keySet())
                    {
                        maxFreq=Math.max(maxFreq, table.get(c));
                    }
                    for (int c:table.keySet())
                    {
                       // System.out.println(c);
                        if(table.get(c)==maxFreq)resultMap.put(fileName,(int)c);}
                }
                inputStream.close();
            }catch(IOException e){}
        }
    }
}
