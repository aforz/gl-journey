package com.gl_practice_questions;

/*
Description
Write a program to implement the quick sort where

Ask the user to input the number of values in an array.
Create an array accordingly and insert the values
Implement the quick sort
Print the array after every iteration
 */

import java.util.Scanner;

public class QuickSort {
    public int temp, i, j, l, r;
    public static int PIVOT;
    public int array[] = { 9,7,5,4,3,2,1,0 };  //{22, 0, 4, 0, 11, 1, -2};
    Scanner sc = new Scanner(System.in);

    public void imlpementationOfQuickSort() {
        l = 0;
        r = array.length - 1;
        printValues();
        divideArray(array, l, r);
    }

    public void divideArray(int array[], int l, int r) {
        if (l < r) {
            int pi = partition(array, l, r);
            divideArray(array, l, pi - 1);
            divideArray(array, pi + 1, r);
        }
    }

    public int partition(int array[], int l, int r) {
        PIVOT = l;
        i = l;
        j = r;
        while ((checkBelowPivot() == false) || (checkAbovePivot() == false)) {
            System.out.println("i, j: " + i + ", " + j);
            checkFromRight();
            checkFromLeft();
        }
        return PIVOT;
    }

    public boolean checkBelowPivot() {
        for (int k = 0; k <= PIVOT; k++) {
            if (array[k] > array[PIVOT]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkAbovePivot() {
        if (PIVOT < array.length - 1) {
            for (int k = PIVOT + 1; k < array.length - 1; k++) {
                if (array[k] < array[PIVOT]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void checkFromRight() {
        for (int k = j; k > PIVOT; k--) {
            if (array[k] < array[PIVOT]) {
                swapValues(i, k);
                printValues();
                PIVOT = j = k;
                checkFromLeft();
            }
        }
    }

    public void checkFromLeft() {
        for (int k = i; k < PIVOT; k++) {
            if (array[k] > array[PIVOT]) {
                swapValues(k, j);
                printValues();
                PIVOT = i = k;
                checkFromRight();
            }
        }
    }

    public void swapValues(int i, int j) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printValues() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Value at position " + i + "is:" + array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort quicksort = new QuickSort();
        quicksort.imlpementationOfQuickSort();
    }
}
