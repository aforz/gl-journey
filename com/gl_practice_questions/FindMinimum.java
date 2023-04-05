/*
Problem
Implement getMin() method which is responsible for returning the minimum element present in the stack.

Input Format
Size of array
Size of queries
List of queries

Output Format
Return min when getMin() is called
Overflow/Underflow as required

Example 1
Input:
10
5
push 4
push 2
pop
push 8
min

Output:
4
 */
package com.gl_practice_questions;

import java.util.Scanner;

class Stacks {
    int[] arr;
    int top;
    int min;

    Stacks(int size) {
        arr = new int[size];
        top = -1;
        min = 0;
    }

    void push(int ele) {
        if (top == arr.length - 1) {
            System.out.println("Overflow");
            return;
        }
        top++;
        arr[top] = ele;
        setMin();
    }

    int pop() {
        if (top == -1) {
            System.out.print("Underflow ");
            min = 0;
            return -1;
        }
        if (top == 0) {
            min = 0;
            return arr[top];
        }
        int temp = arr[top];
        top--;
        if (min == temp) {
            setMin();
        }
        return temp;
    }

    int setMin() {
        if (top == 0) {
            min = arr[0];
            return min;
        }
        for (int i = 0; i < top; i++) {
            if (arr[i] < arr[i + 1] && min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}

public class FindMinimum {
    public static void main(String[] args) {// TODOAuto-generated method stub
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no of values");
        int size = in.nextInt();
        System.out.println("Enter no of operations ");
        int queries = in.nextInt();
        int i = 0;
        Stacks stack = new Stacks(size);
        while (i++ < queries) {
            System.out.println("Type push or pop or min");
            switch (in.next()) {
                case "push":
                    System.out.println("Enter any value other than 0");
                    stack.push(in.nextInt());
                    break;
                case "pop":
                    System.out.println("popped value is " + stack.pop());
                    break;
                case "min":
                    System.out.println(stack.min);
            }
            System.out.println("Min is " + stack.min);
        }
    }
}
