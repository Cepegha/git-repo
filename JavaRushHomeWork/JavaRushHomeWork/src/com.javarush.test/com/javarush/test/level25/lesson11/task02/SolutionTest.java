package com.javarush.test.level25.lesson11.task02;

/**
 * Created by cepegha@gmail.com on 27.04.2016.
 */
public class SolutionTest {
    public static void main(String[] args) {
        Solution.YieldRunnable solution = new Solution.YieldRunnable(10);
        solution.run();
    }
}