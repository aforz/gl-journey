package com.algorithms;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {100, 2, 4, 1, 56, 23, 9};
        System.out.println("Array before insertion sort.");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        performInsertionSort(arr);
        System.out.println("Array after insertion sort.");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void performInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while ((j > -1) && (arr[j]) > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
