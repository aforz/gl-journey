package com.pre_work;

public class FibonacciSeries {
    public static void main(String[] args) {
        int first = 0;
        int second = 1;
        int SERIES_COUNT = 10;
        System.out.print(first + ", " + second + ", ");
        for (int i = 3; i <= SERIES_COUNT; i++) {
            int sumOfPreNums = first + second;
            if (i == SERIES_COUNT)
                System.out.print(sumOfPreNums);
            else
                System.out.print(sumOfPreNums + ", ");
            first = second;
            second = sumOfPreNums;
        }
    }
}
