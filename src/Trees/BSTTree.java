package Trees;

public class BSTTree {

	Node root;
	public BSTTree() {
		this.root = null;
	} 
	
	public void insert(int v) {
		if(this.root == null) {
			this.root = new Node(v);
			return;
		}
		insert(this.root, v);
	}
	
	private void insert(Node node, int v) {
		if(v < node.value) {
			if(node.left == null)
				node.left = new Node(v);
			else
				insert(node.left, v);
		}else if(v>node.value) {
			if(node.right == null)
				node.right = new Node(v);
			else
				insert(node.right, v);
		}
		
	}
	
	public void inOrder() {
		System.out.println("****");
		inOrder(this.root);
	}
	private void inOrder(Node node) {
		if(node == null)
			return;
		inOrder(node.left);
		System.out.println(node.value);
		inOrder(node.right);
	}
	public void preOrder() {
		System.out.println("****");
		preOrder(this.root);
	}
	private void preOrder(Node node) {
		if(node == null)
			return;
		System.out.println(node.value);
		inOrder(node.left);
		inOrder(node.right);
	}
	
	public boolean search(int v) {
		return search(this.root, v);
	}
	
	private boolean search(Node node, int v) {
		if(node == null)
			return false;
		if(node.value == v)
			return true;
		else {
			if(v<node.value)
					return search(node.left, v);
			else
					return search(node.right, v);
		}
	}
	
	public void delete(int v) {
		delete(this.root, v);
	}
	private Node delete(Node node, int v) {
		if(node == null) {
			return node;
		}
		
		if(v < node.value)
			node.left =  delete(node.left, v);
		else if(v> node.value) {
			node.right =  delete(node.right, v);
		}else {
			if(node.right== null && node.left == null)
				return null;
			if(node.right == null) {
				return node.left;
			}
			if(node.left == null) {
				return node.right;
			}
			node.value = findMin(node.right);
			node.right =  delete(node.right, node.value);
		}
		return node;
		
	}
	
	protected int findMin(Node node) {
		
		while(node.left!=null) {
			node = node.left;
		}
		return node.value;
	}
	
	public static void testBSTTree() {
//		BSTTree tree = new BSTTree();
//		tree.insert(5);
//		tree.insert(1);
//		tree.insert(10);
//		tree.insert(3);
//		tree.insert(8);
//		tree.insert(5);
//		tree.insert(0);
//		tree.insert(20);
//		tree.inOrder();
//		
//		tree.delete(20);
//		tree.delete(0);
//		tree.delete(8);
//		tree.delete(10);
//		
//		tree.inOrder();
		
//		System.out.println("found? 20: "+tree.search(20));
//		System.out.println("found? 8: "+tree.search(8));
//		System.out.println("found? 5: "+tree.search(5));
//		System.out.println("found? 30: "+tree.search(30));
//		System.out.println("found? -2: "+tree.search(-2));


		
	}
	
}
