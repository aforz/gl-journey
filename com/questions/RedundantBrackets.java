package com.questions;

import java.util.Stack;

public class RedundantBrackets {
    // Function to check redundant brackets in a balanced expression
    static boolean checkRedundancy(String string) {

        Stack<Character> stack = new Stack<>();
        char[] str = string.toCharArray();

        for (int i = 0; i < str.length; i++) {
            char ch = str[i];

            if (ch == ')') {
                char top = stack.peek(); //peek will display the topmost element in the stack
                stack.pop();
                boolean flag = true;
                while (top != '(') {
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        flag = false;
                    }
                    top = stack.peek();
                    stack.pop();
                }
                if (flag == true) {
                    return true;
                }
            } else {
                stack.push(ch);
            }
        }
        return false;
    }

    // Function to check redundant brackets
    static void findRedundant(String str) {
        boolean ans = checkRedundancy(str);
        if (ans == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // Driver code
    public static void main(String[] args) {
        String str = "(x+y)";
        findRedundant(str);

        str = "(x+(y)/z)";
        findRedundant(str);

        str = "(z(+x(*y)))"
                + "";
        findRedundant(str);
    }
}
