package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        int a,b;
        if (string==null||string.equals(""))
        {
            throw  new TooShortStringException();
        }
        char[] c =string.toCharArray();
        int count = 0;
        for(char x:c){
            if(String.valueOf(x).equals("\t")){
                count++;
            }
        }
        if (count>1){
        //System.out.println(string);
        a = string.indexOf("\t");
        b = string.indexOf("\t",a+1);}
        else {
            throw  new TooShortStringException();
        }

        return string.substring(a+1,b);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
