package com.company;
import java.util.*;
public class ShoppingCart {
    private List<Item> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addItem(Item item) {
        cart.add(item);
    }

    public int grandTotal() {
        int sum=0;
        for(Item c:cart) {
            sum = sum + c.getPrice();
        }
        return sum;
    }

    public int numItems() {
        return cart.size();
    }

    public String toString() {
        return cart.toString();
    }
}
