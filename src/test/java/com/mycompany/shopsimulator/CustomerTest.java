/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shopsimulator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
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
public class CustomerTest {
    
    public CustomerTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    /**
     * Test of loadCustomer method, of class Customer.
     */
    @org.junit.jupiter.api.Test
    public void testLoadCustomer() throws Exception {
        String filename = "c1.txt";
        Customer instance = new Customer();
        instance.loadCustomer(filename);
        assertEquals(new Double(10.00), instance.getBudget());
        assert(instance.getOrder().contains("spaghetti"));
        assert(!instance.getOrder().contains("mac_n_cheese"));
        
    }

    /**
     * Test of pay method, of class Customer.
     */
    @org.junit.jupiter.api.Test
    public void testPay() throws FileNotFoundException {
        Double amt = 5.00;
        Customer instance = new Customer("c1.txt");
        instance.pay(amt);
        assertEquals(amt, instance.getBudget());
    }

    /**
     * Test of getBudget method, of class Customer.
     */
    @org.junit.jupiter.api.Test
    public void testPutInCartOnList() throws FileNotFoundException {
        Customer instance = new Customer("c1.txt");
        instance.putInCart("pork");
        assert(instance.getCart().contains("pork"));
    }
    
    @org.junit.jupiter.api.Test
    public void testPutInCartNotOnList() throws FileNotFoundException {
        Customer instance = new Customer("c1.txt");
        instance.putInCart("beef");
        assert(!instance.getCart().contains("beef"));
    }

    /**
     * Test of updateOrder method, of class Customer.
     */
    @org.junit.jupiter.api.Test
    public void testUpdateOrder() throws FileNotFoundException {
        Customer instance = new Customer("c1.txt");
        instance.putInCart("pork");
        instance.putInCart("apples");
        instance.updateOrder();
        assert(!instance.getOrder().contains("pork"));
        assert(!instance.getOrder().contains("apples"));
    }
    
}
