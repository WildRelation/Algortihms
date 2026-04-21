package uppgift5;
public class BinarySearchTree<E extends Comparable<E>> {
	
	private static class Node<E>{
		private E data;
		private Node<E> left,right;
		private Node(E d){
			data=d;
			left=right=null;
		}
		@Override
		public String toString(){
			return data.toString();
		}
	}
	
	private Node<E> root;
	
	public BinarySearchTree(){
		root=null;
	}
	
	private void inOrder(Node<E> node, StringBuilder sb){
		if(node!=null){
			inOrder(node.left, sb);
			sb.append(": ").append(node);
			inOrder(node.right, sb);
		}
	}
        
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		inOrder(root,sb);
		return sb.toString();
	}

	public boolean add(E data){ }

	public boolean full(){ }

}