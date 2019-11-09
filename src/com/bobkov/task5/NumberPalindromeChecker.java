package com.bobkov.task5;

import java.util.Scanner;

public class NumberPalindromeChecker {
    public static boolean isPalindrome(int number) {
        String textNumber = String.valueOf(number);
        for (int i = 0; i < textNumber.length() / 2; i++) {
            if (textNumber.charAt(i) != textNumber.charAt(textNumber.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number N: ");
        int maxNumber = scanner.nextInt();
        if (maxNumber > 100 || maxNumber <= 0) {
            System.out.println("Your number is not in range 0..100");
            return;
        }
        System.out.print("Palindromes: ");
        for (int i = 0; i <= maxNumber; i++) {
            if (isPalindrome(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
