package ie.atu.sw;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ngram {
	
	private static Ngram instance;
    private Map<String, Long> table; // Use a map for dynamic storage of n-grams and frequencies.
    private Logger logger;
    private int nGramSize;
    private String outputFileName;

    private Ngram() {
        table = new HashMap<>();
        logger = Logger.getLogger(Ngram.class.getName());
        nGramSize = 1;
    }

    public static synchronized Ngram getInstance() {
        if (instance == null) {
            instance = new Ngram();
        }
        return instance;
    }

    // Make the constructor public
    public Ngram(int nGramSize) {
        this();
        this.nGramSize = (nGramSize >= 1 && nGramSize <= 5) ? nGramSize : 1;
    }

    public void createNGrams(String[] words) {
        if (nGramSize <= 0) {
            logger.log(Level.SEVERE, "N-Gram size must be greater than 0.");
            throw new IllegalArgumentException("N-Gram size must be greater than 0.");
        }

        for (String word : words) {
            for (int i = 0; i <= word.length() - nGramSize; i++) {
                String nGram = word.substring(i, i + nGramSize);
                try {
                    addNGram(nGram);
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Error adding n-gram: " + nGram, e);
                }
            }
        }
    }

    private void addNGram(String nGram) {
        int index = nGram.hashCode();

        long counter = table.getOrDefault(nGram, 0L) + 1;
        table.put(nGram, counter);

        System.out.println(nGram);
    }

    public void setNGramSize(int nGramSize) {
        this.nGramSize = (nGramSize >= 1 && nGramSize <= 5) ? nGramSize : 1;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String userFile) {
        this.outputFileName = userFile;
    }

    public void saveTableToFile() {
        try (PrintWriter writer = new PrintWriter(new File(outputFileName))) {
        	 // Sort the entries alphabetically using TreeMap
            Map<String, Long> sortedTable = new TreeMap<>(table);
            
            for (Map.Entry<String, Long> entry : sortedTable.entrySet()) {
                writer.write(entry.getValue() + " " + entry.getKey() + "\n");
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error saving table to file: " + outputFileName, e);
        }
    }

    public boolean isCsvFile(String input) {
        return input.endsWith(".csv");
    }

}
