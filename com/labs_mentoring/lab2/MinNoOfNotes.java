package com.labs_mentoring.lab2;

import java.util.Scanner;

public class MinNoOfNotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of currency denominations ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("enter the currency denominations value\n");
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        System.out.println("enter the amount you want to pay");
        int targetAmt = sc.nextInt();

        int[] counts = new int[size];
        for (int i = 0; i < size; i++) {
            if (targetAmt >= arr[i]) {
                counts[i] = targetAmt / arr[i];
                targetAmt = targetAmt % arr[i];
            }
        }
        System.out.println("Your payment approach in order to give min no of notes will be");
        for (int i = 0; i < size; i++) {
            if (counts[i] != 0) {
                System.out.println(arr[i] + " : " + counts[i]);
            }
        }
    }
}
