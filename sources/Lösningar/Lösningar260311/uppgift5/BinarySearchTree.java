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
	private E deletedData;

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

	private boolean add(E data,Node<E> node){
		if(data.compareTo(node.data)==0)
			return false;
		else if(data.compareTo(node.data)<0)
			if(node.left==null){
				node.left = new Node<>(data);
				return true;
			}else
				return add(data,node.left);
		else if(node.right==null){
			node.right = new Node<>(data);
			return true;
		}else
			return add(data,node.right);
	}

	public boolean add(E data){
		if(root==null){
			root = new Node<>(data);
			return true;
		}else{
			return add(data,root);
		}
	}

	public E find(E target){
		return find(target, root);
	}

	private E find(E target, Node<E> node){
		if(node==null) return null;
		int order=target.compareTo(node.data);
		if(order==0) return node.data;
		if(order<0) return find(target,node.left);
		return find(target,node.right);
	}

	public int nrOfValuesInRange(E left, E right) {
		if(left.compareTo(right)>0) return 0;
		return nrOfValuesInRange(left, right, root);
	}

	private int nrOfValuesInRange(E left, E right, Node<E> node) {
		if(node == null) return 0;
		if(right.compareTo(node.data) < 0) return nrOfValuesInRange(left,right,node.left);
		if(left.compareTo(node.data) > 0) return nrOfValuesInRange(left,right,node.right);
		return 1 + nrOfValuesInRange(left, right, node.left) + nrOfValuesInRange(left, right, node.right);
	}

}