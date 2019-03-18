package com.company;

import java.util.List;

public class Knapsack {

    // items of our problem
    public List<Item> items;
    // capacity of the bag
    public int capacity;

    public Knapsack(List<Item> items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public void addItem(float value, int weight){
        Item item = new Item(value, weight);
        items.add(item);
    }

    public void display() {
        if (items != null  &&  items.size() > 0) {
            System.out.println("Knapsack problem");
            System.out.println("Capacity : " + capacity);
            System.out.println("Items :");

            for (Item item : items) {
                System.out.println(item.str());
            }
        }
    }
}
