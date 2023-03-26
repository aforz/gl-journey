package com.gl_practice_questions;

/*
Description
Write a program to implement Radix sort where

Ask user to provide the number of inputs
Create an array accordingly and accept only positive integer values to the array
Print the values along with the max value in the list.
Write your logic where necessary in the below stub code.
Print the sorted array
 */

import java.util.Scanner;

public class RadixSort {
    public int max, i, remainder, count, temp, modinput, NUM_ELEMENTS, startpoint;
    public int[] array;
    Scanner sc = new Scanner(System.in);

    public void implementationOfRadixSort() {
        System.out.println("Enter the number of elements you want to sort: ");
        NUM_ELEMENTS = sc.nextInt();
        array = new int[NUM_ELEMENTS];
        System.out.println("Enter positive integers only.");
        insertValues();
        printValues();
        findMaxValue();
        remainder = max;
        while (remainder != 0) {
            remainder = remainder / 10;
            count++;
        }
        System.out.println("digits in max is " + count);
        sortValues();
        System.out.println("\nThe Sorted array is: \n");
        printValues();
    }

    public void insertValues() {
        for (i = 0; i < array.length; i++) {
            System.out.print("Enter element at position " + i + ": ");
            array[i] = sc.nextInt();
        }
    }

    public void printValues() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Value at position " + i + "is:" + array[i]);
        }
        System.out.println();
    }

    public void findMaxValue() {
        i = 0;
        do {
            if (max < array[i]) {
                max = array[i];
            }
            i++;
        } while (i < array.length);
        System.out.println("max value is: " + max);
    }

    public void sortValues() {
        for (i = 1; i <= count; i++) {
            System.out.println("\nIteration " + i + "\n");
            for (int j = 0; j < 10; j++) { // digit searchvalue is j
                System.out.println("\nSearching at position " + i + " fromright for digit " + j + "\n");
                for (int k = startpoint; k < array.length; k++) { // checkingeach digit for the digit search value
                    remainder = array[k];
                    System.out.println("value is: " + remainder);
                    int q = i;
                    /** q is number of times to perform division operation before applying mod. we do this only to find the second, third,.... placevalueof a number. we then* apply modulus operation for the remainder.*/
                    while (q > 1) {
                        remainder = remainder / 10;
                        q--;
                    }
                    modinput = remainder;
                    if (modinput % 10 == j) {
                        System.out.println("digit at position " + i + "from right for value " + array[k] + " is: " + modinput % 10);
                        System.out.println("Start point is: " + startpoint);
                        temp = array[k];
                        for (int p = k; p > startpoint; p--) { // shifting values to right
                            array[p] = array[p - 1];
                        }
                        array[startpoint] = temp;
                        startpoint += 1;
                        printValues();
                    } else
                        System.out.println("digit at position " + i + "from right for value " + array[k] + " is: " + modinput % 10);
                }
            }
            startpoint = 0;
        }
    }

    public static void main(String[] args) {
        RadixSort radixsort = new RadixSort();
        radixsort.implementationOfRadixSort();
    }
}
