import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        // specify input file name
        String inputFileName = "input.txt";
        // specify output file name
        String outputFileName = "output.txt";

        // create HashMap to store word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        // read input file and count words
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // convert the word to lowercase
                String word = line.toLowerCase().trim();
                // increment word count in HashMap
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
            return;
        }

        // write word counts to output file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue());
                bw.newLine();
            }
            System.out.println("Word counts written to " + outputFileName);
        } catch (IOException e) {
            System.err.println("Error writing to the output file: " + e.getMessage());
        }
    }
}
