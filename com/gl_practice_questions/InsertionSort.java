package com.gl_practice_questions;

import java.util.Scanner;

public class InsertionSort {
    public int NUM_ELEMENTS, i, min, temp, startPoint = 0;
    public int array[];
    public boolean status;
    Scanner sc = new Scanner(System.in);
    private int sortedvalue;

    public void implementationOfInsertionSort() {
        System.out.println("Enter the number of elements you want to sort:");
        NUM_ELEMENTS = sc.nextInt();
        array = new int[NUM_ELEMENTS];
        System.out.println("Enter the elements now.");
        insertValues();
        status = checkForStatus();
        do {
            sortValues();
            printValues();
            sortedvalue += 1;
            status = checkForStatus();
        } while (status == false);
    }

    public void insertValues() {
        for (i = 0; i < NUM_ELEMENTS; i++) {
            System.out.print("Enter element at position " + i + ": ");
            array[i] = sc.nextInt();
        }
    }

    public void sortValues() {
        int j = sortedvalue;
        while ((j > 0) && (j < NUM_ELEMENTS) && (array[j] < array[j - 1])) {
            temp = array[j - 1];
            array[j - 1] = array[j];
            array[j] = temp;
            j -= 1;
        }
    }

    public void printValues() {
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            System.out.println("Value at position " + i + "is:" + array[i]);
        }
        System.out.println();
    }

    public boolean checkForStatus() {
        for (i = 0; i < NUM_ELEMENTS - 1; i++) {
            if (array[i] > array[i + 1]) {
                sortedvalue = i + 1;
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        InsertionSort insertionsort = new InsertionSort();
        insertionsort.implementationOfInsertionSort();
    }
}
