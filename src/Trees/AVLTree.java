package Trees;

public class AVLTree {
	AVLNode root;

	public  AVLTree() {
		this.root = null;
	}
	
	private AVLNode rotateLeft(AVLNode node) {
		
		// preserve the value of the left subtree of the node.right in order to be added as a right child for the node (node) later on
		AVLNode temp = node.right.left;
		// preserve the newParentNode
	    AVLNode newParent = node.right;
		newParent.left = node;
		node.right = temp;
		//update height
		updateHeight(node);
		updateHeight(newParent);
		
		return newParent;
		
	}
	
	private AVLNode rotateRightLeft(AVLNode node) {
	
		// preserve the value of the left subtree of the node.left.left in order to be added as a right child for the previous parent node later on
		AVLNode tempLeft = node.right.left!=null ? node.right.left.left : null;
		// preserve the value of the right subtree of the node.left.right in order to be added as a left child for the previous parent node later on
		AVLNode tempRight = node.right.left!=null ? node.right.left.right : null;
		// preserve the newParentNode
		AVLNode newParent = node.right.left;
		// previous parent node becomes a child of the new parent node.
		newParent.left = node;
		newParent.right = node.right;
		
		node.right = tempLeft;
		newParent.right.left = tempRight;
		//update height
		updateHeight(node);
		updateHeight(newParent.right);
		updateHeight(newParent);
		return newParent;
	}
	
	private AVLNode rotateRight(AVLNode node) {
		// preserve the value of the right subtree of the node.left in order to be added as a left child for the node (node) later on
		AVLNode temp = node.left.right;
		// preserve the newParentNode
		AVLNode newParent = node.left;
		newParent.right = node;
		node.left = temp;
		//update height
		updateHeight(node);
		updateHeight(newParent);
		
		return newParent;
	}
	private AVLNode rotateLeftRight(AVLNode node) {
		// preserve the value of the left subtree of the node.left.right in order to be added as a right child for the node (nweParent.left) later on
		AVLNode tempLeft = node.left.right != null ? node.left.right.left : null;
		// preserve the value of the right subtree of the node.right.right in order to be added as a left child for the node (node.left) later on
		AVLNode tempRight = node.left.right != null ? node.left.right.right : null;
		// preserve the newParentNode
		AVLNode newParent = node.left.right;
		// previous parent node becomes a child of the new parent node.
		newParent.right = node;
		newParent.left = node.left;
		node.left = tempRight;
		newParent.left.right = tempLeft;
		//update height
		updateHeight(node);
		updateHeight(newParent.left);
		updateHeight(newParent);
		return newParent;
		
	}
	
	public void insert(int v) {
		this.root = insert(this.root, v);
	}
	
	private int getBalance(AVLNode node) {
		return node ==null ? 0 : ((node.left==null ? -1 : node.left.getHeight()) - (node.right==null ? -1 :node.right.getHeight()));
	}
	
	private AVLNode insert(AVLNode node, int v) {
		
		if(node == null) {
			node = new AVLNode(v, 0);
			return node;
		}
		if(v< node.value) {
			node.left = insert(node.left, v);
		}else if(v> node.value) {
			node.right = insert(node.right, v);
		}else // don't add a number if it is a duplicate
			return node;
		
		// set height of the node
		node.setHeight(1+ Math.max(node.left==null ? -1 :node.left.getHeight(), node.right==null ? -1 :node.right.getHeight()));
		
		// Get balance
		int balance = getBalance(node);
		
		
		// if balance is more than 1 it means the tree is heave from the left side
		if(balance > 1) {
			// left left - the added value is less than the left side of the current node. ex: insert 3, 2, 1
			if(v < node.left.value) {
				return rotateRight(node);
			}
			// left right - the added value is more than the right side of the current node. ex: insert 5, 2, 3
			if(v > node.left.value) {
//				node.left = rotateLeft(node.left);
//				return rotateRight(node);
				return rotateLeftRight(node);
			}
		}
		// if balance is less than -1 it means the tree is heave from the right side
		if (balance < -1) {
			// right right - the added value is more than the right side of the current node. ex: insert 1, 2, 3
			if(v > node.right.value) {
				return rotateLeft(node);
			}
			// right Left - the added value is less than the right side of the current node. ex: insert 3, 5, 4
			if(v < node.right.value) {
//				node.right = rotateRight(node.right);
//				return rotateLeft(node)
				return rotateRightLeft(node);
			}
		}
		
		// balanace is within range
		
		return node;
		
		
		
		
	}
	
