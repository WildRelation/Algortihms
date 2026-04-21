package uppgift5;

public class Main {
	public static void main(String[] args) {

		BinarySearchTree<Integer> bst= new BinarySearchTree<>();
		bst.add(10);
		System.out.println(bst.full());
		bst.add(5);
		System.out.println(bst.full());
		bst.add(15);
		System.out.println(bst.full());
		bst.add(7);
		System.out.println(bst.full());
		
		System.out.println(bst);
	}

}
