package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable{
    private static final long serialVersionUID = 1L;
    int node;
    List<Solution> edges = new LinkedList<>();
/*
    public static void main(String[] args) throws Exception {

        FileOutputStream fileOutput = new FileOutputStream("d:/1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        solution.node=5;
        solution.edges.add(new Solution());
        outputStream.writeObject(solution);
        fileOutput.close();
        outputStream.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream("D:/1.txt"));
        Solution loadPerson = (Solution)input.readObject();
        System.out.println(loadPerson.node);
    }*/
}
