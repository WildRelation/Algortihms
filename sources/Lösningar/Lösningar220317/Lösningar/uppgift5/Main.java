package uppgift5;

public class Main {

    public static void buildTree(BinarySearchTree<Integer> b, int[] v){
        for(int data:v)
            b.add(data);
    }
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst= new BinarySearchTree<>();//true
        System.out.println("Tree:" + bst +" balanced: " + bst.isBalanced() + " effective: " + bst.isBalancedEffective());

        buildTree(bst,new int[] {30,20,40,15,35,45,37});//true
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced() + " effective: " + bst.isBalancedEffective());

        bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {30,20,40,15,35,45,17,37});//false
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced() + " effective: " + bst.isBalancedEffective());

        bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {30,20,40,15,35,45,37,42,47,49});//false
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced() + " effective: " + bst.isBalancedEffective());

        bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {30,20,40,15,22,35,45,17,37,42,47,49});//true
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced() + " effective: " + bst.isBalancedEffective());

        bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {1});//true
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced() + " effective: " + bst.isBalancedEffective());

        bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {1,2});//true
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced() + " effective: " + bst.isBalancedEffective());

        bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {2,1});//true
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced() + " effective: " + bst.isBalancedEffective());

        bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {1,2,3});//false
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced() + " effective: " + bst.isBalancedEffective());

        bst= new BinarySearchTree<>();
        buildTree(bst,new int[] {3,2,1});//false
        System.out.println("Tree:" + bst + " balanced: " + bst.isBalanced() + " effective: " + bst.isBalancedEffective());

    }

}
