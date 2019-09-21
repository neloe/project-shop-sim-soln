/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shopsimulator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;


public class Shop {
    private HashMap<String, Double> inventory;
    private Queue<Customer> checkout;
    
    public Shop()
    {
        inventory = new HashMap<>();
        checkout = new LinkedList<>();
    }
    
    public Shop(String inv_filename) throws FileNotFoundException
    {
        inventory = new HashMap<>();
        checkout = new LinkedList<>();
        restock(inv_filename);
    }
    
    public void restock(String fname) throws FileNotFoundException
    {
        Scanner fin = new Scanner(new File(fname));
        while (fin.hasNext())
        {
            inventory.put(fin.next(), fin.nextDouble());
        }
        
    }
    
    public double priceCheck(String item)
    {
        if (inventory.containsKey(item))
            return inventory.get(item);
        throw new OutOfStockException(item + " not in stock");
    }
    
    public void fillOrder(Customer c)
    {
        for (String item: c.getOrder())
            if (inventory.containsKey(item))
                c.putInCart(item);
        c.updateOrder();
        checkout.add(c);
    }
    
    public void checkout()
    {
        if (!checkout.isEmpty())
        {
            Customer c = checkout.remove();
            Double total = 0.0;
            for (String item: c.getCart())
                total += priceCheck(item);
            c.pay(total);
        }
    }
}
