/*
Write a program to implement Operations on Array Binary Tree where users need to be provided with below options to choose.
(Ask users, how many numbers they want to insert every time when he/she wants to insert new values into the array)
 */
package com.gl_practice_questions;

import java.util.Scanner;

public class OperationsOnBTreeUsingArray {
    static public int[] tree = new int[2], tmptree;
    static public int i;
    public int size, key, index, val, r, a = 0, newvalue;
    static Scanner sc = new Scanner(System.in);

    public void insertValue() { // when array is empty
        System.out.println("Enter number of values to insert in the array binary tree");
        size = sc.nextInt();
        tree = new int[size + 1];
        for (i = 1; i <= size; i++) {
            System.out.println("Enter value " + i + ": ");
            newvalue = sc.nextInt();
            if (newvalue != 0) { // check if inserted value is not 0
                tree[i] = newvalue;
                printTree();
            } else {
                System.out.println("cannot use 0. Reserved for other purpose. Inser different value");
                i--;
            }
        }
        i--;
    }

    public void insertNewValues() { // when array has values
        System.out.println("\nAccept number of values to input");
        size = sc.nextInt();

        // if (countBlankspaces() <= size) { // finding the empty space.
        // insert(size); // if empty spaces is less than size then enter if condition
        // }

        if ((i + size + 1) > tree.length) { // used when the no of values to input is greater than empty spaces
            // set size of tmptree array to new size
            tmptree = new int[i + size + 2];
            // copy from tree array to tmptree array
            System.arraycopy(tree, 0, tmptree, 0, tree.length);
            // resize tree array
            tree = new int[tmptree.length];
            // copy from tmptree array to tree array
            System.arraycopy(tmptree, 0, tree, 0, tree.length);
            // insert values to tree array of new size
            insert(size);
        }
    }

    public void insert(int s) {
        while (size > 0) {
            i++;
            System.out.println("Enter value at " + i);
            newvalue = sc.nextInt();
            if (newvalue != 0) { // check if inserted value is not 0
                tree[i] = newvalue;
                size--;
            } else {
                System.out.println("cannot use 0. Reserved for other purpose. Inser different value");
                i--;
            }
            printTree();
        }
    }

    public void deleteValue() {
        System.out.println("Enter value to delete");
        key = sc.nextInt();
        if (key != 0) {
            index = searchValue(key);
            if (index != -1) {
                if (index == i) { // if deletion value is last value then delete and decrement i
                    tree[index] = 0;
                    i -= 1;
                } else {
                    tree[index] = tree[i]; // replace deletion value
                    tree[i] = 0; // make deepest rightmost value to 0
                    i -= 1;
                }
                printTree();
                printFamily();
                System.out.println("Value found and deleted!!!");
            } else { // if variable val is -1
                System.out.println("\nValue " + key + " does not exist in the tree\n");
            }
        } else { // if deletion value is 0
            System.out.println("Value 0 does not exist!!!");
        }
    }

    public int searchValue(int key) { // search for the value in the array
        for (int j = 1; j <= i; j++) {
            if (key == tree[j]) { // if match found, return its index
                return j;
            }
        }
        return -1;
    }

    // print array binary tree level by level
    public void printTree() {
        System.out.println("Binary Tree in level by level order. Root is: " + tree[1]);
        for (int j = 1; j <= i; j++) {
            if (tree[j] != 0) { // 0 in the array represents blank space or no value
                System.out.print(tree[j] + " ");
            }
        }
        System.out.println("\n");
    }

    // using the printFamily method construct the updated tree
    public void printFamily() {
        System.out.println("Construct updated tree based on the below details.....");
        for (int j = i; j > 1; j--) {
            if (tree[j] != 0) {
                System.out.println("\nParent of " + tree[j] + " is:" + tree[j / 2]);
                if (2 * j <= i && tree[2 * j] != 0) {
                    System.out.println("\tleft Child of " + tree[j] + " is: " + tree[2 * j]);
                }
                if (2 * j + 1 <= i && tree[2 * j + 1] != 0) {
                    System.out.println("\tRight Child of " + tree[j] + " is: " + tree[2 * j + 1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int ch;
        String status = "c";
        OperationsOnBTreeUsingArray operationsonbtreeusingarray = new OperationsOnBTreeUsingArray();
        do {
            System.out.println("0. Exit\n1. Insert\n2. Deletion\n3. Print Binary Tree\nEnetr your choice");
            ch = sc.nextInt();
            switch (ch) {
                case 0:
                    // when 0 is entered, stop execution of the program by breaking while loop
                    status = "s";
                    break;
                case 1:
                    // insertion when tree is not empty
                    if (tree[1] != 0) {
                        operationsonbtreeusingarray.insertNewValues();
                    } else {
                        // insertion when tree is empty
                        operationsonbtreeusingarray.insertValue();
                    }
                    break;
                case 2:
                    // deletion when tree is not empty
                    if (tree[1] != 0) {
                        operationsonbtreeusingarray.deleteValue();
                        // operationsonbtreeusingarray.deleteValue();
                    } else {
                        System.out.println("Tree is empty!!!");
                    }
                    break;
                case 3:
                    // print the array binary tree
                    if (tree[1] != 0) {
                        operationsonbtreeusingarray.printTree();
                        operationsonbtreeusingarray.printFamily();
                    } else {
                        System.out.println("Tree is empty!!!");
                    }
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (status != "s");
        System.out.println("Program completed successfully!!!");
    }
}