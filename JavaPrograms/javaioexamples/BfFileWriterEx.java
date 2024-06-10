package javaioexamples;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BfFileWriterEx {
    public static void main(String[] args) {
        FileWriter fw;
        BufferedWriter bfw;
        try {
            fw = new FileWriter("files/testout5.txt");
            bfw = new BufferedWriter(fw);

            bfw.write("This is first line");
            bfw.newLine();
            bfw.write("This is second line");
            bfw.append(" , new addition.");
            bfw.flush();
            
            bfw.close();
            fw.close();
            System.out.println("\nDone");
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
}
