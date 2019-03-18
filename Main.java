package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // we take the same instance of the problem displayed in the image
        List<Item> items = new LinkedList<Item>();
        Knapsack knapsack = new Knapsack(items, 15);
        knapsack.addItem(5,10);
        knapsack.addItem(10,4);
        knapsack.addItem(8, 3);
        knapsack.addItem(2, 5);
        knapsack.addItem(2,2);


        List<Solver> solvers = new ArrayList<Solver>();
        solvers.add(new Dynamic(knapsack.items, knapsack.capacity));
        solvers.add(new Greedy(knapsack.items, knapsack.capacity));


        knapsack.display();
        Solution solution = solvers.get(0).solve();
        Solution solution1 = solvers.get(1).solve();
        solution.display();
        System.out.println(solvers.get(0).info());
        solution1.display();
        System.out.println(solvers.get(1).info());
    }
}