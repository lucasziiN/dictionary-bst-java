public class Main {
    
    public static void main(String[] args){
        System.out.println("Testing BST ADT");

        StrBST strBST = new StrBST();

        System.out.println("Inserting nodes C,B,A,E,D ..." );

        strBST.insert("C");
        strBST.insert("B");
        strBST.insert("A");
        strBST.insert("E");
        strBST.insert("D");

        strBST.printTree();

        System.out.println("A is in BST: " + strBST.search("A"));
        System.out.println("F is in BST: " + strBST.search("F"));
        
        strBST.print();

        System.out.println("Removing node B ...");
        strBST.remove("B");
        strBST.printTree();

        System.out.println("Removing node C ...");
        strBST.remove("C");
        strBST.printTree();

        System.out.println("Removing node A ...");
        strBST.remove("A");
        strBST.printTree();
    }
}
