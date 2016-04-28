package com.javarush.test.level25.lesson16.big01;

import org.junit.Test;

/**
 * Created by cepegha@gmail.com on 28.04.2016.
 */
public class CanvasTest {

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testPrint() throws Exception {
        Canvas canvas = new Canvas(5, 5);
        canvas.print();
    }
}