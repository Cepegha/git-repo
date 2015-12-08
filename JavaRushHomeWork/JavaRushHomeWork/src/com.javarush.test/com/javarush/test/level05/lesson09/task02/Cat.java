package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен,
то нужно указать какой-нибудь средний вес. Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    private String name = null;
    private int age=2;
    private int wight=3;
    private String color="grey";
    private String adress = null;
    public Cat(String name)
    {
        this.name = name;
    }
    public Cat(String name, int wight, int age)
    {
        this.name = name;
        this.age = age;
        this.wight = wight;
    }
    public Cat(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public Cat(int wight, String color)
    {
        this.wight = wight;
        this.color = color;
    }
    public Cat(int wight, String color, String adress)
    {
        this.wight = wight;
        this.color = color;
        this.adress = adress;
    }
}