package com.bobkov.task3;

import com.bobkov.task1.NumberChecker;

import java.util.Arrays;
import java.util.Scanner;

public class WordUtil {
    public static int countWords(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                count++;
            }
        }
        return count;
    }

    public static void capitalize(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) {
                continue;
            }
            if (words[i].length() == 1) {
                words[i] = words[i].toUpperCase();
                continue;
            }
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
    }
    public static void printArray(String[] words){
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                System.out.print(words[i]+" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        System.out.println("Number of words is " + countWords(words));
        Arrays.sort(words);
        printArray(words);
        capitalize(words);
        printArray(words);
    }
}
