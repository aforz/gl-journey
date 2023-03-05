package com.general;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipOfSpecificPatternPdf {
    public static void main(String[] args) {
        File dir = new File("D:\\Files\\basedir");
        String pattern = "file";
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(pattern);
            }
        });
        List<String> pdfFileNames = new ArrayList();
        for (File file : files) {
            pdfFileNames.add(file.getAbsolutePath());
        }

        String zipPath = "D:\\Files\\zipfile\\file_compress.zip";

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (String filePath : pdfFileNames) {
                File fileToZip = new File(filePath);
                zipOut.putNextEntry(new ZipEntry(fileToZip.getName()));
                Files.copy(fileToZip.toPath(), zipOut);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String eachFile : pdfFileNames){
            new File(eachFile).delete();
        }

    }
}
