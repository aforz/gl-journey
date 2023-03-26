package com.ds_algorithms;

public class SelectionSort {

    public static void performSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;  // searching for lowest index
                }
            }
            //swap
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void main(String[] args) {
        int[] arr = {100, 2, 4, 1, 56, 23, 9};
        System.out.println("Array before selection sort");
        printArray(arr);
        performSelectionSort(arr);
        System.out.println("Array after selection sort");
        printArray(arr);
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
