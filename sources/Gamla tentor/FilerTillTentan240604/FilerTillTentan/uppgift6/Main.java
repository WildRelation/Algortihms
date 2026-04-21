package uppgift6;

public class Main {

    public static void main(String[] args){

        BinarySearchTree<String> bst = new BinarySearchTree<>();
        buildTree(bst,new String[] {"H","D","P","B","F","K","R","A","C","E","G","J"});
        System.out.println(bst.complete());
    }

    private static void buildTree(BinarySearchTree<String> bst, String[] strings) {
        for(String data:strings) bst.add(data);
    }
}
