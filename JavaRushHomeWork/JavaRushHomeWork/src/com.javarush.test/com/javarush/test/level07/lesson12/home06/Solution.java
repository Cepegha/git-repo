package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое
детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при
выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human Ded1 = new Human("Ded1",80,true,null,null);
        Human Ded2 = new Human("Ded2",78,true,null,null);
        Human Baba1 = new Human("Baba1",79,false,null,null);
        Human Baba2 = new Human("Baba2",75,false,null,null);
        Human Father = new Human("Dad",55,true,Ded1,Baba1);
        Human Mother = new Human("Mom",50,false,Ded2,Baba2);
        Human Baby1 = new Human("Baby1",30,true,Father,Mother);
        Human Baby2 = new Human("Baby2",25,true,Father,Mother);
        Human Baby3 = new Human("Baby3",22,true,Father,Mother);

        System.out.println(Ded1.toString());
        System.out.println(Ded2.toString());
        System.out.println(Baba1.toString());
        System.out.println(Baba2.toString());
        System.out.println(Father.toString());
        System.out.println(Mother.toString());
        System.out.println(Baby1.toString());
        System.out.println(Baby2.toString());
        System.out.println(Baby3.toString());


    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, int age, boolean sex,Human father, Human mother)
        {
            this.name = name;
            this.age=age;
            this.sex=sex;
            this.father=father;
            this.mother=mother;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
