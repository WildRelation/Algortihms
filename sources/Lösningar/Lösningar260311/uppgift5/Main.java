package uppgift5;

public class Main {

	public static void buildTree(BinarySearchTree<Integer> b){
		b.add(10);
		b.add(5);
		b.add(15);
		b.add(2);
		b.add(8);
		b.add(12);
		b.add(17);
		b.add(3);
		b.add(7);
		b.add(11);
		b.add(14);
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst= new BinarySearchTree<>();
		System.out.println(":"+bst.find(6)+":"+bst.nrOfValuesInRange(2,4));
		buildTree(bst);
		System.out.println(bst);
        for(int i=0;i<19;i++){
			System.out.println("find "+i+" :"+bst.find(i));
		}
		for(int i=0;i<19;i++){
			for(int j=0;j<19;j++){
				System.out.println("Range " + i + "-" + j + ": " + bst.nrOfValuesInRange(i, j));
			}
		}
	}

}
