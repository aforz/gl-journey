package com.gl_practice_questions;

/**
 * Description
 * Write a program to implement MergeSort where
 * <p>
 * Ask the user to input the number of values
 * Create array accordingly and insert the values to array
 * Implement the merge sort.
 * Print the array after every iteration.
 * Print the output
 */

import java.util.Scanner;

public class MergeSort {
    public int i, NUM_ELEMENTS;
    public int array[], L[], R[];
    Scanner sc = new Scanner(System.in);

    public void implementationOfMergeSort() {
        System.out.println("Enter the number of elements you want to sort:");
        NUM_ELEMENTS = sc.nextInt();
        array = new int[NUM_ELEMENTS];
        System.out.println("Enter the elements now.");
        insertValues();
        sortArray(array, 0, array.length - 1);
    }

    public void insertValues() {
        for (i = 0; i < array.length; i++) {
            System.out.print("Enter element at position " + i + ": ");
            array[i] = sc.nextInt();
        }
    }

    public void sortArray(int array[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sortArray(array, l, m);
            sortArray(array, m + 1, r);
            conquerArray(array, l, m, r);
        }
    }

    public void conquerArray(int array[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (i = 0; i < n1; ++i) {
            L[i] = array[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
        printValues();
    }

    public void printValues() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Value at position " + i + "is:" + array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort mergesort = new MergeSort();
        mergesort.implementationOfMergeSort();
    }
}
