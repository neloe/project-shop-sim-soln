/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shopsimulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Customer {
    private Double budget;
    private HashSet<String> order;
    private ArrayList<String> cart;
    
    public Customer()
    {
        budget = 0.0;
        order = new HashSet<>();
        cart = new ArrayList<>();
    }
    
    public Customer(String filename) throws FileNotFoundException
    {
        order = new HashSet<>();
        cart = new ArrayList<>();
        loadCustomer(filename);
    }
    
    public void loadCustomer(String filename) throws FileNotFoundException
    {
        Scanner fin = new Scanner(new File(filename));
        budget = fin.nextDouble();
        while (fin.hasNext())
            order.add(fin.next());
    }
    
    public HashSet<String> getOrder()
    {
        return order;
    }
    
    public void putInCart(String item)
    {
        if (order.contains(item))
        {
            cart.add(item);
        }
    }
    
    public ArrayList<String> getCart()
    {
        return cart;
    }
    
    public void pay(Double amt)
    {
        budget -= amt;
    }
    
    public Double getBudget()
    {
        return budget;
    }
    public void updateOrder()
    {
        for (String item: cart)
            order.remove(item);
    }
}
