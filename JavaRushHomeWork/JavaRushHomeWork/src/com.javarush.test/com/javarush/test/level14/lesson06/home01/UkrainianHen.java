package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Vasilki on 21.09.2015.
 */
public class UkrainianHen extends Hen{
    public int getCountOfEggsPerMonth(){return 9;}
    public String getDescription()
    {return super.getDescription()+" Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";}
}
