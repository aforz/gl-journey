/*
Implement Queue using array.
 */
package com.gl_practice_questions;

public class Queue {
    private int maxSize;
    int front;
    int rear;
    int arr[];

    public Queue(int sizeOfQueue) {
        this.maxSize = sizeOfQueue;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        if (rear == maxSize - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    public void enqueue(int data) {
        if (!isFull()) {
            rear++;
            arr[rear] = data;
            if (front == -1) front = 0;
        } else {
            System.out.println("Queue overflow");
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("queue underflow");
        } else {
            System.out.println(arr[front] + "deleted");
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else front++;
    }

    public static void main(String a[]) {
        Queue queue = new Queue(2);
        queue.enqueue(43);
        queue.enqueue(32);
        queue.dequeue();
        queue.dequeue();
    }
}
