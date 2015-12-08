package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Vasilki on 21.09.2015.
 */
public class BelarusianHen extends Hen{
    int getCountOfEggsPerMonth(){return 2;}
    String getDescription()
    {return super.getDescription()+" Моя страна - "+Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";}
}
