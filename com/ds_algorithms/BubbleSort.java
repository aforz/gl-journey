package com.ds_algorithms;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {100, 2, 4, 1, 56, 23, 9};
        System.out.println("Array before Bubble sort.");
        printArray(array);
        performBubbleSort(array);
        System.out.println("Array after Bubble sort.");
        printArray(array);
    }

    static void performBubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
