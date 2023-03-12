package com.gl_practice_questions;

import java.util.Scanner;

public class SelectionSort {
    public int NUM_ELEMENTS, i, min, temp, startPoint = 0;
    public int array[];
    public boolean status;
    Scanner sc = new Scanner(System.in);

    public void implementationOfSelectionSort() {
        System.out.println("Enter the number of elements you want to sort:");
        NUM_ELEMENTS = sc.nextInt();
        array = new int[NUM_ELEMENTS];
        System.out.println("Enter the elements now.");
        insertValues();
        // Sort values();
        do {
            sortValues();
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
        if (startPoint < array.length - 1) {
            if (array[startPoint] < array[startPoint + 1]) {
                min = startPoint;
            } else min = startPoint + 1;
            for (i = startPoint + 1; i < array.length; i++) {
                if (array[min] > array[i]) {
                    min = i;
                }
            }
            temp = array[startPoint];
            array[startPoint] = array[min];
            array[min] = temp;
            printValues();
            startPoint += 1;
        }

    }

    public void printValues() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Value at position " + i + "is:" + array[i]);
        }
        System.out.println();
    }

    public boolean checkForStatus() {
        for (i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SelectionSort selectionsort = new SelectionSort();
        selectionsort.implementationOfSelectionSort();
    }
}
