package com.ds_algorithms;

import java.util.Scanner;

public class LeftSkewedTree {
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
        Node y = null;
        while (x != null) {
            y = x;
            if (key < x.key)
                x = x.left;
            else if (key > x.key)
                x = x.right;
            else {
                System.out.println("Value already exist");
                return newNode;
            }
        }
        if (y == null)
            y = newNode;
        else if (key < y.key)
            y.left = newNode;
        else
            y.right = newNode;
        return y;
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

    static void leftNodes(Node root) {
        if (root == null)
            return;
        else {
            System.out.print(root.key + " ");
            leftNodes(root.left);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value;
        Node root = null;
        Node result = null;
        int[] arr = {67, 55, 76, 89, -21, 12, -20, 38, 75};
        for (int i = 0; i < arr.length; i++) {
            value = arr[i];
            if (root == null)
                root = insert(root, value);
            else {
                result = insert(root, value);
                if (result.key == value)
                    i -= 1;
            }
            System.out.println("\nInOrder of Binary Tree\n");
            inOrder(root);
        }
        System.out.println("\n\nLeft skewed tree values are: ");
        leftNodes(root);
        sc.close();
    }
}
