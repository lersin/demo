package org.onosproject.helloworld.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HelloWorldTest {

    private HelloWorld helloWorld;

    @Before
    public void setUp() {
        helloWorld = new HelloWorld();
        helloWorld.activate();
    }

    @After
    public void tearDown() {
        helloWorld.deactivate();
    }

    @Test
    public void basics() {

    }
}