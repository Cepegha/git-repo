package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {

    public static void main(String[] args) throws Exception {
        //1
        Solution solution = new Solution("D:/2.txt");
        //2
        String str = "demo";
        solution.writeObject(str);
        //3
        FileOutputStream fileOutputStream = new FileOutputStream("D:/1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution);
        //outputStream.flush();
        //outputStream.close();
        //fileOutputStream.close();
        //4
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("D:/1.txt"));
        Solution loadPerson = (Solution)input.readObject();
        loadPerson.writeObject("demo_2");
        //input.close();


    }
    private static final long serialVersionUID =1L;
    private transient FileOutputStream stream;
    private String name;

    //public Solution(){};

    public Solution(String fileName) throws FileNotFoundException {
        this.name = fileName;
        this.stream = new FileOutputStream(fileName);

    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
       //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(name, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
