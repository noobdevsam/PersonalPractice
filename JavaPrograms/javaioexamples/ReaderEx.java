package javaioexamples;

import java.io.FileReader;
import java.io.Reader;

public class ReaderEx {
    public static void main(String[] args) {
        try {
            Reader r = new FileReader("files/testout3.txt");
            int data = r.read();

            while (data != -1) {
                System.out.print((char) data);
                data = r.read();
            }
            System.out.println("\nDone");
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
