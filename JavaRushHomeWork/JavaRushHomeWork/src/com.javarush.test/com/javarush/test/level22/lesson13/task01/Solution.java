package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> result = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens())
        {
            result.add(stringTokenizer.nextToken());
        }
        String[] result_mas= new String[result.size()];
        int i=0;
        for (String s : result) {
            result_mas[i]=s;
            i++;
        }

        return result_mas;
    }
/*
    public static void main(String[] args) {
        System.out.println((getTokens("level22.lesson13.task01", ".")).toString());
    }*/
}
