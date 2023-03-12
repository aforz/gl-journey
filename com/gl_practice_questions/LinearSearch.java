package com.gl_practice_questions;

import java.util.Scanner;

public class LinearSearch {
    public int NUM_ELEMENTS, SEARCH_ELEMENT;
    public int array[];
    public boolean status = false;
    Scanner sc = new Scanner(System.in);

    public void implementationOfLinearSearch() {
        System.out.println("Enter the number of elements you want to have in the array.");
        NUM_ELEMENTS = sc.nextInt();
        array = new int[NUM_ELEMENTS];
        System.out.println("Enter the elements now.");
        insertValues();
        printValues();
        System.out.println("Enter an element to search");
        SEARCH_ELEMENT = sc.nextInt();
        searchValue(SEARCH_ELEMENT);
    }

    public void insertValues() {
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            System.out.print("Enter element at position " + i + ": ");
            array[i] = sc.nextInt();
        }
    }

    public void printValues() {
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            System.out.println("Value at position " + i + "is:" + array[i]);
        }
        System.out.println();
    }

    public void searchValue(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                System.out.println("Search value " + SEARCH_ELEMENT + " found at array index " + i);
                status = true;
            }
        }
        if (status == false) {
            System.out.println("Value not found!!!");
        }
    }

    public static void main(String[] args) {
        LinearSearch linearsearch = new LinearSearch();
        linearsearch.implementationOfLinearSearch();
    }
}
