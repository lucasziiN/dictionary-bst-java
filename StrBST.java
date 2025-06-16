public class StrBST{
    Node root;

    /**
     * Constructor to initialize the StrBST with no root
     */
    public StrBST(){
        root = null; // Initialize root as null to indicate an empty tree
    }

    /**
     * Prints the entire tree structure using the given method from StrBSTPrinter class
     */
    public void printTree(){
        System.out.println("Tree: ");
        StrBSTPrinter.printNode(root);
    }

    /**
     * Inserts a new string into the BST
     * @param s the string to insert
     */
    public void insert(String s){
        root = insertR(s,root);
    }

    /**
     * Recursive method to insert a string into the BST
     * @param s the string to insert
     * @param cRoot the current root node of the subtree
     * @return the new root of the subtree
     */
    public Node insertR(String s, Node cRoot){
        
        if (cRoot == null){
            cRoot = new Node(s); // Create a new node if the current root is null
        }
        else if (s.compareTo(cRoot.value) < 0){
            cRoot.left = insertR(s, cRoot.left); // Recur left if the string is smaller than the current node's value
        }
        else if (s.compareTo(cRoot.value) > 0){
            cRoot.right = insertR(s, cRoot.right); // Recur right if the string is greater
        }
        return cRoot; // Return current root
    }
    
    /**
     * Searches for a string in the BST
     * @param s the string to search for
     * @return true if the string is found, false otherwise
     */
    public boolean search(String s){
        boolean found = false; 
        found = searchR(s,root);
        return found;
    }
    
    /**
     * Recursive method to search for a string in the BST
     * @param s the string to search for
     * @param cRoot the current root node of the subtree
     * @return true if the string is found, false otherwise
     */
    public boolean searchR(String s, Node cRoot){
        boolean found = false;
        if (cRoot == null){
            found = false; // string not found 
        }
        else if (cRoot.value.compareTo(s) == 0){
            found = true; // Return true if the string matches the string stored in the current node's
        }
        else if (s.compareTo(cRoot.value) < 0){
            found = searchR(s,cRoot.left); // Recur left if the string is smaller
        }
        else if (s.compareTo(cRoot.value) > 0){
            found = searchR(s,cRoot.right); // Recur right if the string is larger
        }
        return found;
    }

    /**
     * Prints the BST in an in-order traversal
     */
    public void print(){
        printR(root);
    }

    /**
     * Recursive method for in-order traversal of the BST
     * @param cRoot the current root node of the subtree
     */
    public void printR(Node cRoot){
        if (cRoot == null){
            return; // Stop recursion if reach a null node
        }

        printR(cRoot.left); // Recur left for in-order traversal

        System.out.print("Root: " + cRoot.value); // Print root
        
        if (cRoot.left == null){
            System.out.print(" | Left: null"); // Print null if left child is null 
        } else {
            System.out.print(" | Left: " + cRoot.left.value); // Else print string stored in the node 
        }

        if (cRoot.right == null){
            System.out.print(" | Right: null"); // Print null if right child is null 
        } else {
            System.out.print(" | Right: " + cRoot.right.value); // Else print string stored in the node 
        }
        System.out.println();

        printR(cRoot.right); // Recur right for in-order traversal
    }

    /**
     * Removes a string from the BST
     * @param s the string to remove
     */
    public void remove(String s){
        root = removeR(s, root);
    }

    /**
     * Recursive method to remove a string from the BST.
     * @param s the string to remove
     * @param cRoot the current root node of the subtree
     * @return the new root of the subtree
     */
    public Node removeR(String s, Node cRoot){
        if (cRoot == null) {
            System.out.println("Value not found"); // Output message if value is not found
            return null; // Nothing to remove so return null
        }

        // Determine which subtree to recur down
        if (cRoot.value.compareTo(s) == 0){
            // Conditions for node with no children, one child, or two children
            if (cRoot.left == null && cRoot.right == null){
                return null; // Return null to remove no children node
            }
            else if (cRoot.left != null && cRoot.right == null){
                return cRoot.left; // Return the left child to replace this node
            }
            else if (cRoot.left == null && cRoot.right != null){
                return cRoot.right; // Return the right child to replace this node
            }
            // Node has two children
            else if (cRoot.left != null && cRoot.right != null){
                // Find the minimum value in the right subtree to replace this node's value
                Node child = findMin(cRoot.right);
                cRoot.value = child.value;  // Replace value
                cRoot.right = removeR(child.value, cRoot.right);  // Remove the min node
                return cRoot;
            }
            
        }
        
        else if (s.compareTo(cRoot.value) < 0){
            cRoot.left = removeR(s,cRoot.left); // Recur left if the string is smaller
            
        }
        else if (s.compareTo(cRoot.value) > 0){
            cRoot.right = removeR(s,cRoot.right); // Recur right if the string is larger
            
        }
        return cRoot; // return current root
    }

    /**
     * Finds the minimum node in the subtree
     * @param node the root node of the subtree
     * @return the node with the minimum value
     */
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left; // Traverse left to find the minimum value
        }   
        return node;  // Return the smallest node in the right subtree
    }
}