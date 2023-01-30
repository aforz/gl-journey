package com.pre_work;

import java.util.Scanner;

public class LeftTrianglePattern {
    public static void main(String[] args) {
        System.out.print("Please enter number of line: ");
        int num = new Scanner(System.in).nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
