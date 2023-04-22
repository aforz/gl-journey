/*
Write a program to implement Level Order Traversal in BTree.
 */
package com.gl_practice_questions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderBTree {
    static int value;
    static Scanner sc = new Scanner(System.in);
    Deque<Node> queue = new LinkedList<Node>();// Represent a node of binary tree

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

    Node insertNode(Node root, int key) {// Create a new node
        Node newNode = newNode(key);
        if (root == null) {
            root = newNode;
            queue.add(root);
            return root;
        } else {
            Node node;
            node = queue.remove();
            System.out.println("parent is: " + node.key);
            if (node.left == null) {
                node.left = newNode;
                queue.add(node.left);
                queue.addFirst(node);
                return root;
            } else if (node.right == null) {
                node.right = newNode;
                queue.add(node.right);
                return root;
            }
        }
        return root;
    }

    public void levelOrder(Node root) {
        Queue<Node> queue1 = new LinkedList<Node>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            Node tempNode = queue1.poll();
            System.out.print(tempNode.key + " ");
            // enqueue left node
            if (tempNode.left != null) {
                queue1.add(tempNode.left);
            }// enqueue right node
            if (tempNode.right != null) {
                queue1.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderBTree levelOrder = new LevelOrderBTree();
        Node root = null;
        String status = "a";
        while (!status.equals("s")) {
            System.out.println("Enter value to insert:");
            value = sc.nextInt();
            root = levelOrder.insertNode(root, value);
            System.out.println("Binary Tree using level order Traversal");
            levelOrder.levelOrder(root);
            System.out.println("\nEnter s to stop or any char to continue insertion");
            status = sc.next();
        }
        System.out.println("Program Completed successfully!!!");
    }
}
