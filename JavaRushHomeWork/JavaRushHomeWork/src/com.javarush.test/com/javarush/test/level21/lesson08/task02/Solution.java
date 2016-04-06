package com.javarush.test.level21.lesson08.task02;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
Метод main изменять нельзя.
*/
public class Solution{
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Tree clone() throws CloneNotSupportedException {
            String[] branches3=null;
            String branches2[];
            if (branches==null) {branches2 = branches3;}
            else
            {branches2 = new String[getBranches().length];
            for (int x = 0; x < branches.length; x++)
            {
                branches2[x] = new String(this.branches[x]);
            }}
            //System.out.println(branches==null? 0 : branches.length);
            String names2= getName();
            //System.out.println(names2);
            Tree tree2 = new Tree(names2, branches2);
            //System.out.println("asdsd");
            return tree2;
        }
    }

}
