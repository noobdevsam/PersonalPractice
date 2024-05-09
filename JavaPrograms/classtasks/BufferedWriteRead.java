package classtasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedWriteRead {
    public static void main(String[] args) {

        File file = new File("./Output.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("New file created.");
            } else {
                System.out.println("Selecting existing file.");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        
        System.out.println("Starting to write: ");

        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(file));
            String str = "Writing this line in the file.";
            bfw.write(str);
            bfw.append(" d");
            bfw.newLine();// creating new line in the file
            bfw.write("This is Second line");
            bfw.close();
        } catch (Exception e) {
            e.getMessage();
        }

        System.out.println("Done!");
        System.out.println("Starting to read: ");

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(file));
            if (bfr.ready()) {
                System.out.println("First line: " + bfr.readLine());
                System.out.println("Second line: " + bfr.readLine());
            }
            bfr.close();
        } catch (Exception e) {
            e.getMessage();
        }

        System.out.println("Done!");

    }
}