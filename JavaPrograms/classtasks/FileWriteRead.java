package classtasks;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class FileWriteRead {
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
            Writer wr = new FileWriter(file);
            wr.
            String str = "Writing this line in the file.";
            wr.write(str);
            wr.append(" d");
            wr.close();
        } catch (Exception e) {
            e.getMessage();
        }

        System.out.println("Done!");
        System.out.println("Starting to read: ");

        try {
            Reader rd = new FileReader(file);
            if (rd.ready()) {
                int i;
                while ((i = rd.read()) != -1) {
                    System.out.print( (char)i );
                }

                System.out.println();
            }
            rd.close();
        } catch (Exception e) {
            e.getMessage();
        }

        System.out.println("Done!");

    }
}