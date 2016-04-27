package com.javarush.test.level25.lesson09.task02;

import org.junit.Test;

import java.util.TimerTask;

/**
 * Created by cepegha@gmail.com on 26.04.2016.
 */
public class SolutionTest {

    @Test
    public void testRun() throws Exception {

    }

    @Test
    public void testScheduledExecutionTime() throws Exception {

    }

    @Test
    public void testCancel() throws Exception {

    }

    public static void main(String[] args) {
        Solution solution = new Solution(new TimerTask() {
            @Override
            public void run() {

            }
        });
        solution.run();
    }
}