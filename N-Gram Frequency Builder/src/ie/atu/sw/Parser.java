package ie.atu.sw;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {

	 private String directoryPath;
	    private static final String WORD_REGEX = "[^a-zA-Z]";

	    public Parser() {
	    }

	    public void readDirectory() {
	    	System.out.println("DEBUG: Attempting to read directory: " + directoryPath);

	        try {
	        	File directory = new File(directoryPath.replaceAll("\"", ""));

	            if (!directory.exists()) {
	                throw new IllegalArgumentException("Directory does not exist");
	            }

	            if (!directory.isDirectory()) {
	                throw new IllegalArgumentException("Path does not represent a directory");
	            }

	            File[] files = directory.listFiles();

	            for (File file : files) {
	                try {
	                    parseFile(file);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        } catch (IllegalArgumentException e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	    }


	    private void parseFile(File file) throws IOException {
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] words = line.split("\\s+");
	                for (int i = 0; i < words.length; i++) {
	                    words[i] = words[i].replaceAll(WORD_REGEX, "").toLowerCase();
	                    try {
	                        Ngram.getInstance().createNGrams(words);
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading file: " + e.getMessage());
	            throw e;
	        }
	    }

	    public void setDirectory(String directoryPath) {
	        this.directoryPath = directoryPath;
	    }
	}

