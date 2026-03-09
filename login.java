/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ims001;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jhescel Ann
 */
public class login {
    
}
public class StockSummary {

    private final int total;
    private final int inStock;
    private final int lowStock;
    private final int outStock;

    // LOGIN HISTORY LIST
    private static final List<String> loginHistory = new ArrayList<>();

    public StockSummary(int total, int inStock, int lowStock, int outStock) {
        this.total = total;
        this.inStock = inStock;
        this.lowStock = lowStock;
        this.outStock = outStock;
    }

    public int getTotal() { return total; }
    public int getInStock() { return inStock; }
    public int getLowStock() { return lowStock; }
    public int getOutStock() { return outStock; }

    // RECORD USER LOGIN
    public static void recordLogin(String username) {
        LocalDateTime now = LocalDateTime.now();
        String record = username + " logged in at " + now;
        loginHistory.add(record);
    }

    // GET LOGIN HISTORY
    public static List<String> getLoginHistory() {
        return loginHistory;
    }
}