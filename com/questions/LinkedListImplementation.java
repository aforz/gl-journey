package com.questions;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListImplementation {

    public static void main(String args[]) {
        // Creating object of the
        // class linked list
        LinkedList<String> linkedList = new LinkedList<String>();

        // Adding elements to the linked list
        linkedList.add("Z");
        linkedList.add("B");
        linkedList.add("Y");
        linkedList.addLast("H");
        linkedList.addFirst("D");
        linkedList.add(2, "X");
        System.out.println(linkedList);
        Collections.sort(linkedList);
        System.out.println(linkedList);

        linkedList.remove("B");
        linkedList.remove(3);
        linkedList.removeFirst();
        linkedList.removeLast();


        Collections.sort(linkedList);
        System.out.println(linkedList);
        Collections.sort(linkedList, Collections.reverseOrder());
        System.out.println(linkedList);


        LinkedList<Integer> linkedListInt = new LinkedList<Integer>();
        linkedListInt.add(8);
        linkedListInt.add(2);
        linkedListInt.addLast(3);
        linkedListInt.addFirst(4);
        linkedListInt.add(2, 5);
        Collections.sort(linkedListInt);
        System.out.println(linkedListInt);


        linkedListInt.removeFirst();
        linkedListInt.removeLast();

        Collections.sort(linkedListInt);
        System.out.println(linkedListInt);
        Collections.sort(linkedListInt, Collections.reverseOrder());
        System.out.println(linkedListInt);
    }
}
