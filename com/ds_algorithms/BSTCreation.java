package com.ds_algorithms;

import java.util.Scanner;

public class BSTCreation {
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
        Node y = null;  //y maintains pointer to x
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
        // If the root is null, the tree is empty.
        if (y == null)
            y = newNode;
            // assign new node to the left child
        else if (key < y.key)
            y.left = newNode;
            // assign the new node to the right child
        else
            y.right = newNode;
        // return pointer to new node
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value, num;

        System.out.println("Enter no of values: ");
        num = sc.nextInt();

        Node root = null;
        Node result = null;

        for (int i = 1; i < num; i++) {
            System.out.println("\nInsert value at " + i + " :");
            value = sc.nextInt();
            if (root == null)
                root = insert(root, value);
            else {
                result = insert(root, value);
                if (result.key == value)
                    i -= 1;
            }
            System.out.println("Inorder of Binary Tree");
            inOrder(root);
        }
        sc.close();
    }

}
