package com.questions;

class Node {

    public int nodeData;
    public Node nextNode;

}

public class LinkedListMiddle {
    private Node head;

    public void insertAtFront(int data) {
        Node newNode = new Node();
        newNode.nodeData = data;
        newNode.nextNode = head;
        head = newNode;
    }

    void printMiddle() {
        Node firstPointer = head;
        Node secondPointer = head;

        while (firstPointer != null && firstPointer.nextNode != null) {
            firstPointer = firstPointer.nextNode.nextNode;
            secondPointer = secondPointer.nextNode;
        }
        System.out.println("The middle element is [" +
                secondPointer.nodeData + "] \n");
    }

    public void displayLinkedList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.nodeData + " -> ");
            currentNode = currentNode.nextNode;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {

        LinkedListMiddle linkedList = new LinkedListMiddle();
        linkedList.insertAtFront(10);
        linkedList.insertAtFront(20);
        linkedList.insertAtFront(30);
        linkedList.insertAtFront(40);
        linkedList.insertAtFront(50);
        linkedList.insertAtFront(60);
        linkedList.insertAtFront(70);
        linkedList.insertAtFront(80);
        linkedList.insertAtFront(90);
        linkedList.displayLinkedList();
        linkedList.printMiddle();
    }
}


