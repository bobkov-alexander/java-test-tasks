package com.bobkov.task6;

import sun.print.BackgroundLookupListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static Backpack initBackpack(Scanner scanner) {
        System.out.print("Enter backpack max weight: ");
        int maxWeight = scanner.nextInt();
        return new Backpack(maxWeight);
    }

    public static List<Thing> initThings(Scanner scanner) {
        List<Thing> things = new ArrayList<>();
        System.out.print("Enter the number of items: ");
        int numberItems = scanner.nextInt();
        for (int i = 0; i < numberItems; i++) {
            System.out.print("Enter the weight " + (i + 1) + " item: ");
            int weight = scanner.nextInt();
            System.out.print("Enter the value " + (i + 1) + " item: ");
            int value = scanner.nextInt();
            Thing thing = new Thing(value, weight);
            things.add(thing);
        }
        return things;
    }

    public static void findBestThings(Backpack resultBackpack, Backpack backpack, List<Thing> things) {
        if (things.size() == 0) {
            if (resultBackpack.currentValue < backpack.currentValue) {
                resultBackpack.replaceAll(backpack.things);
            }
            return;
        }
        for (int i = 0; i < things.size(); i++) {
            if (backpack.isPossibleToAddThing(things.get(i))) {
                List<Thing> copyThings = new ArrayList<>(things);
                Thing thing = copyThings.remove(i);
                backpack.tryAddThing(thing);
                findBestThings(resultBackpack, backpack, copyThings);
                backpack.removeThing(thing);
            } else if (resultBackpack.currentValue < backpack.currentValue) {
                resultBackpack.replaceAll(backpack.things);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Backpack backpack = initBackpack(scanner);
        Backpack resultBackpack = new Backpack(backpack.maxWeight);
        List<Thing> things = initThings(scanner);
        findBestThings(resultBackpack, backpack, things);
        resultBackpack.printThings();
    }
}
