package com.general;


import java.io.File;
import java.util.Objects;

public class CleanDirectory {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\Afroz Alam\\OneDrive\\Desktop\\htmlToPDF");

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }
}
