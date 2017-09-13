package com.turo.boot.simple;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class SimpleNumberServiceTest {
    @Test
    public void get() throws Exception {
        System.out.printf("test:get");
    }

    @Test
    public void getAsync() throws Exception {
        System.out.printf("test:getAsync");
        double random = Math.random();
        double test = 0.5;
        assertTrue("Random value " + random + " is < " + test, random > test);
    }

}