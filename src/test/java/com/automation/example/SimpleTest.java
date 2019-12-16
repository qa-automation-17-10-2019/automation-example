package com.automation.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by alpa on 12/12/19
 */
public class SimpleTest {

    @Test
    public void calculationPlusTest() {
        int a = 2;
        int b = 2;
        int sum = a + b;

        assertEquals(sum, 4);
    }

    @Test
    public void calculationMinusTest() {
        int a = 5;
        int b = 4;
        int sum = a - b;

        assertEquals(sum, 4, "Nay4ic c4itaTb!");
    }

    @Test
    public void calculationVerifierTest() {
        int a = 5;
        int b = 4;

        boolean result = verifyPlusCalculationAction(a, b, 9);
        assertTrue(result);
    }

    @Test
    public void calculationVerifierTest2() {
        int a = 5;
        int b = 4;

        boolean result = verifyPlusCalculationAction(a, b, 8);
        assertTrue(result);
    }


    private boolean verifyPlusCalculationAction(int a, int b, int result) {
        return a + b == result;
    }


}
