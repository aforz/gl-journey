/*
Problem
You are provided with a circular linked list. Circular linked list is a special linked list where the tail points back to the head of the list.
Your task is to print the created list.

Input Format
No of Nodes
Elements

Output Format
Print circular linked list

Example
Input:
5
10
20
30
40
50

Output:
10 20 30 40 50
 */
package com.gl_practice_questions;

import java.util.Scanner;

class Node {
    int key;
    Node nextNode;

    Node(int key) {
        this.key = key;
        nextNode = null;
    }
}

class CircularLinkedList {
    Node listHead;
    Node listTail;

    void insert(int key) {
        Node tmp = new Node(key);
        if (listHead == null) listHead = tmp;
        if (listTail == null) listTail = tmp;
        else {
            listTail.nextNode = tmp;
            listTail = tmp;
        }
        listTail.nextNode = listHead;
    }

    void display() {
        if (listHead == null) return;
        Node tmp = listHead;
        System.out.print(tmp.key + " ");
        tmp = tmp.nextNode;
        while (tmp != listHead) {
            System.out.print(tmp.key + " ");
            tmp = tmp.nextNode;
        }
    }
}

class CircularLinkedListDisplay {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner in = new Scanner(System.in);
        System.out.println("enter the no of nodes ");
        int noOfNodes = in.nextInt();
        System.out.println("enter " + noOfNodes + " nodes");
        for (int i = 0; i < noOfNodes; i++) list.insert(in.nextInt());
        System.out.println("-- Circular linked list --");
        list.display();
    }
}
