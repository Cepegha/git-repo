package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Vasilki on 21.09.2015.
 */
public class MoldovanHen extends Hen{
    public int getCountOfEggsPerMonth(){return 5;}
    public String getDescription()
    {return super.getDescription()+" Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";}
}
