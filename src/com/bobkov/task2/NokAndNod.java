package com.bobkov.task2;

import java.util.Scanner;

public class NokAndNod {
    public static int nod(int first, int second) {
        while (first != 0 && second != 0) {
            if (first > second) {
                first = first % second;
            } else {
                second = second % first;
            }
        }
        return first + second;
    }

    public static int nok(int first, int second) {
        return first * second / nod(first, second);
    }

    public static int inputNumber(String messageOnInput) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(messageOnInput);
            String line = scanner.nextLine();
            try {

                int number = Integer.parseInt(line);
                if (number == 0) {
                    System.out.println("Invalid number");
                    continue;
                }
                return number > 0 ? number : -number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }
    }

    public static void main(String[] args) {
        int first = inputNumber("Enter first number: ");
        int second = inputNumber("Enter second number: ");

        System.out.println("NOD is: " + nod(first, second));
        System.out.println("NOK is: " + nok(first, second));
    }
}
