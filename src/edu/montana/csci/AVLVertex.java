package edu.montana.csci;
/** Class to represent an AVL Vertex. It extends the 
BinaryTreeVertex by adding the balanceFactor field. */
public class AVLVertex extends BinaryTreeVertex {
	protected int height;
	protected int balanceFactor;

	// Methods
	/** Construct a node with the given integer val. 
		@param val int */ 
	public AVLVertex(int val) {
		super(val);
		balanceFactor=0;
		height=1;		
	}
	public AVLVertex() {
		super();
	}
	public void setBalanceFactor(int inBalanceFactor) {
		this.balanceFactor = inBalanceFactor;
	}
	public int getBalanceFactor() {
		return this.balanceFactor;
	}
	public void setHeight(int inHeight) {
		this.height = inHeight;
	}
	public int getHeight() {
		return this.height;
	}
	@Override
	public AVLVertex getLeftChild() {
		BinaryTreeVertex left = new AVLVertex();
		left = leftChild;
		return (AVLVertex)left;
	}
	@Override
	public AVLVertex getRightChild() {
		BinaryTreeVertex right = new AVLVertex();
		right = rightChild;
		return (AVLVertex) right;
	}
	@Override
	public AVLVertex getParent() {
		BinaryTreeVertex avlParent = new AVLVertex();
		return (AVLVertex) avlParent;
	}

}