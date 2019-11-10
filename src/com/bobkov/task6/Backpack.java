package com.bobkov.task6;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    int maxWeight;
    List<Thing> things = new ArrayList<>();

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}

