package com.company;

import java.util.List;

public abstract class Solver{

    public List<Item> items;
    public int capacity;

    protected Solver(List<Item> items, int capacity)
    {
        this.items = items;
        this.capacity = capacity;
    }

    public abstract Solution solve();
    public abstract String info();
}