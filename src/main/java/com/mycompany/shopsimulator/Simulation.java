/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shopsimulator;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author squishy
 */
public class Simulation {
    public static void main(String[] args) throws FileNotFoundException
    {
        Shop foodMart = new Shop("inventory.txt");
        ArrayList<Customer> custs = new ArrayList<>();
        custs.add(new Customer("c1.txt"));
        custs.add(new Customer("c2.txt"));
        custs.add(new Customer("c3.txt"));
        
        for (int i=0; i< custs.size(); i++)
            System.out.println("Customer "+ i + " has $"+custs.get(i).getBudget());
        
        for (Customer c: custs)
            foodMart.fillOrder(c);
        
        for (int i=0; i<custs.size(); i++)
            foodMart.checkout();
        
        for (int i=0; i< custs.size(); i++)
        {
            System.out.print("Customer "+ i + " has $"+custs.get(i).getBudget());
            System.out.println(" remaining and bought " + custs.get(i).getCart());
        }
    }
}
