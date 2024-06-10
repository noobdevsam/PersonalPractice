package javaioexamples;

import java.io.BufferedReader;
import java.io.FileReader;

public class BfFileReaderEx {
    public static void main(String[] args) {
        FileReader fr;
        BufferedReader bfr;
        try {
            fr = new FileReader("files/testout5.txt");
            bfr = new BufferedReader(fr);

            int data;

            while ((data = bfr.read()) != -1) {
                System.out.print((char)data);
            }
            System.out.println("\nDone");

            bfr.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
