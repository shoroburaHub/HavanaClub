package com.HavanaClub;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by admin on 6/23/2017.
 */
public class TestCalculator {
    Calculator calculator;

    @Before
    public void beforeEachMethods(){
        System.out.println("before method");
        calculator = new Calculator();

        MockitoAnnotations.initMocks(this);
    }

    @After
    public void afterEachMethods(){
        System.out.println("after method");
    }

    @Test
    public void testAddMethod(){
        Calculator calc = mock(Calculator.class);
        when(calc.add(2,2)).thenReturn(4);
        assertEquals(4, calc.add(2,2));

    }
    @Test
    public void testDivideMethod(){
        assertEquals(4, calculator.divide(16, 4), 0.00000001);
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
