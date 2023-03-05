package com.general;

import java.io.File;
import java.io.FilenameFilter;

public class ListingFiles {
    public static void main(String[] args) {
        File dir = new File("D:\\Files\\zipfile");
        File [] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("file");
            }
        });

        for (File xmlfile : files) {
            System.out.println(xmlfile);
        }
    }
}
