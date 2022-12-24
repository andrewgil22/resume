package com.company;
public class Shopper implements Comparable<Shopper> {
    private String firstName;
    private String lastName;
    ShoppingCart cart;

    public Shopper(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName = lastName;
        cart = new ShoppingCart();
    }

    void addItemToCart(Item item, int numItems) {
        int num = 1;
        while(!(num>numItems)) {
            cart.addItem(item);
            numItems--;
        }
    }

    int amountOwed() {
        return (int) Math.ceil(cart.grandTotal() * 1.08875);
    }

    public String toString() {
        return firstName + " " + lastName + " owes " + this.amountOwed();
    }

    @Override
    public int compareTo(Shopper o) {
        return o.amountOwed() - this.amountOwed();
    }

}
