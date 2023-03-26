package com.ds_algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {4, 10, 18, 43, 56};
        int key = 430;
        binarySearch(array, 0, array.length - 1, key);
    }

    public static void binarySearch(int[] array, int first, int last, int key) {
        int mid = (first + last) / 2;
        while (first <= last) {
            if (array[mid] < key) {
                first = mid + 1;
            } else if (array[mid] == key) {
                System.out.println("Element found at array index: " + mid);
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println("Element is not found!");
        }
    }
}
