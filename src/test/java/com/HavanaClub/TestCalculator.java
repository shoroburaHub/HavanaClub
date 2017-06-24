package com.HavanaClub;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by admin on 6/23/2017.
 */
public class TestCalculator {

    Calculator calculator;

    @Before
    public void beforeEachMethods(){
        System.out.println("before");
        calculator = new Calculator();
    }

    @After
    public void afterEachMethods(){
        System.out.println("after");
    }

    @Test
    public void testAddMethod(){
        assertEquals(4, calculator.add(2,2));
    }

    @Test
    public void testDivideMethod(){
        assertEquals(4, calculator.divide(16,4), 0.000000000001);
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
    }

}
