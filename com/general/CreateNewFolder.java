package com.general;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateNewFolder {
    public static void main(String[] args) {
        String baseDir = "D:\\Files\\basedir\\";
        String pdf = "pdf";
        File directoryWithPdf = new File(baseDir+ File.separator + "pdf");
        try {
            if (!directoryWithPdf.exists()) {
                directoryWithPdf.mkdir();
            }
            String dateTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
            File dateTimedir = new File(directoryWithPdf +File.separator+ dateTime);
            if (!dateTimedir.exists()) {
                dateTimedir.mkdir();
            }
            System.out.println("uuuu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
