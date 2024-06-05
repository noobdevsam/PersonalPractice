package javaioexamples;

import java.io.FileInputStream;

public class FileInStreamEx {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("JavaPrograms/files/testout.txt");

            int i = fin.read(); // reads single byte
            System.out.println((char) i);
            fin.close();
            System.out.println("Task complete...");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            FileInputStream fin = new FileInputStream("JavaPrograms/files/testout.txt");

            System.out.println("Full text: ");
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }

            fin.close();
            System.out.println("\nTask complete...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
