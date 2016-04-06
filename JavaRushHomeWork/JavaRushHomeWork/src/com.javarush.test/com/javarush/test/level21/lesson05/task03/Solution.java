package com.javarush.test.level21.lesson05.task03;

import java.util.Date;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution))
        {
            return false;
        }
        if (!(o != null && o.getClass() == this.getClass())) return false;
        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
        if (!(solution.equals(solution1.solution)||(solution1.solution != null && this.solution != null))) { return false;}
        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;

        //System.out.println(result);
        //return (this.first == n.first || this.first != null && n.first != null) && (this.last == n.last || this.last != null && n.last != null);

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        String line=string;
        Date date2 = date;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32))+line.hashCode()+date2.hashCode();
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        System.out.println(result);
        return result;
    }
/*
    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        Date date33 = new Date();
        Solution so2= new Solution(15, "Test222", 7.0d, date33, null);
        s.add(new Solution(10, "Test", 5.0d, date33, so2));
        System.out.println(s.contains(new Solution(10, "Test", 5.0d, date33, so2)));
    }*/

}
