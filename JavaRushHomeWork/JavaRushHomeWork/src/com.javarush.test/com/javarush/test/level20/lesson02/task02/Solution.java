package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("D:/1.txt");
            InputStream inputStream = new FileInputStream("D:/1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User ivanov = new User();
            ivanov.setFirstName("Ivan");
            ivanov.setLastName("Ivanov");
            ivanov.setMale(false);
            SimpleDateFormat  format1 = new SimpleDateFormat("yyyy-MM-dd");
            Date bdDate= format1.parse("1990-12-21");
            ivanov.setBirthDate(bdDate);
            ivanov.setCountry(User.Country.UKRAINE);
            javaRush.users.add(ivanov);
            outputStream.flush();

            User petrov = new User();
            petrov.setFirstName("Petr");
            petrov.setLastName("Petrov");
            petrov.setMale(true);
            Date bdDate3= format1.parse("2015-9-30");
            petrov.setBirthDate(bdDate3);
            petrov.setCountry(User.Country.RUSSIA);

            javaRush.users.add(petrov);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (loadedObject.users.get(0).getFirstName().equals(javaRush.users.get(0).getFirstName())){
                System.out.println(loadedObject.users.get(0).getFirstName()+loadedObject.users.get(1).getFirstName());
            }
            System.out.print(loadedObject.users.get(0).getFirstName());
            System.out.print(loadedObject.users.get(0).getLastName());
            System.out.print(loadedObject.users.get(0).isMale());
            System.out.print(loadedObject.users.get(0).getBirthDate());
            System.out.println(loadedObject.users.get(0).getCountry());
            System.out.print(loadedObject.users.get(1).getFirstName());
            System.out.print(loadedObject.users.get(1).getLastName());
            System.out.print(loadedObject.users.get(1).isMale());
            System.out.print(loadedObject.users.get(1).getBirthDate());
            System.out.println(loadedObject.users.get(1).getCountry());


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

                //writer.print(users);

                for (User user : users) {
                    writer.print(user.getFirstName());
                    writer.print(" " + user.getLastName());
                    writer.print(" " + user.isMale());
                    writer.print(" " + (user.getBirthDate().getYear()+1900)+"-"+(user.getBirthDate().getMonth()+1)+"-"+user.getBirthDate().getDate());
                    writer.println(" " + user.getCountry());
                }
                //writer.println();
                writer.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()){
                String[] lines = reader.readLine().split(" ");
                User us_temp=new User();
                us_temp.setFirstName(lines[0]);
                us_temp.setLastName(lines[1]);
                us_temp.setMale(lines[2].equals("true"));

                SimpleDateFormat  format2 = new SimpleDateFormat("yyyy-MM-dd");
                Date bdDate= format2.parse(lines[3]);
                us_temp.setBirthDate(bdDate);

                us_temp.setCountry(User.Country.valueOf(lines[4]));

                users.add(us_temp);
            }
        }
    }
}
