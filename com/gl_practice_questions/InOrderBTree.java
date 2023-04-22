/*
Write a program to implement InOrder Traversal in BTree.
 */
package com.gl_practice_questions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class InOrderBTree {
    static int value;
    static Scanner sc = new Scanner(System.in);
    Deque<Node> queue = new LinkedList<Node>();

    // Represent a node of binary tree
    static class Node {
        int key;
        Node left;
        Node right;
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.key = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    Node insertNode(Node root, int key) {
        // Create a new node
        Node newnode = newNode(key);
        if (root == null) {
            root = newnode;
            queue.add(root);
            return root;
        } else {
            Node node;
            node = queue.remove();
            System.out.println("parent is: " + node.key);
            if (node.left == null) {
                node.left = newnode;
                queue.add(node.left);
                queue.addFirst(node);
                return root;
            } else if (node.right == null) {
                node.right = newnode;
                queue.add(node.right);
                return root;
            }
        }
        return root;
    }

    public void inOrder(Node root) {
        if (root == null) return;
        else {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    public static void main(String args[]) {
        InOrderBTree inOrderBTree = new InOrderBTree();
        Node root = null;
        String status = "a";
        while (!status.equals("s")) {
            System.out.println("Enter value to insert:");
            value = sc.nextInt();
            root = inOrderBTree.insertNode(root, value);
            System.out.println("Binary Tree using InOrder Traversal");
            inOrderBTree.inOrder(root);
            System.out.println("\nEnter s to stop or any char to continue insertion");
            status = sc.next();
        }
        System.out.println("Program Completed successfully!!!");
    }
}
