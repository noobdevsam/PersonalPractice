package javaioexamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPreposionsWithIO {
    public static void main(String[] args) {
        String inputFilePath = "files/testinput1.txt", outputFilePath = "files/testoutput1.txt";
        Set<String> foundPreposions = new HashSet<>();
        List<String> prepositions = Arrays.asList("of","in","for","from","like","under",
        "since","with","without","on","at");

        // input file contents
        /*
         * In a park under a tree, with a book from the library, she sat on a bench. Since morning, she had been reading without interruption. At noon, she took a break for lunch, like always.
         */

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for(String word:words) {
                    if(prepositions.contains(word)) {
                        foundPreposions.add(word);
                    }
                }
            }

            for(String preposion: foundPreposions) {
                writer.write(preposion);
                writer.newLine();
            }

            System.out.println("Preposion have been extracted in: " + outputFilePath);
        } catch (Exception e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }
}
