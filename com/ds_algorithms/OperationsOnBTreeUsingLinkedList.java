package com.ds_algorithms;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OperationsOnBTreeUsingLinkedList {
    static Node root = null;
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

    static void deleteNode(int key) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
                return;
            } else
                return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null, keyNode = null;
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp.key == key)
                keyNode = temp;     // found the deletion
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
        if (keyNode != null) {
            //temp = findAndDeleteRightmostNode(root);
            int x = temp.key;   // the last node searched in the above loop is--
            delete(root, temp); // delete the deepest rightmost node which is the rightmost node in last of the tree
            keyNode.key = x;    // replace found node key value with deleted va--
        }
    }

    static void delete(Node root, Node delNode) {
        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(root);
        Node tempNode = null;
        while (!q1.isEmpty()) {
            tempNode = q1.peek();
            q1.remove();
            if (tempNode == delNode) {
                tempNode = null;
                return;
            }
            if (tempNode.right != null) {
                if (tempNode.right == delNode) {
                    tempNode.right = null;
                    return;
                } else
                    q1.add(tempNode.right);
            }
            if (tempNode.left != null) {
                if (tempNode.left == delNode) {
                    tempNode.left = null;
                    return;
                } else
                    q1.add(tempNode.left);
            }
        }
    }

    public static void printTree(Node roots) {
        Queue<Node> queue1 = new LinkedList<Node>();
        queue1.add(roots);
        if (roots != null) {
            while (!queue1.isEmpty()) {
                Node tempNode = queue1.poll();
                System.out.print(tempNode.key + " ");
                //enqueue left node
                if (tempNode.left != null) {
                    queue1.add(tempNode.left);
                }
                //enqueue right node
                if (tempNode.right != null) {
                    queue1.add(tempNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int ch;
        String status = "c";
        OperationsOnBTreeUsingLinkedList bt = new OperationsOnBTreeUsingLinkedList();
        do {
            System.out.println("\n0. Exit\n1.Insert\n2.Deletion\n3.Print Binary Tree\nEnter your choice");
            ch = sc.nextInt();
            switch (ch) {
                case 0:
                    status = "s";
                    break;
                case 1:
                    System.out.println("Enter value to insert:");
                    value = sc.nextInt();
                    root = bt.insertNode(root, value);
                    System.out.println("Binary tree after insertion");
                    printTree(root);
                    break;
                case 2:
                    System.out.println("Enter value to deletion");
                    deleteNode(sc.nextInt());
                    printTree(root);
                    break;
                case 3:
                    printTree(root);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (status != "s");
        System.out.println("Program completed successfully!!!");
    }
}
