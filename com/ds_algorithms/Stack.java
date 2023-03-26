package com.ds_algorithms;

class StackImplementation {
    int sizeOfStack = 5;
    int[] array = new int[sizeOfStack];
    int currentPointer;

    StackImplementation() {
        currentPointer = -1;
    }

    boolean push(int x) {
        if (currentPointer >= sizeOfStack - 1) {
            System.out.println("Stack is Overflow.");
            return false;
        } else {
            array[++currentPointer] = x;
            System.out.println(x + " <- pushed into stack.");
            return true;
        }
    }

    int pop() {
        if (currentPointer < 0) {
            System.out.println("Stack is Underflow.");
            return 0;
        } else {
            int x = array[currentPointer--];
            return x;
        }
    }

    public void printStack() {
        for (int i = currentPointer; i > -1; i--) {
            System.out.print(array[i] + " ");
        }
    }

}

public class Stack {
    public static void main(String[] args) {
        StackImplementation si = new StackImplementation();
        si.push(10);
        si.push(20);
        si.push(30);
        si.push(40);
        System.out.println(si.pop() + " <- popped from stack");
        System.out.println(si.pop() + " <- popped from stack");
        System.out.println(si.pop() + " <- popped from stack");
        System.out.println(si.pop() + " <- popped from stack");
        System.out.println(si.pop() + " <- popped from stack");
        System.out.println("Elements present in stack.");
        si.printStack();
    }
}
