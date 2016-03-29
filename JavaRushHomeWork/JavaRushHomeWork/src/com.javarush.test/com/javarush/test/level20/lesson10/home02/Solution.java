package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable{
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException {
        if (objectStream.getClass().getSimpleName().toString().equals("B")) {
            return (B)objectStream.readObject();}
        else {
        return (A)objectStream.readObject();}
    }
/*
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        if (a.getClass().getSimpleName().toString().equals("A")){System.out.println("eee");};
        if (b.getClass().getSimpleName().toString().equals("A")){System.out.println("eeeA");};
        if (b.getClass().getSimpleName().toString().equals("B")){System.out.println("eeeB");};
    }*/

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
