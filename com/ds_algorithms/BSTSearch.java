package com.ds_algorithms;

import java.util.Scanner;

public class BSTSearch {
    static class Node {
        int key;
        Node left, right;
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.key = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    static Node insert(Node root, int key) {
        Node newNode = newNode(key);
        Node x = root;
        Node currentParent = null;

        while (x != null) {
            currentParent = x;
            if (key < x.key)
                x = x.left;
            else if (key > x.key)
                x = x.right;
            else {
                System.out.println("Value already exist!!!");
                return newNode;
            }
        }
        if (currentParent == null)
            currentParent = newNode;
        else if (key < currentParent.key)
            currentParent.left = newNode;
        else
            currentParent.right = newNode;
        return currentParent;
    }

    static void inOrder(Node root) {
        if (root == null)
            return;
        else {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    static boolean search(Node root, int key) {
        root = searchRecursive(root, key);
        if (root != null)
            return true;
        else
            return false;
    }

    static Node searchRecursive(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        if (root.key > key)
            return searchRecursive(root.left, key);
        return searchRecursive(root.right, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value;
        boolean status;

        Node root = null;
        int[] arr = {34, 1, 89, 22, 19, 38};
        for (int i = 0; i < arr.length; i++) {
            value = arr[i];
            if (root == null) {
                root = insert(root, value);
            } else {
                insert(root, value);
            }
        }
        System.out.println("Inorder of Binary Tree!!\n");
        inOrder(root);

        int stop = -1;
        while (stop != 0) {
            System.out.println("\nEnter value to search.");
            int val = sc.nextInt();
            status = search(root, val);
            if (status == true) {
                System.out.println("\nValue found in tree!!!\nEnter 0 to stop or Enter any value to continue search");
                if (sc.nextInt() == 0) {
                    stop = 0;
                }
            } else {
                System.out.println("\nValue not found!!!\nEnter 0 to stop or Enter any value to continue search");
                if (sc.nextInt() == 0) {
                    stop = 0;
                }
            }
        }
        System.out.println("Program completed successfully!!");
        sc.close();
    }
}
