/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takehometestimpactmain;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author viljo
 */
public class NumberRangeImplementationTest {
    
    public NumberRangeImplementationTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of collect method, of class NumberRangeImplementation.
     */
    @Test
    public void testCollect() {
        System.out.println("collect");
        String input = "1,3,6,17,8,12,13,14,15,21,22,23,24,31";
        NumberRangeImplementation instance = new NumberRangeImplementation();
        Collection<Integer> expResult = null;
        Collection<Integer> result = instance.collect(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of summarizeCollection method, of class NumberRangeImplementation.
     */
    @Test
    public void testSummarizeCollection() {
        System.out.println("summarizeCollection");
        int[] numsTest = {1,3,6,17,8,12,13,14,15,21,22,23,24,31};
        Collection<Integer> input = new ArrayList<>();
        for(int x=0; x < numsTest.length; x++){
            input.add(numsTest[x]);
        }
        NumberRangeImplementation instance = new NumberRangeImplementation();
        String expResult = "1, 3, 6, 8, 12-15, 17, 21-24, 31,";
        String result = instance.summarizeCollection(input);
        assertEquals(expResult, result);
    }
    
}
