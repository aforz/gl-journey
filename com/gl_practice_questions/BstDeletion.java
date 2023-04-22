/*
Write a program to Delete a node in Binary Search Tree
 */
package com.gl_practice_questions;

import java.util.Scanner;

public class BstDeletion {
    // BST node
    static class Node {
        int key;
        Node left, right;
    }

    // creation of new node
    static Node newNode(int data) {
        Node temp = new Node();
        temp.key = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    static Node insert(Node root, int key) {
        Node newnode = newNode(key);
        Node x = root;
        Node current_parent = null;
        while (x != null) {
            current_parent = x;
            if (key < x.key)
                x = x.left;
            else if (key > x.key)
                x = x.right;
            else {
                System.out.println("Value already exists!!!");
                return newnode;
            }
        }
        // If the root is null, the tree is empty.
        if (current_parent == null)
            current_parent = newnode;

            // assign new node node to the left child
        else if (key < current_parent.key)
            current_parent.left = newnode;

            // assign the new node to the right child
        else
            current_parent.right = newnode;
        // return pointer to new node
        return current_parent;
    }

    static Node deleteNode(Node root, int key) {
        return delete_Recursive(root, key);
    }

    // recursive delete function
    static Node delete_Recursive(Node root, int key) {
        // when tree is empty
        if (root == null)
            return root;
        if (key < root.key)
            // traverse left subtree
            root.left = delete_Recursive(root.left, key);
        else if (key > root.key)
            // traverse right subtree
            root.right = delete_Recursive(root.right, key);
        else {
            // node contains only one or no child nodes
            if (root.left == null) return root.right;
            else if (root.right == null)
                return root.left;
            // node contains two children
            // find Inorder successor. i.e., min value in right subtree
            root.key = minValue(root.right);
            // Delete the Inorder successor
            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    static int minValue(Node root) {
        // initially minval = root
        int minval = root.key;
        // find minval
        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    static boolean search(Node root, int key) {
        root = search_Recursive(root, key);
        if (root != null) return true;
        else return false;
    }

    static Node search_Recursive(Node root, int key) {
        // when root is null or key is present at root
        if (root == null || root.key == key)
            return root;
        // when value is greater than root's key
        if (root.key > key)
            return search_Recursive(root.left, key);
        // when value is less than root's key
        return search_Recursive(root.right, key);
    }

    static void Inorder(Node root) {
        if (root == null) return;
        else {
            Inorder(root.left);
            System.out.print(root.key + " ");
            Inorder(root.right);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int value;
        boolean status;
        Node root = null;
        int[] arr = {44, 17, 28, 29, 88, 65, 97, 54, 82, 76, 80, 78};
        for (int i = 0; i < arr.length; i++) {
            value = arr[i];
            if (root == null) {
                root = insert(root, value);
            } else {
                insert(root, value);
            }
        }
        System.out.println("\nInorder of Binary Treee!!. Root is: " + root.key + "\n");
        Inorder(root);
        int stop = -1;
        while (stop != 0) {
            System.out.println("\nEnter value to delete.");
            int val = sc.nextInt();
            status = search(root, val);
            if (status == true) {
                root = deleteNode(root, val);
                System.out.println("\nInorder of Binary Treee!!. Root is: " + root.key + "\n");
                Inorder(root);
                System.out.println("\nValue found and deleted successfully!!!\nEnter 0 to stop or any value to continue");
                if (sc.nextInt() == 0) {
                    stop = 0;
                }
            } else {
                System.out.println("\nValue not found!!!" + "\nEnter 0 to stop or Enter any value to continue");
                if (sc.nextInt() == 0) {
                    stop = 0;
                }
            }
        }
        System.out.println("Programcompleted successfully");
        sc.close();
    }
}
