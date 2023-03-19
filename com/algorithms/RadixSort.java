package com.algorithms;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Array before sorting");
        printArray(array);
        radixSort(array, array.length);
        System.out.println();
        System.out.println("Array after sorting");
        printArray(array);
    }

    static void radixSort(int[] array, int size) {
        int m = getMaxElement(array, size); //Find the maximum number to know number of digits
        //Do counting sort for every digit. note that instead of passing digit number, exp is passed.
        //exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(array, size, exp);
    }

    // function to get maximum value in array[]
    static int getMaxElement(int[] array, int size) {
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    //A function to do counting sort of Array[] according to the digit represented be exp
    static void countSort(int[] array, int size, int exp) {
        int[] output = new int[size];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        //store count of occurrences in count[]
        for (i = 0; i < size; i++)
            count[(array[i] / exp) % 10]++;

        //Change count[i] so that count[i] now contains actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        //build the output array
        for (i = size - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // copy the output array to array[], so that array[] now contains sorted number according to current digit
        for (i = 0; i < size; i++)
            array[i] = output[i];

    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
