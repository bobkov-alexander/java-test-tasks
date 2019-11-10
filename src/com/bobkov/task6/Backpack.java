package com.bobkov.task6;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    int maxWeight;
    int currentWeight = 0;
    int currentValue = 0;
    List<Thing> things = new ArrayList<>();

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean isPossibleToAddThing(Thing thing) {
        return currentWeight + thing.weight <= maxWeight;
    }

    public void tryAddThing(Thing thing) {
        if (currentWeight + thing.weight <= maxWeight) {
            currentWeight += thing.weight;
            currentValue += thing.value;
            things.add(thing);
            return;
        }
    }

    public void removeThing(Thing thing) {
        things.remove(thing);
        currentWeight -= thing.weight;
        currentValue -= thing.value;
    }

    public void replaceAll(List<Thing> things) {
        this.things.clear();
        currentValue = 0;
        currentWeight = 0;
        for (int i = 0; i < things.size(); i++) {
            tryAddThing(things.get(i));
        }
    }

    public void printThings() {
        for (int i = 0; i < things.size(); i++) {
            System.out.println("Thing " + (i + 1) + " weight: " + things.get(i).weight + ", value: " + things.get(i).value);
        }
    }
}

