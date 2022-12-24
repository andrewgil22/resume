package com.company;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
public class HardwareStore {
    private double totalRev;
    public Queue<Shopper> line;
    private Map<String,Item> inventoryItems = new HashMap<>();

    HardwareStore(){
        line = new PriorityQueue<>();
    }

    public void addShopperToLine(Shopper shopper) {
        line.add(shopper);
        totalRev = totalRev + shopper.amountOwed();
    }

    public double totalRevenue() {
        return totalRev;
    }

    public void checkoutAllShoppers() {
        double sum =0;

        for(Shopper s:line) {
            assert line.peek() != null;
            sum=+line.peek().amountOwed();
            line.poll();
        }
        System.out.println("Finished with all transactions! total is " + sum);
    }

    public void readInventoryList(File input) throws FileNotFoundException {
        Scanner in = new Scanner(input);
        while (in.hasNext()) {
            String item = in.next();
            int price = in.nextInt();
            Item newItem = new Item(item, price);
            inventoryItems.put(item,newItem);
        }
    }

    public void printInventoryList(){
        for(String i:inventoryItems.keySet()) {
            System.out.println(i);
        }
    }

    public void shoppersShopping(File input) throws FileNotFoundException {
        Scanner in = new Scanner(input);
        while(in.hasNext()){
            String firstName = in.next();
            String lastName = in.next();
            Shopper person = new Shopper(firstName, lastName);

            int numberOfTotalItems = Integer.parseInt(in.next());

            for(int i=1;i<=numberOfTotalItems;i++){
            String itemName = in.next();
            int numberOfSaidItem = Integer.parseInt(in.next());
            Item newItem = new Item(itemName,inventoryItems.get(itemName).getPrice());
            person.addItemToCart(newItem,numberOfSaidItem);
            }
            this.addShopperToLine(person);
        }
    }
}
