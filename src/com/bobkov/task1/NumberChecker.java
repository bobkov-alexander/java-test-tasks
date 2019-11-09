package com.bobkov.task1;

import java.util.Scanner;

public class NumberChecker {

    public static boolean isSimple(long number) {
        number = number > 0 ? number : -number;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(long number) {
        return number % 2 == 0;
    }

    public static boolean isInteger(double number) {
        return number == (long) number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        double divisionalNumber = scanner.nextDouble();
        if (!isInteger(divisionalNumber)) {
            System.out.println("Your number isn`t integer");
            return;
        }
        long number = (long) divisionalNumber;
        if (number==0){
            System.out.println("Your number is not simple and is not composite");
            System.out.println("Your number is even");
            return;
        }
        if (isSimple(number)) {
            System.out.println("Your number is simple");
        } else {
            System.out.println("Your number is composite");
        }
        if (isEven(number)) {
            System.out.println("Your number is even");
        } else {
            System.out.println("Your number is odd");
        }
    }
}
