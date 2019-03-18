package com.company;

import java.util.*;

public class Greedy extends Solver {

    public Greedy(List<Item> items, int capacity) {
        super(items, capacity);
    }

    class SortByRatio implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            return Float.compare(a.getRatio(), b.getRatio());
        }
    }

    @Override
    public Solution solve() {
        int sum_weight = 0;
        float value = 0;
        List<Item> itemsSolution = new ArrayList<>();
        Collections.sort(items, new SortByRatio());

        for(int i = (items.size() - 1); i >= 0 ; i--)
        {
            if(sum_weight + items.get(i).weight <= capacity)
            {
                itemsSolution.add(items.get(i));
                sum_weight += items.get(i).weight;
                value += items.get(i).value;
            }
            else
                break;
        }

        return new Solution(itemsSolution, value);
    }

    @Override
    public String info() {
        return("Greedy algorhitm\n");
    }
}