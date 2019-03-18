package com.company;

import java.util.*;

public class Dynamic extends Solver {

    public Dynamic(List<Item> items, int capacity) {
        super(items, capacity);
    }

    static float max(float a, float b) { return (a > b)? a : b; }

    @Override
    public Solution solve() {
        int n = items.size();
        // we use a matrix to store the max value at each n-th item
        float[][] M = new float[n + 1][capacity + 1];

        // Wynik[i, j] oznacza rozwiązanie dla pierwszych i przedmiotów oraz plecaka rozmiaru j.
        // Znając wynik dla mniejszych danych możemy obliczyć go dla większych danych.
        // Możemy bowiem albo nie brać i-tego przedmiotu i zapełnić j kilogramów poprzednimi przedmiotami (wynik[i-1, j]),
        // albo wziąć i-ty przedmiot i zapełnić j-wi kilogramów poprzednimi przedmiotami (wynik[i-1, j-wi]+ci),
        // albo pozostawić ostatni kilogram plecaka pusty i popatrzeć co się mieści w j-1 kilogramach (wynik[i, j-1]).
        // Rozwiązanie to działa w czasie O(NK).
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= capacity; j++)//po pojemnosci
            {
                if (i==0 || j==0)
                    M[i][j] = 0;
                else if (items.get(i - 1).weight <= j)
                    M[i][j] = max(items.get(i - 1).value + M[i-1][j-items.get(i - 1).weight], M[i-1][j]);
                    //max z
                else
                    M[i][j] = M[i-1][j];
            }
        }

        float temp = M[n][capacity];
        int w = capacity;
        List<Item> itemsSolution = new ArrayList<>();

        for (int i = n; i > 0  &&  temp > 0; i--) {
            if (temp != M[i-1][w]) {
                itemsSolution.add(items.get(i - 1));
                // we remove items value and weight
                temp -= items.get(i - 1).value;
                w -= items.get(i - 1).weight;
            }
        }

        return new Solution(itemsSolution, M[n][capacity]);
    }

    @Override
    public String info() {
        return("Dynamic algorhitm\n");
    }
}