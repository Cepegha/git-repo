package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        Solution new_sol=(Solution) o;
        if (o == this) {
            return true;}
        if((o == null) || (o.getClass() != this.getClass())) {
            return false;}
        //System.out.println((this.last == new_sol.last)||(this.last != null && new_sol.last != null));
        //return this.first.equals(new_sol.first) && this.last.equals(new_sol.last);
        return (first == new_sol.first || (first != null && new_sol.first != null))
                && (last == new_sol.last || (last != null && new_sol.last != null));
        //return true;
    }

    public int hashCode() {
       // System.out.println(first.length()+last.length());
    //    return 31 * first.hashCode() + last.hashCode();
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((first == null) ? 0 : first.hashCode());
        //result = prime * result;
        result = prime * result
                + ((last == null) ? 0 : last.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<Solution>();
        //s.add(new Solution("Donald", "Duck"));
        s.add(new Solution("Donald" , "Duck"));
        //System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