	public void delete(int v) {
		this.root = delete(this.root, v);
	}
	
private AVLNode delete(AVLNode node, int v) {
		
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
		
		// set height of the node
		node.setHeight(1+ Math.max(node.left==null ? -1 :node.left.getHeight(), node.right==null ? -1 :node.right.getHeight()));
//		System.out.println("node's height: "+node.getHeight());
		
		// Get balance
		int balance = getBalance(node);
		
		
		// if balance is more than 1 it means the tree is heave from the left side
		if(balance > 1) {
			// left left - determine which part of the right side is heavier
			if(getBalance(node.left) >= 0) {
				return rotateRight(node);
			}
			// left right - determine which part of the right side is heavier
			if(getBalance(node.left) < 0) {
//				node.left = rotateLeft(node.left);
//				return rotateRight(node);
				return rotateLeftRight(node);
			}
		}
		// if balance is less than -1 it means the tree is heave from the right side
		if (balance < -1) {
			// right right - determine which part of the right side is heavier
			if(getBalance(node.right) <= 0) {
				return rotateLeft(node);
			}
			// right Left - determine which part of the right side is heavier
			if(getBalance(node.right) > 0) {
//				node.right = rotateRight(node.right);
//				return rotateLeft(node)
				return rotateRightLeft(node);
			}
		}
		
		// balanace is within range
		
		return node;
		
		
		
		
	}

	private int findMin(AVLNode node) {
	
		while(node.left!=null) {
			node = node.left;
		}
		return node.value;
	}
	
	public void updateHeight(AVLNode node) {
		 node.setHeight(1+ Math.max(node.left==null ? -1 :node.left.getHeight(), node.right==null ? -1 :node.right.getHeight()));
	}
	
	public void inOrder() {
		System.out.println("******");
		inOrder(this.root);
	}
	private void inOrder(AVLNode node) {
		if(node == null)
			return;
		inOrder(node.left);
		System.out.println(node.value);
		inOrder(node.right);
	}
	
	public static void testAVL() {
		
		// test left left
		AVLTree tree = new AVLTree();
//		tree.insert(6);
//		tree.insert(5);
//		tree.insert(4);
//		tree.insert(3);
//		tree.insert(2);
//		tree.insert(1);
//		tree.inOrder();
		
		// test left right
		AVLTree tree2 = new AVLTree();
		tree2.insert(5);
		tree2.insert(2);
		tree2.insert(3);
		tree2.insert(4);
		tree2.insert(8);
//		tree2.insert(10);
//		tree2.insert(15);
//		tree2.insert(20);
//		tree2.insert(12);
//		tree2.insert(25);
//		tree2.insert(0);
		tree2.inOrder();
		
//		tree2.delete(5);
//		tree2.delete(3);
//		tree2.delete(4);
//		tree2.delete(2);
//		tree2.delete(3);
		tree2.delete(2);
		tree2.inOrder();
		
		// test right right
//		AVLTree tree3 = new AVLTree();
//		tree3.insert(1);
//		tree3.insert(2);
//		tree3.insert(3);
//		tree3.inOrder();
			
		// test right left
//		AVLTree tree4 = new AVLTree();
//		tree4.insert(3);
//		tree4.insert(4);
//		tree4.insert(5);
//		tree4.inOrder();
	}
	
}
