package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static void main(String[] args) {
        char[] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] fileName=args[0].toCharArray();
        int count=0;
        for (int i=0; i<fileName.length; i++) {
            for (int j = 0; j < abc.length; j++) {
                if (fileName[i] == abc[j]) count++;
            }
        }
        System.out.println(count);
    }
}
