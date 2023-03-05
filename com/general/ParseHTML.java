package com.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParseHTML {
    public static void main(String[] args) {
        try {
            String parseLine;

            URL url = new URL("http://www.example.com/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder sb = new StringBuilder();
            while ((parseLine = br.readLine()) != null) {
                sb = sb.append(parseLine);
                //System.out.println(parseLine);

            }
            Path path = Paths.get("C:\\Users\\Afroz Alam\\OneDrive\\Desktop\\htmlToPDF\\htmlFile1.html");
            try {
                Files.writeString(path, sb, StandardCharsets.UTF_8);
            } catch (Exception ex) {
                System.out.println("Invalid Path");
            }
            br.close();

        } catch (MalformedURLException me) {
            System.out.println(me);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }//class end
}
