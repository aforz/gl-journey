package com.ds_algorithms;

import java.util.Stack;

public class PostfixToInfixConvertor {

    static String postfixToInfix(String postfix) {
        Stack<String> oprStack = new Stack<>();
        int i = 0;
        while (i < postfix.length()) {
            char ch = postfix.charAt(i);
            if (Character.isLetterOrDigit(ch))
                oprStack.push("" + ch);
            else {
                String op2 = oprStack.pop();
                String op1 = oprStack.pop();
                oprStack.push("(" + op1 + "" + ch + "" + op2 + ")");
            }
            i++;
        }
        return oprStack.pop();
    }

    public static void main(String[] args) {
        String postfix = "xyzp^q-*+";
        String infix = postfixToInfix(postfix);
        System.out.println(infix);
    }
}
