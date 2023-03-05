package com.general;

// Java Program to Save a String to a File
// Using Files.writeString() method

// Importing required classes

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Main class
public class SaveAStringToFile {

    // Main driver method
    public static void main(String[] args) {
        // Creating an instance of file
        Path path = Paths.get("C:\\Users\\Afroz Alam\\OneDrive\\Desktop\\htmlToPDF\\htmlFile.html");

        // Custom string as an input
        String str = "Geeks for Geeks \nWelcome to computer science portal \nHello Geek";

        // Try block to check for exceptions
        try {
            // Now calling Files.writeString() method
            // with path , content & standard charsets
            Files.writeString(path, str,
                    StandardCharsets.UTF_8);
        }

        // Catch block to handle the exception
        catch (IOException ex) {
            // Print messqage exception occurred as
            // invalid. directory local path is passed
            System.out.print("Invalid Path");
        }
    }
}
