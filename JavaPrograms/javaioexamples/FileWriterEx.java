package javaioexamples;

import java.io.FileWriter;

public class FileWriterEx {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("files/testout4.txt");
            fw.write("Hello there");
            fw.close();
            System.out.println("\nDone");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
