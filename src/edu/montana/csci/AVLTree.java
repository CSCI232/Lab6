package edu.montana.csci;
/** Self-balancing binary search tree using the algorithm
	by Adelson-Velskii and Landis.
*/
public class AVLTree extends SelfBalancingTree {
	private AVLVertex treeInsert( AVLVertex vertex, BinaryTreeVertex localRoot )
    {
        if( localRoot == null )
        	localRoot = vertex;
        else if( vertex.getValue() <= localRoot.getValue() )
            localRoot.setLeftChild(treeInsert( vertex, localRoot.leftChild ));
        else 
            localRoot.setRightChild(treeInsert( vertex, localRoot.rightChild ));
        localRoot = updateHeight((AVLVertex)localRoot);
        localRoot = rebalance((AVLVertex)localRoot);        
        return (AVLVertex)localRoot;
    }
	public void treeInsert(AVLVertex vertex) {
		root = treeInsert(vertex, getRoot());		
		addVertex(vertex);	
	}
	public AVLVertex updateHeight(AVLVertex vertex) {
		int leftHeight = vertex.leftChild != null ? ((AVLVertex)vertex.getLeftChild()).height : -1;
		int rightHeight = vertex.rightChild != null ? ((AVLVertex)vertex.getRightChild()).height : -1;
		vertex.balanceFactor = leftHeight - rightHeight;
		vertex.height = 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
		return vertex;
	}
	public AVLVertex rotateRight(AVLVertex localRoot) {
		AVLVertex temp = localRoot;
		localRoot = (AVLVertex)rotateRight((BinaryTreeVertex) localRoot);
		updateHeight(temp);
		updateHeight(localRoot);
		return localRoot;
	}
	public AVLVertex rotateLeft(AVLVertex localRoot) {
		AVLVertex temp = localRoot;
		localRoot = (AVLVertex)rotateLeft((BinaryTreeVertex) localRoot);
		updateHeight(temp);
		updateHeight(localRoot);
		return localRoot;
	}
    @Override
	public AVLVertex getRoot() {
		BinaryTreeVertex avlRoot = new AVLVertex();
		avlRoot = root;
		return (AVLVertex)avlRoot;
	}
	public AVLVertex rebalance(AVLVertex localRoot) {
		if (localRoot.balanceFactor == 2) {
			if (localRoot.leftChild != null && localRoot.getLeftChild().balanceFactor == -1) 
				localRoot.leftChild = rotateLeft(localRoot.getLeftChild());
			localRoot = rotateRight(localRoot);
		} 
		else if (localRoot.balanceFactor == -2) { 
			if (localRoot.rightChild != null && localRoot.getRightChild().balanceFactor == 1) 
				localRoot.rightChild = rotateRight(localRoot.getRightChild());
			localRoot = rotateLeft(localRoot);		
		}
		return localRoot;
	}
}