package com.algorithms;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {101, 20, 31, 5, 701, 90};
        int keyElement = 5;
        int position = linearSearch(array, keyElement);
        if (position == -1)
            System.out.println("Element is not present in the given array.");
        else
            System.out.println("Element found at array index " + position);
    }

    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
