package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;
        public static final long serialVersionUID = 1L;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        Person person = new Person("Ivan", "Ivanov", "Belarus", Sex.MALE);
        FileOutputStream fileOutput = new FileOutputStream("d:/1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        outputStream.writeObject(person);
        outputStream.flush();
        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("d:/1.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Person loadedObject = (Person) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.firstName+" "+loadedObject.lastName+" "+loadedObject.fullName+" "+loadedObject.greetingString+" "+loadedObject.country+" "+loadedObject.sex+" "+loadedObject.logger);
    }
}
