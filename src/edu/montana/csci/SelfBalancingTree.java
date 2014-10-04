package edu.montana.csci;

public abstract class SelfBalancingTree extends BinaryTree {

	public BinaryTreeVertex rotateRight(BinaryTreeVertex localRoot) {
        BinaryTreeVertex leftChild = localRoot.leftChild;
        localRoot.leftChild = leftChild.rightChild;        
        leftChild.rightChild = localRoot;
        return leftChild;
    }
	public BinaryTreeVertex rotateLeft(BinaryTreeVertex localRoot) {
        BinaryTreeVertex rightChild = localRoot.rightChild;        
        localRoot.rightChild = rightChild.leftChild;
        rightChild.leftChild = localRoot;
        return rightChild;
    }

}