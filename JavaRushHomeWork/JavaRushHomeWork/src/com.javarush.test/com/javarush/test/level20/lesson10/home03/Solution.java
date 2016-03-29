package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    //static final long serialVersionUID = 1L;

    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
        public A(){}
    }

    public class B extends A implements Serializable  {
        //static final long serialVersionUID = 1L;
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(name);
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            name = (String)in.readObject();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Solution solution = new Solution();
        Solution.B b1 = solution.new B("F");
        System.out.println(b1.name);

        //save to file
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("d:/1.txt"));
            output.writeObject(b1);
            output.close();

        //load from file
            Solution.B object;
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("d:/1.txt"));
            object = (Solution.B) input.readObject();
            input.close();
            System.out.println(object.name);}

        catch (IOException | ClassNotFoundException e){System.out.println("wrong");}
    }
}
