package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String s = "";
        if (string==null||string.equals(""))
        {
            throw  new TooShortStringException();
        }

        char[] c =string.toCharArray();
        int count = 0;
        for(char x:c){
            if(String.valueOf(x).equals(" ")){
                count++;
            }
        }
        if(count>=4){
            s = string.substring(string.indexOf(" ")+1);
            int coutt =0;
            int i = 0;
            while (coutt!=4 && i<s.length()){
                if(s.charAt(i)==' '){
                    coutt++;
                }
                i++;
            }
            s= s.substring(0,i-1);
        }else {
            throw  new TooShortStringException();
        }
        return s;
    }

    public static class TooShortStringException extends Exception{
    }

    public static void main(String[] args) throws TooShortStringException {
        String str="nfnf nfnf nfnf nfnf    ";
        System.out.println(getPartOfString(str));
    }
}
