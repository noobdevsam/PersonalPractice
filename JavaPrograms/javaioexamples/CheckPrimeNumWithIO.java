package javaioexamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckPrimeNumWithIO {
    public static void main(String[] args) {

        // input file contents
        /*
          17
          23
          36
          50
          abc
          73
          19
          101
          42
          98
          NotANumber
          89
         
         */

        List<Integer> numbers = readNumFromFile("files/testinput2.txt");
        List<Integer> primeNums = new ArrayList<>();

        for (int num : numbers) {
            if (isPrime(num)) {
                primeNums.add(num);
            }
        }

        writeNumToFile(primeNums, "files/testoutput2.txt");
    }

    private static void writeNumToFile(List<Integer> primeNums, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int num : primeNums) {
                bw.write(String.valueOf(num));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing the file: " + e.getMessage());
        }
    }

    private static boolean isPrime(int num) {
        if (num < 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> readNumFromFile(String filename) {
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return numbers;
    }
}
