package com.javarush.test.level17.lesson10.bonus02;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/


public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException {
        //start here - начни тут
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if (args[0].equals("-c")) {
                for (int index_id_size = 1; index_id_size < args.length; index_id_size = index_id_size + 3) {
                    Date bd = null;
                    try {
                        bd = dateFormat1.parse(args[index_id_size + 2]);
                    } catch (ParseException e) {
                        System.out.println("Wrong date");
                    }
                    if (args[index_id_size + 1].equals("м"))
                        allPeople.add(Person.createMale(args[index_id_size], bd));
                    else if (args[index_id_size + 1].equals("ж"))
                        allPeople.add(Person.createFemale(args[index_id_size], bd));
                    else throw new IOException("Wrong data");
                    System.out.println((allPeople.size() - 1));
                }
        }

        else if (args[0].equals("-u")) {
            for (int index_id_size=1; index_id_size< args.length; index_id_size=index_id_size+4) {
                int index = Integer.parseInt(args[index_id_size]);
                if (index < 0 || index >= allPeople.size())
                    throw new IOException("Wrong data");
                String sex = args[index_id_size + 2];
                allPeople.get(index).setName(args[index_id_size + 1]);
                if (sex.equals("м"))
                    allPeople.get(index).setSex(Sex.MALE);
                else if (sex.equals("ж"))
                    allPeople.get(index).setSex(Sex.FEMALE);
                else throw new IOException("Wrong data");
                try {
                    allPeople.get(index).setBirthDay(dateFormat1.parse(args[index_id_size + 3]));
                } catch (ParseException e) {
                    System.out.println("Wrong date");
                }
            }
        }

        else if (args[0].equals("-d")) {
                for (int index_id_size = 1; index_id_size < args.length; index_id_size++) {
                    int index = Integer.parseInt(args[index_id_size]);
                    if (index < 0 || index >= allPeople.size())
                        throw new IOException("Wrong data");
                    allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
                    allPeople.get(Integer.parseInt(args[1])).setName("");
                    allPeople.get(Integer.parseInt(args[1])).setSex(null);
                }
        }

        else if (args[0].equals("-i")) {
                for (int index_id_size = 1; index_id_size < args.length; index_id_size++) {
                    int index = Integer.parseInt(args[index_id_size]);
                    if (index < 0 || index >= allPeople.size())
                        throw new IOException("Wrong data");
                    Person person = allPeople.get(index);
                    String sex = "";
                    if (person.getSex().equals(Sex.FEMALE))
                        sex = "ж";
                    else if (person.getSex().equals(Sex.MALE))
                        sex = "м";
                    System.out.println(person.getName() + " " + sex + " " + dateFormat.format(person.getBirthDay()));
                }
        }
    }
}
