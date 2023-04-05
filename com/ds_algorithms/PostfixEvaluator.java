package com.ds_algorithms;

import java.util.Stack;

public class PostfixEvaluator {

    static int evaluate(String postfix) {
        Stack<Integer> oprStack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if (Character.isLetterOrDigit(ch))
                oprStack.push(ch - '0');
            else {
                int op1 = oprStack.pop();
                int op2 = oprStack.pop();
                switch (ch) {
                    case '+':
                        oprStack.push(op2 + op1);
                        break;
                    case '-':
                        oprStack.push(op2 - op1);
                        break;
                    case '*':
                        oprStack.push(op2 * op1);
                        break;
                    case '/':
                        oprStack.push(op2 / op1);
                        break;
                    case '^':
                        oprStack.push((int) (Math.pow(op2, op1)));
                        break;
                }
            }
        }
        return oprStack.pop();
    }

    public static void main(String[] args) {
        String postfix = "1230^5-*+";
        int ans = evaluate(postfix);
        System.out.println(ans);
    }
}
