package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            A a_new = new A(getI(),getJ());
            return a_new;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("no");
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            C c_new = new C(this.getI(), this.getJ(),getName()==null? null:this.getName());
            return c_new;
        }
    }

    public static void main(String[] args) {
        A tree = new A(10,20);
        A clone = null;
        try {
            clone = (A)tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.i);
        System.out.println(clone.i);

        B treeB = new B(17,27, "Ivan");
        B cloneB = null;
        try {
            cloneB = (B)treeB.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

      //  System.out.println(treeB);
       // System.out.println(cloneB);

       // System.out.println(treeB.getI());
       // System.out.println(cloneB.getJ());

        C treeC = new C(15,25,"test");
        C cloneC = null;
        try {
            cloneC = (C)treeC.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(treeC);
        System.out.println(cloneC);

        System.out.println(treeC.getI()+treeC.getJ()+treeC.getName());
        System.out.println(cloneC.getI()+cloneC.getJ()+cloneC.getName());
    }
}
