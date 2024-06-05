package javaioexamples;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BfrOStreamEx {
    public static void main(String[] args) {
        try {
            BufferedOutputStream bfs = new BufferedOutputStream(new FileOutputStream("JavaPrograms/files/textout2.txt"));
            String s = "This is second string";
            byte b[] = s.getBytes();
            bfs.write(b);
            bfs.close();

            System.out.println("Success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
