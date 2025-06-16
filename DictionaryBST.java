public class DictionaryBST{
    DictionaryNode root; // Root of the binary search tree

    /**
     * Constructor to initialize the DictionaryBST with no root node.
     */
    public DictionaryBST(){
        root = null; // Initially, the tree is empty
    }

    /**
     * Public method to print the entire dictionary in alphabetical order
     */
    public void printDictionary() {
        printDictionaryR(root); // Start the recursive print from the root
    }

    /**
     * Private recursive method to print the dictionary
     * Uses in-order traversal to print all nodes in sorted order
     * @param node the current node being visited
     */
    private void printDictionaryR(DictionaryNode node) {
        if (node != null) {
            printDictionaryR(node.left);  // Visit left subtree
            System.out.println(node.word);  // Visit node itself
            System.out.println(node.definition + "\n");  // Print definition with a newline for better readability
            printDictionaryR(node.right);  // Visit right subtree
        }
    }

    /**
     * Public method to print a specific dictionary item
     * @param s the word to find in the dictionary
     */
    public void printDictionaryItem(String s) {
        DictionaryNode result = getNode(s); // Retrieve the node containing the word
        if (result != null) {
            System.out.println(result.word); // Print word
            System.out.println(result.definition + "\n"); // Print definition
        } else {
            System.out.println("Word not found: " + s); // Inform user if word is not found
        }
    }

    /**
     * Public method to insert a word and its definition into the dictionary
     * @param word the word to insert
     * @param definition the definition of the word
     */
    public void insert(String word, String definition){
        root = insertR(word, definition, root);
    }

    /**
     * Private recursive method to insert a word into the dictionary
     * @param word the word to insert
     * @param definition the definition of the word
     * @param cRoot the current root node of the subtree
     * @return the new or modified subtree root
     */
    private DictionaryNode insertR(String word, String definition, DictionaryNode cRoot){
        
        if (cRoot == null){
            return new DictionaryNode(word,definition);
        }
        else if (word.compareTo(cRoot.word) < 0){
            cRoot.left = insertR(word, definition, cRoot.left);
        }
        else if (word.compareTo(cRoot.word) > 0){
            cRoot.right = insertR(word, definition, cRoot.right);
        }
        return cRoot;
    }
    
    /**
     * Public method to retrieve a node based on the word
     * @param word the word to find in the dictionary
     * @return the node containing the word, or null if not found
     */
    public DictionaryNode getNode(String word) {
        return getNodeR(word, root);
    }

    /**
     * Private recursive method to find a node by word
     * @param s the word to find
     * @param cRoot the current root node of the subtree
     * @return the node containing the word, or null if not found
     */
    private DictionaryNode getNodeR(String s, DictionaryNode cRoot) {
        if (cRoot == null) {
            return null; // If node is not found
        } else if (cRoot.word.equals(s)) {
            return cRoot; // Return the node if the word matches
        } else if (s.compareTo(cRoot.word) < 0) {
            return getNodeR(s, cRoot.left); // Search in the left subtree
        } else {
            return getNodeR(s, cRoot.right); // Search in the right subtree
        }
    }

    /**
     * Public method to check if a word exists in the dictionary
     * @param word the word to search for
     * @return true if the word is found, false otherwise
     */
    public boolean search(String word){
        boolean found = false; 
        found = searchR(word,root);
        return found;
    }
    
    /**
     * Private recursive method to search for a word in the dictionary
     * @param s the word to search for
     * @param cRoot the current root node of the subtree
     * @return true if found, false otherwise
     */
    private boolean searchR(String s, DictionaryNode cRoot){
        boolean found = false;
        if (cRoot == null){
            found = false; // Word is not found
        }
        else if (cRoot.word.compareTo(s) == 0){
            found = true; // Word is found
        }
        else if (s.compareTo(cRoot.word) < 0){
            found = searchR(s,cRoot.left); // Search in the left subtree
        }
        else if (s.compareTo(cRoot.word) > 0){
            found = searchR(s,cRoot.right); // Search in the right subtree
        }
        return found;
    }

    /**
     * Public method to remove a word from the dictionary
     * @param word the word to remove
     */
    public void remove(String word){
        root = removeR(word, root);
    }

    /**
     * Private recursive method to remove a node with a specific word
     * @param word the word of the node to remove
     * @param cRoot the current root node of the subtree
     * @return the new or modified subtree root
     */
    private DictionaryNode removeR(String word, DictionaryNode cRoot){
        if (cRoot == null) {
            System.out.println("Value not found"); // Notify user if the word is not found
            return null; 
        }

        if (cRoot.word.compareTo(word) == 0){
            System.out.println("Thank you, that item has been removed");
            if (cRoot.left == null && cRoot.right == null){
                return null; // Node has no children, simply remove it
            }
            else if (cRoot.left != null && cRoot.right == null){
                return cRoot.left; // Node has only left child, replace node with left child
                
            }
            else if (cRoot.left == null && cRoot.right != null){
                return cRoot.right; // Node has only right child, replace node with right child
                
            }
            else if (cRoot.left != null && cRoot.right != null){
                // Node has two children, find the minimum node on the right (in-order successor)
                DictionaryNode child = findMin(cRoot.right); 
                cRoot.word = child.word;  // Replace the word
                cRoot.definition = child.definition;  // Replace the definition
                cRoot.right = removeR(child.word, cRoot.right);  // Remove the in-order successor
                return cRoot;
            }
            
        }
        
        else if (word.compareTo(cRoot.word) < 0){
            cRoot.left = removeR(word,cRoot.left); // Continue search on the left subtree
            
        }
        else if (word.compareTo(cRoot.word) > 0){
            cRoot.right = removeR(word,cRoot.right); // Continue search on the right subtree
            
        }
        return cRoot;
    }

    /**
     * Helper method to find the node with the minimum word in a subtree
     * @param node the root node of the subtree
     * @return the node with the smallest word
     */
    private DictionaryNode findMin(DictionaryNode node) {
        while (node.left != null) {
            node = node.left; // Move left until the smallest node is found
        }
        return node;  // Return the smallest node found in the subtree
    }
}