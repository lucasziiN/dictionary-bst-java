import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class DictionaryLookup {
    private DictionaryBST dictionary;

    /**
     * Constructor for the DictionaryLookup class
     * Initializes a new DictionaryBST to store the dictionary entries
     */
    public DictionaryLookup() {
        dictionary = new DictionaryBST(); // Create a new empty dictionary
    }

    /**
     * Main method to run the dictionary lookup program
     * @param args not used
     */
    public static void main(String[] args){
        
        DictionaryLookup lookup = new DictionaryLookup();
        lookup.loadDictionary("CS-Dictionary-small-shuffled.txt"); // Load dictionary from file
        System.out.println("Welcome to the Dictionary Lookup!\n");

        // Try-catch structure to manage BufferedReader 
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            
            boolean running = true; // Control variable for the main loop

            while (running) {
                // Print user options
                System.out.println("Please enter a number to indicate what you would like to do");
                System.out.println("(1) Search for a word/phrase in the dictionary");
                System.out.println("(2) Print a given word/phrase and it's definition");
                System.out.println("(3) Add a word/phrase and definition to the dictionary");
                System.out.println("(4) Remove a word/phrase and definition from the dictionary");
                System.out.println("(5) Print all of the words/phrases and their definitions, in alphabetical order");
                System.out.println("(6) Exit");
                System.out.println("Please enter a number between 1 and 6:");

                int choice = -1;
                try {
                    // Read user choice and convert to integer
                    choice = Integer.parseInt(reader.readLine().trim()); // Parse input to an int
                    System.out.println();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number."); // Handle non-integer inputs
                    continue; // Skip to next iteration of the loop on invalid input
                }
                
                String word = ""; // Variable to store word input
                String definition = ""; // Variable to store definition input

                // Switch statement to handle different user choices
                switch (choice) {
                    // Check if word is in the dictionary
                    case 1:
                        System.out.println("Searching the dictionary ...\n");
                        System.out.println("Please enter a word/phrase to search for");
                        word = reader.readLine().trim();
                        System.out.println("The word/phrase '" +word+"' exists in the dictionary: " + lookup.dictionary.search(word) + "\n");
                        break;
                    // Print word and its definition
                    case 2:
                        System.out.println("Printing dictionary item ...\n");
                        System.out.println("Please enter a word/phrase to print");
                        word = reader.readLine().trim();
                        System.out.println();
                        lookup.dictionary.printDictionaryItem(word);
                        break;
                    // Adding a word and a definition to the dictionary
                    case 3:
                        System.out.println("Adding item to the dictionary ...\n");
                        System.out.println("Please enter a word/phrase");
                        word = reader.readLine().trim();
                        System.out.println("Thank you, now please enter the definition");
                        definition = reader.readLine().trim();
                        System.out.println("Thank you, your item has been added to the dictionary");
                        lookup.dictionary.insert(word,definition);
                        System.out.println();
                        break;
                    // Remove a word and a definition from the dictionary
                    case 4:
                        System.out.println("Removing item to the dictionary ...\n");
                        System.out.println("Please enter a word/phrase to remove");
                        word = reader.readLine().trim();
                        lookup.dictionary.remove(word);
                        break;
                    // Printing full dictionary
                    case 5:
                        System.out.println("Printing the full dictionary ...");
                        lookup.dictionary.printDictionary();
                        break;
                    // Exit the program
                    case 6:
                        running = false; // Set to false to exit the loop
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                        break;
                    }
                
                System.out.print("Enter any key to continue");
                reader.readLine(); // Wait for user input before continuing
                System.out.print("\n\n");
            }
        }catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage()); // Handle exceptions from reading input
            e.printStackTrace();
        }
    }

    /**
     * Loads the dictionary from a specified file
     * @param filename The path of the file containing dictionary entries
     */
    public void loadDictionary(String filename) {
        // Try-catch structure for managing the FileReader and BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("Loading dictionary from file ...\n");
            
            String line; // Variable to hold each line read from the file
            while ((line = reader.readLine()) != null) {
                int colonIndex = line.indexOf(':'); // Find a colon to separate word and definition
                if (colonIndex != -1) { // Ensure the line contains a colon
                    String word = line.substring(0, colonIndex).trim(); // Extract the word
                    String definition = line.substring(colonIndex + 1).trim(); // Extract the definition 
                    dictionary.insert(word, definition); // Insert the word and definition into the dictionary
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the dictionary file: " + e.getMessage()); // Handle errors in reading the file
            e.printStackTrace();
        }
    }

}

