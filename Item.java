package com.company;

public class Item {

    public float value;
    public int weight;

    public Item(float value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public String str() {
        return "[value = " + value + ", weight = " + weight + "]";
    }

    public float getRatio()
    {
        return (value/weight);
    }

}