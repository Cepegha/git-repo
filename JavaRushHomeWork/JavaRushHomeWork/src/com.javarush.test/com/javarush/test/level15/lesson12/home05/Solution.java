package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    private Solution(int a){}
    private Solution(String a){}
    private Solution(boolean a){}

    public Solution(long a){}
    public Solution(Object a){}
    public Solution(char a){}

    protected Solution(Boolean a){}
    protected Solution(byte a){}
    protected Solution(Long a){}

    Solution(Number c){}
    Solution(Integer l){}
    Solution(Short s){}
}