package Trees;

public class BST {

	Node root;
	
	BST(){
		this.root = null;
	}
	
	public void insert(int value) {
		if(this.root == null) {
			this.root = new Node(value);
			return;
		}
		insert(root, value);
	}
	
	private void insert(Node node, int value) {
		
		
		if(value < node.value) {
			if(node.left == null)
				node.left = new Node(value);
			else
				insert(node.left, value);
		}else {
			if(node.right == null)
				node.right = new Node(value);
			else
				insert(node.right, value);
		}
	}
	
	public void inOrder() {
		System.out.println("******");
		inOrder(this.root);
	}
	private void inOrder(Node node) {
		if(node == null)
			return;
		inOrder(node.left);
		System.out.println(node.value);
		inOrder(node.right);
	}
	
	public Node search(int value) {
		return search(this.root, value);
	}
	private Node search(Node node, int value) {
		if(node == null)
			return null;
		if(node.value == value)
			return node;
		if(value < node.value) {
			return search(node.left, value);
		}else {
			return search(node.right, value);
		}
	}
	
	public void delete(int value) {
		delete(this.root, value);
		
	}
	private Node delete(Node node, int value) {
		if(node == null)
			return node;
		else if(node.value == value ) {
			
				if(node.left == null && node.right == null) {
					return null;
				}
				else if(node.left == null) {
					return node.right;
				}
				else if(node.right == null) {
					return node.left;
				}
				else {
					node.value = findMin(node.right).value;
					node.right = delete(node.right, node.value);
				}
		}
		else if(value < node.value) {
			node.left = delete(node.left, value);
		}
		else if(value > node.value) {
			node.right = delete(node.right, value);
		}
		return node;
		
	}
	
	protected Node findMin(Node node) {
		if(node == null)
			return node;
		if (node.left!=null)
			return findMin(node.left);
		return node;
	}
	
	public static void testBST() {
		BST tree = new BST();
		tree.insert(5);
		tree.insert(1);
		tree.insert(10);
		tree.insert(3);
		tree.insert(8);
		tree.insert(5);
		tree.inOrder();
		System.out.println(tree.search(4));
		System.out.println(tree.search(8));
	}
	
	public static void testBST2() {
		BST tree = new BST();
		tree.insert(12);
		tree.insert(5);
		tree.insert(14);
		tree.insert(3);
		tree.insert(7);
		tree.insert(13);
		tree.insert(17);
		tree.insert(15);
		tree.insert(20);
		tree.insert(18);
		tree.inOrder();
		tree.delete(17);
		tree.inOrder();
		tree.delete(3);
		tree.inOrder();
		tree.delete(15);
		tree.inOrder();
	}
}
