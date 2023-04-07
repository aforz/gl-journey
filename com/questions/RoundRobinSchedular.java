package com.questions;

public class RoundRobinSchedular {
    static void schedular(int[] burstTime, int noOfProcess, int quantum) {
        Queue queue = new Queue(20);
        for (int i = 0; i < noOfProcess; i++)
            queue.enqueue(burstTime[i]);
        while (!queue.isEmpty()) {
            queue.display();
            int curr = queue.dequeue();
            if (curr > quantum)
                queue.enqueue(curr - quantum);
        }
    }

    public static void main(String[] args) {

//	        int noOfProcess =4;
//	     	int[] burstTime;
//	     	burstTime = new int[]{15,10,18,5};
//	     	int quantum = 5;

        int noOfProcess = 3;
        int[] burstTime;
        burstTime = new int[]{1, 2, 3};
        int quantum = 1;

        schedular(burstTime, noOfProcess, quantum);
    }
}
