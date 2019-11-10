package com.bobkov.task6;

import java.util.ArrayList;
import java.util.List;

public class BackpackUtil {
    public static int getBackpackWeight(Backpack backpack) {
        int totalWeight = 0;
        for (int i = 0; i < backpack.things.size(); i++) {
            totalWeight += backpack.things.get(i).weight;
        }
        return totalWeight;
    }

    public static int getBackpackValue(Backpack backpack) {
        int totalValue = 0;
        for (int i = 0; i < backpack.things.size(); i++) {
            totalValue += backpack.things.get(i).value;
        }
        return totalValue;
    }

    public static boolean isPossibleToAddThing(Backpack backpack, Thing thing) {
        return getBackpackWeight(backpack) + thing.weight <= backpack.maxWeight;
    }

    public static void tryAddThing(Backpack backpack, Thing thing) {
        if (getBackpackWeight(backpack) + thing.weight <= backpack.maxWeight) {
            backpack.things.add(thing);
        }
    }

    public static void removeThing(Backpack backpack, Thing thing) {
        backpack.things.remove(thing);
    }

    public static void replaceAll(Backpack toBackpack, Backpack fromBackpack) {
        toBackpack.things.clear();
        for (int i = 0; i < fromBackpack.things.size(); i++) {
            tryAddThing(toBackpack, fromBackpack.things.get(i));
        }
    }

    public static void printThings(Backpack backpack) {
        for (int i = 0; i < backpack.things.size(); i++) {
            System.out.println("Thing " + (i + 1) + " weight: " + backpack.things.get(i).weight + ", value: " + backpack.things.get(i).value);
        }
    }

    public static void findBestThings(Backpack resultBackpack, Backpack backpack, List<Thing> things) {
        if (things.size() == 0) {
            if (getBackpackValue(resultBackpack) < getBackpackValue(backpack)) {
                replaceAll(resultBackpack, backpack);
            }
            return;
        }
        for (int i = 0; i < things.size(); i++) {
            if (isPossibleToAddThing(backpack, things.get(i))) {
                List<Thing> copyThings = new ArrayList<>(things);
                Thing thing = copyThings.remove(i);
                tryAddThing(backpack, thing);
                findBestThings(resultBackpack, backpack, copyThings);
                removeThing(backpack, thing);
            } else if (getBackpackValue(resultBackpack) < getBackpackValue(backpack)) {
                replaceAll(resultBackpack, backpack);
            }
        }
    }
}
