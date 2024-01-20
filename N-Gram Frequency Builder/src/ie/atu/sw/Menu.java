package ie.atu.sw;

import java.io.*;
import java.util.*;

public class Menu {
	
	private Parser parser;
    private Ngram nGram;

    private boolean keepRunning = true;
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
        parser = new Parser();
        nGram = Ngram.getInstance();  // Use getInstance() for instantiation

    }

    public void startApp() {
        boolean directorySet = false;
        boolean nGramSizeSet = false;
        boolean outputFileSet = false;

        while (keepRunning) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    setDirectory(directorySet);
                    directorySet = true;
                    break;
                case 2:
                    setNGramSize(nGramSizeSet);
                    nGramSizeSet = true;
                    break;
                case 3:
                    setOutputFile(outputFileSet);
                    outputFileSet = true;
                    break;
                case 4:
                    buildNGrams(directorySet, nGramSizeSet, outputFileSet);
                    break;
                case 5:
                    shutdown();
                    break;
                default:
                    invalidChoice();
                    break;
            }
        }
    }

    private int getUserChoice() {
        System.out.print("Select Option [1 - 5]> ");
        return scanner.nextInt();
    }

    private void setDirectory(boolean directorySet) {
        if (!directorySet) {
            System.out.println("Enter the directory: ");
            String directoryName = scanner.next();
            scanner.nextLine();  // Consume the newline character
            System.out.println("DEBUG: Directory entered: " + directoryName); // Add this line for debugging

            parser.setDirectory(directoryName);
            System.out.println("[INFO] Directory has been set.");
            System.out.println();
        } else {
            System.out.println("[INFO] Directory has already been set.");
            System.out.println();
        }
    }

    private void setNGramSize(boolean nGramSizeSet) {
        if (!nGramSizeSet) {
            System.out.println("Please enter an N-Gram size in the range [1 - 5]> ");
            int nGramSize = scanner.nextInt();
            nGram.setNGramSize(nGramSize);
            System.out.println("[INFO] N-Gram size has been set.");
            System.out.println();
        } else {
            System.out.println("[INFO] N-Gram size has already been set.");
            System.out.println();
        }
    }

    private void setOutputFile(boolean outputFileSet) {
        if (!outputFileSet) {
            try {
                System.out.println("Enter output file name (.csv only) -->");
                String userFile = scanner.next();
                if (nGram.isCsvFile(userFile)) {
                    nGram.setOutputFileName(userFile);
                } else {
                    System.out.println("ERROR: File name must have .csv extension");
                    setOutputFile(outputFileSet);
                }
            } catch (Exception e) {
                System.out.println("ERROR: .csv only");
                setOutputFile(outputFileSet);
            }

            System.out.println("[INFO] The file will be saved to " + nGram.getOutputFileName()
                    + "\n[INFO] Select the next option from the main menu to continue.");
        } else {
            System.out.println("[INFO] Output file has already been set.");
            System.out.println();
        }
    }

    private void buildNGrams(boolean directorySet, boolean nGramSizeSet, boolean outputFileSet) {
        if (directorySet && nGramSizeSet && outputFileSet) {
            System.out.println("Building N-Grams, please wait .....");
            parser.readDirectory();
            nGram.saveTableToFile();
        } else {
            System.out.println("[INFO] Please set directory, N-Gram size, and output file first.");
            System.out.println();
        }
    }

    private void shutdown() {
        System.out.println("Info: Shutting down... please wait..");
        keepRunning = false;
    }

    private void invalidChoice() {
        System.out.println("[ERROR] Invalid Option: Please select from the options provided.");
        System.out.println();
    }

    private void showMenu() {
        System.out.println("************************************************************");
        System.out.println("*      ATU - Dept. Computer Science & Applied Physics      *");
        System.out.println("*                                                          *");
        System.out.println("*                  N-Gram Frequency Builder                *");
        System.out.println("*                                                          *");
        System.out.println("************************************************************");
        System.out.println("(1) Specify Text File Directory");
        System.out.println("(2) Specify N-Gram Size");
        System.out.println("(3) Specify Output File");
        System.out.println("(4) Build N-Grams ");
        System.out.println("(5) Quit");
        System.out.println();
    }
}


