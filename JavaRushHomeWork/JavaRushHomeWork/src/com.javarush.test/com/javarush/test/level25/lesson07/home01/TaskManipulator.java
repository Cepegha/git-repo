package com.javarush.test.level25.lesson07.home01;

import java.util.Date;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Date start, end;
    String lineThread;
    @Override
    public void run() {

    }

    @Override
    public void start(String threadName) {
        start = new Date();
        if (Thread.currentThread().getState()== Thread.State.RUNNABLE){
            lineThread=threadName;
        }
    }

    @Override
    public void stop() {
        end = new Date();
        long time=end.getTime()-start.getTime();
        while (time>0){
            System.out.println(lineThread);
            time=time-99;
        }
    }
}
