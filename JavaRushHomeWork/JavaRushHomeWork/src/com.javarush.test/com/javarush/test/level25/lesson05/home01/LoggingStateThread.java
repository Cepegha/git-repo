package com.javarush.test.level25.lesson05.home01;

/**
 * Created by cepegha@gmail.com on 26.04.2016.
 */
public class LoggingStateThread extends Thread{
    Thread thread;
    State state;

    LoggingStateThread(Thread target){
        super();
        this.thread=target;
        setDaemon(true);
        this.state = thread.getState();}

    @Override
    public void run() {
        System.out.println(state);
        while (state != State.TERMINATED) {
            if (state != thread.getState()) {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }

}
