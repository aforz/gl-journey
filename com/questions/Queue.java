package com.questions;

public class Queue {
    int front, rear;
    int capacity, size;
    int[] arr;

    public Queue(int noOfProcess) {
        capacity = noOfProcess;
        arr = new int[capacity];
        front = -1;
        rear = -1;

    }

    public void enqueue(int ele) {
        if (rear == -1)
            front = 0;
        rear++;
        arr[rear] = ele;
        size++;

    }

    public int dequeue() {
        int ele = arr[front];
        size--;
        front++;
        return ele;

    }


    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public void display() {

        for (int i = front; i <= rear; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}


