package Trees;

public class AVLNode {

	private int height;
	public int value;
	public AVLNode left;
	public AVLNode right;
	
	public AVLNode(int value, int height) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.height = 0;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
}
