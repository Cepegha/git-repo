package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        //return n.first.equals(first) && n.last.equals(last);
        return o == this?true:(o != null && o.getClass() == this.getClass()?(this.first == n.first || this.first != null && n.first != null) && (this.last == n.last || this.last != null && n.last != null):false);
    }

    @Override
    public int hashCode() {
        boolean prime = true;
        byte result = 1;
        int result1 = 31 * result + (this.first == null?0:this.first.hashCode());
        result1 = 31 * result1 + (this.last == null?0:this.last.hashCode());
        return result1;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
