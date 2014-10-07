package edu.montana.csci;

/**
 *  This abstract class extends the BinaryTree by adding the rotate
 *  operations. Rotation will change the balance of a binary
 *  tree while preserving the binary tree property.
 *  Used as a common base class for self-balancing trees.
 */
public class SelfBalancingTree extends BinaryTree {
    // Methods
    /** Method to perform a right rotation.
     *  pre:    localRoot is the local root of a binary tree.
     *  post:   localRoot.rightChild is the local root of a binary tree,
     *          root.rightChild.rightChild is the raised one level,
     *          localRoot.rightChild.leftChild does not change the levels,
     *          localRoot.leftChild is lowed one level,
     *          the new local root is returned.
     *  @param localRoot The root of the binary tree to be rotated
     *  @return The new root of the rotated tree
     */
	public BinaryTreeVertex rotateRight(BinaryTreeVertex localRoot) {
        BinaryTreeVertex leftChild = localRoot.left;
        localRoot.left = leftChild.right;
        leftChild.right = localRoot;
        return leftChild;
    }
    /** Method to perform a left rotation.
     *  pre:    localRoot is the local root of a binary tree.
     *  post:   localRoot.leftChild is the local root of a binary tree,
     *          root.leftChild.leftChild is the raised one level,
     *          localRoot.leftChild.rightChild does not change the levels,
     *          localRoot.rightChild is lowed one level,
     *          the new local root is returned.
     *  @param localRoot The root of the binary tree to be rotated
     *  @return The new root of the rotated tree
     */
	public BinaryTreeVertex rotateLeft(BinaryTreeVertex localRoot) {
        BinaryTreeVertex rightChild = localRoot.right;
        localRoot.right = rightChild.left;
        rightChild.left = localRoot;
        return rightChild;
    }

}