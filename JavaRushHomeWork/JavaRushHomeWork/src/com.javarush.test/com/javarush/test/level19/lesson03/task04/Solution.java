package com.javarush.test.level19.lesson03.task04;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

        //test
    /*public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("d:/1.txt"));
        //while (in.hasNext()){System.out.println(in.nextLine());}
        PersonScannerAdapter adapter= new PersonScannerAdapter(in);
        System.out.println(adapter.read());
        System.out.println(adapter.read());
        System.out.println(adapter.read());
        adapter.close();
    }*/

    public static class PersonScannerAdapter implements PersonScanner{

        Scanner scanner;

        PersonScannerAdapter(Scanner scanner){
            this.scanner=scanner;
        }

        @Override
        public Person read() throws IOException {

            Person person = null;
            if (scanner.hasNext())
            {
                String lastName = scanner.next();
                String firstName = scanner.next();
                String middleName = scanner.next();
                int day = scanner.nextInt();
                int month = scanner.nextInt();
                int year = scanner.nextInt();
                Calendar birsDate = new GregorianCalendar(year, --month, day);
                person = new Person(firstName, middleName,lastName, birsDate.getTime());
            }
            return person;
        }

        @Override
        public void close() throws IOException {
            this.scanner.close();
        }
    }
}
