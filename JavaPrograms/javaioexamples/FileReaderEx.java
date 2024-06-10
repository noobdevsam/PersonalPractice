package javaioexamples;

import java.io.FileReader;

public class FileReaderEx {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("files/testout4.txt");
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char)data);
            }
            fr.close();
            System.out.println("\nDone");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
