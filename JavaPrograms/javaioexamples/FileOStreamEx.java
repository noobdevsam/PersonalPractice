package javaioexamples;

import java.io.FileOutputStream;

public class FileOStreamEx {
    public static void main(String[] args) {
        try {
            FileOutputStream fout = new FileOutputStream("JavaPrograms/files/testout.txt");
            fout.write(65);// writes A in the file
            fout.close();

            System.out.println("Success...");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            FileOutputStream fout = new FileOutputStream("JavaPrograms/files/testout.txt");
            String s = "welcome to java";
            byte b[] = s.getBytes();
            fout.write(b);// replaces first line
            fout.close();

            System.out.println("2nd succes...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
