public class DictionaryNode {

    String word;  // The word or phrase
    String definition;  // The definition of the word or phrase
    DictionaryNode left;  // Left child in the BST
    DictionaryNode right; // Right child in the BST

    /**
     * Constructor to initialize a dictionary node with a word, its definition
     * and initially null references for its left and right children
     * This is used to add a new node to the dictionary BST
     * 
     * @param word The word or phrase to be stored in the node.
     * @param definition The definition of the word or phrase.
     */
    public DictionaryNode(String word, String definition) {
        this.word = word; // Set the word of this node to the given one
        this.definition = definition; // Set the definition of this node to the given one
        this.left = null; // Initialize the left child as null
        this.right = null; // Initialize the right child as null
    }

}
