package com.ds_algorithms;

import java.util.Scanner;

public class BSTDeletion {
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

    static void deleteNode(Node root, int key) {
        root = deleteRecursive(root, key);
    }

    static Node deleteRecursive(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)  // traverse left subtree
            root.left = deleteRecursive(root.left, key);
        else if (key > root.key) // traverse right subtree
            root.right = deleteRecursive(root.right, key);
        else {
            //node contains only one or no child nodes
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            //node contains two children find inOrder successor. i.e., min value in right subtree
            root.key = minValue(root.right);
            //Delete the inOrder successor
            root.right = deleteRecursive(root.right, key);
        }
        return root;
    }

    static int minValue(Node root) {
        int minVal = root.key;  //initially minVal = root
        //find minVal
        while (root.left != null) {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
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
        int value;
        boolean status;

        Node root = null;
        int[] arr = {34, 1, 89, 22, 19, 38};
        for (int i = 0; i < arr.length; i++) {
            value = arr[i];
            if (root == null)
                root = insert(root, value);
            else
                insert(root, value);
        }
        System.out.println("Inorder of Binary Tree!!\n");
        inOrder(root);

        int stop = -1;
        while (stop != 0) {
            System.out.println("\nEnter value to delete.");
            int val = sc.nextInt();
            status = search(root, val);
            if (status == true) {
                deleteNode(root, val);
                System.out.println("\nInOrder of Binary Tree!!\n");
                inOrder(root);
                System.out.println("\nValue found and deleted successfully!!!\nEnter 0 to stop or Enter any value to continue delete");
                if (sc.nextInt() == 0)
                    stop = 0;
            } else {
                System.out.println("\nValue not found!!!" + "\nEnter 0 to stop or Enter any value to continue delete");
                if (sc.nextInt() == 0)
                    stop = 0;
            }
        }
        System.out.println("Program completed successfully!!");
        sc.close();
    }

}
