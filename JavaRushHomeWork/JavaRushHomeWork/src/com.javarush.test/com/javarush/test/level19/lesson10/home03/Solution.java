package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));

        String s="", nameTemp="";

        while (reader.ready()) {
            s = reader.readLine();
            String[] lines = s.split(" ");
            int i = lines.length-4;
            Calendar birthDayTemp=new GregorianCalendar(Integer.parseInt(lines[i+3]),Integer.parseInt(lines[i+2])-1,Integer.parseInt(lines[i+1]));
            while (i>=0){
                nameTemp=lines[i]+" "+nameTemp;
                i--;
            }
            Person person=new Person(nameTemp.substring(0,nameTemp.length()-1),birthDayTemp.getTime());
            PEOPLE.add(person);
            nameTemp="";
            s="";
        }

        /*for (Person person2 : PEOPLE) {
            System.out.println(person2.getName()+" "+person2.getBirthday());
        }*/
        reader.close();
    }
}
