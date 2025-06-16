public class Node {

    String value;   // The value stored in this node
    Node left;      // Reference to the left child node 
    Node right;      // Reference to the right child node 

    /**
     * Constructor to initialize a new node with a given value
     * This node is a basic building block for binary trees
     *
     * @param s The string value to be stored in the node
     */
    public Node(String s){
        value = s;    // Set the value of the node
        left = null;    // Initialize the left node reference to null
        right = null;   // Initialize the right node reference to null 
    }
}
