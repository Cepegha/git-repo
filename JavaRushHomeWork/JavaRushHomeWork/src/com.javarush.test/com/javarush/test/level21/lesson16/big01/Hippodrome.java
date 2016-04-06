package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Sergei.Sasinovich on 05.04.2016.
 */
public class Hippodrome {

    public static Hippodrome game;
    static ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {

        return horses;
    }

    public Horse getWinner(){
        double max=0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (max<horse.getDistance()){
                max=horse.getDistance();
                winner=horse;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }


    public static void main(String[] args) throws Exception {
        game = new Hippodrome();
        Horse h_one =  new Horse("Ivan",3,0);
        Horse h_two =  new Horse("Petr",3,0);
        Horse h_three = new Horse("Sidor",3,0);
        game.horses.add(h_one);
        game.horses.add(h_two);
        game.horses.add(h_three);

        game.run();

        game.printWinner();
    }

    //    А метод run - управлять всем этим.
    public void run() throws Exception {
        for (int i=0; i<100; i++ ){
            move();
            print();
            Thread.sleep(500);
        }
    }

    //    Метод move будет управлять движением всех лошадей.
    public void move(){
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    //    Метод print отрисовывать их на экран.
    public void print(){
        for (Horse horse : getHorses()) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }
}
