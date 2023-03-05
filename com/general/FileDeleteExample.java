package com.general;

import java.io.File;

public class FileDeleteExample {
    public static void main(String[] args) {
        try {
            File f = new File("C:\\Users\\Afroz Alam\\OneDrive\\Desktop\\htmlToPDF\\sample.html");
            if (f.delete())                      //returns Boolean value
            {
                System.out.println(f.getName() + " deleted");   //getting and printing the file name
            } else {
                System.out.println("failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
