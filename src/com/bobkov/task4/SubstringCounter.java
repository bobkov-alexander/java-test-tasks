package com.bobkov.task4;

import java.util.Scanner;


public class SubstringCounter {

    public static int countMatches(String text, String searchWord) {
        text = text.toLowerCase();
        searchWord = searchWord.toLowerCase();
        int counter = 0;
        while (text.contains(searchWord)) {
            counter++;
            int position = text.indexOf(searchWord) + 1;
            if (position >= text.length()) {
                break;
            }
            text = text.substring(position);
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.print("Enter a search word: ");
        String word = scanner.nextLine();
        System.out.println("Number of matches: " + countMatches(text, word));
    }
}
