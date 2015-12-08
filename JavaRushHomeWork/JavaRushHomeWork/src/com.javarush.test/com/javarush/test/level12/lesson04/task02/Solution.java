package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Solution solution=new Solution();
        Integer a=2;
        int b=3;
        solution.print(b);
        solution.print(a);

    }

    //Напишите тут ваши методы
    public void print(int a)
    {
        System.out.println("int");
    }
    public void print(Integer s)
    {
        System.out.println("Integer");
    }
}
