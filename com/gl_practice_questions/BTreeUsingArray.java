/*
Write a program to implement an Array Binary Tree where users need to input the number of elements and enter the elements.
Start Inserting values from Array Index 1. Use 0 to indicate that the value in the array index is null
(By default every index will hold value 0 in the array when created).
 */
package com.gl_practice_questions;
import java.util.Scanner;

public class BTreeUsingArray {
    public int[] tree;
    public int size, i;
    Scanner sc = new Scanner(System.in);

    public void insertValue() {
        System.out.println("Enter number of values to insert in the array binary tree");
        size = sc.nextInt();
        tree = new int[size + 1];
        for (i = 1; i <= size; i++) {
            System.out.println("\nEnter value " + i + ": ");
            tree[i] = sc.nextInt();
            printTree();
        }
    }

    public void printTree() {
        System.out.println("Binary Tree. Root is: " + tree[1]);
        for (int j = 1; j <= i; j++) {
            System.out.print(tree[j] + " ");
        }
    }

    public static void main(String[] args) {
        BTreeUsingArray btreeusingarray = new BTreeUsingArray();
        btreeusingarray.insertValue();
    }
}
