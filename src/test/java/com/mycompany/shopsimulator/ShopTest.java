/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shopsimulator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author squishy
 */
public class ShopTest {
    
    public ShopTest() {
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
     * Test of restock method, of class Shop.
     */
    @Test
    public void testRestock() throws Exception {
        String fname = "inventory.txt";
        Shop instance = new Shop();
        instance.restock(fname);
        assertEquals(1.49, instance.priceCheck("spaghetti"));
        assertEquals(0.99, instance.priceCheck("apples"));
        assertEquals(4.00, instance.priceCheck("cold_cuts"));
    }
    @Test
    public void testPriceCheckException() throws Exception {
        String fname = "inventory.txt";
        Shop instance = new Shop();
        instance.restock(fname);
        assertThrows(OutOfStockException.class, ()->{
            instance.priceCheck("oranges");
        });
    }

    /**
     * Test of fillOrder method, of class Shop.
     */
    @Test
    public void testFillOrder() throws FileNotFoundException {
        Customer c = new Customer("c1.txt");
        Shop instance = new Shop("inventory.txt");
        instance.fillOrder(c);
        assert(c.getCart().contains("chicken"));
        assert(c.getCart().contains("spaghetti"));
        assert(c.getCart().contains("apples"));
    }

    /**
     * Test of checkout method, of class Shop.
     */
    @Test
    public void testCheckoutOne() throws FileNotFoundException {
        Customer c = new Customer("c1.txt");
        Shop instance = new Shop("inventory.txt");
        instance.fillOrder(c);
        instance.checkout();
        assertEquals(3.72, c.getBudget(), 0.009);
    }
    
    @Test
    public void testCheckoutOrder() throws FileNotFoundException {
        Shop instance = new Shop("inventory.txt");
        ArrayList<Customer> custs = new ArrayList<>();
        custs.add(new Customer("c1.txt"));
        custs.add(new Customer("c2.txt"));
        custs.add(new Customer("c3.txt"));
        
         for (Customer c: custs)
            instance.fillOrder(c);
        instance.checkout();
        assertEquals(3.72, custs.get(0).getBudget(), 0.009);
        instance.checkout();
        assertEquals(4.01, custs.get(1).getBudget(), 0.009);
        instance.checkout();
        assertEquals(10.31, custs.get(2).getBudget(), 0.009);
    }
    
}
