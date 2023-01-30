package com.pre_work;

import java.util.Scanner;

public class PyramidPattern {
    public static void main(String[] args) {
        System.out.print("Please enter number of line: ");
        int num = new Scanner(System.in).nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = num - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            for (int l = 1; l < i; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
