package com.ds_algorithms;

public class HeightOfTree {
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

    static int heightOfTree(Node node) {
        if (node == null)
            return 0;
        else {
            //compute the depth of each subtree
            int leftHeight = heightOfTree(node.left);
            int rightHeight = heightOfTree(node.right);
            // use the larger one
            if (leftHeight > rightHeight)
                return (leftHeight + 1);
            else
                return (rightHeight + 1);
        }
    }

    public static void main(String[] args) {
        int value;
        Node root = null;
        int[] arr = {67, 55, 76, 89, -21, 12, -20, 38, 75};
        for (int i = 0; i < arr.length; i++) {
            value = arr[i];
            if (root == null)
                root = insert(root, value);
            else
                insert(root, value);
        }
        System.out.println("InOrder of Binary Tree\n");
        inOrder(root);
        System.out.println("\nHeight of tree is: " + heightOfTree(root));
    }
}
