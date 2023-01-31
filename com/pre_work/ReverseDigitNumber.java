package com.pre_work;

import java.util.Scanner;

public class ReverseDigitNumber {
    public static void main(String[] args) {
        System.out.print("Please provide number: ");
        int number = new Scanner(System.in).nextInt();
        int reverse = 0;
        while (number > 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number = number / 10;
        }
        System.out.println("Reverse number of " + number + " is " + reverse);
    }
}
