/*
Write a program to find the maximum and minimum value in the binary tree using the linked list concept.
 */
package com.gl_practice_questions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PracticeBTreeUsingLinkedList {
    static int value;
    static Scanner sc = new Scanner(System.in);
    Deque<Node> queue = new LinkedList<Node>();

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

    public void maxMinNode(Node root) {
        int max = root.key;
        int min = root.key;
        Queue<Node> queue1 = new LinkedList<Node>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            Node tempNode = queue1.poll();
            if (tempNode.key > max) {
                max = tempNode.key;
            }
            if (tempNode.key < min) {
                min = tempNode.key;
            }
            // enqueue left node
            if (tempNode.left != null) {
                queue1.add(tempNode.left);
            }
            // enqueue right node
            if (tempNode.right != null) {
                queue1.add(tempNode.right);
            }
        }
        System.out.println("Maximum value in the tree is: " + max);
        System.out.println("Minimum value in the tree is: " + min);
    }

    public void leveByLevel(Node root) {
        Queue<Node> queue1 = new LinkedList<Node>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            Node tempNode = queue1.poll();
            System.out.print(tempNode.key + " ");
            // enqueue left node
            if (tempNode.left != null) {
                queue1.add(tempNode.left);
            }
            // enqueue right node
            if (tempNode.right != null) {
                queue1.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        PracticeBTreeUsingLinkedList practicebt = new PracticeBTreeUsingLinkedList();
        Node root = null;
        String status = "a";
        while (!status.equals("s")) {
            System.out.println("Enter value to insert:");
            value = sc.nextInt();
            root = practicebt.insertNode(root, value);
            System.out.println("Binary tree after insertion");
            practicebt.leveByLevel(root);
            System.out.println("\nEnter s to stop or any char to continue insertion");
            status = sc.next();
        }
        practicebt.maxMinNode(root);
        System.out.println("Program Completed successfully!!!");
    }
}
