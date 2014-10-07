package edu.montana.csci;

/**
 * Created by gustavohb on 10/2/14.
 */
/** Class to represent Red-Black tree. */
public class RedBlackTree extends SelfBalancingTree {

    //Methods
    /** Insert an Object into the Red-Black tree.
     *  @param  item The object item to be inserted
     */
    public void add(Object item) {
        if (root == null) {
            root = new RedBlackTreeVertex(item);
            ((RedBlackTreeVertex) root).isRed = false; // root is black.
        }
        else {
            root = add((RedBlackTreeVertex) root, (Comparable) item);
            ((RedBlackTreeVertex) root).isRed = false; // root is always black.
        }
    }
    /** Recursive method to insert an Object into the tree.
     *  @param localRoot The local root
     *  @param  item The element to be inserted
     *  @return RedBlackTree
     */
    private RedBlackTreeVertex add(RedBlackTreeVertex localRoot, Comparable item) {
        if(item.compareTo(localRoot.data) < 0) {
            // item < localRoot.data.
            if (localRoot.left == null) {
                // Create a new left child.
                localRoot.left = new RedBlackTreeVertex(item);
                return localRoot;
            }
            else { // Need to search.
                // Check for red children, swap colors if found.
                moveBlackDown(localRoot);
                // Recursively add on the left.
                localRoot.left = add((RedBlackTreeVertex) localRoot.left, item);
                // See whether the left child is now red
                if (((RedBlackTreeVertex) localRoot.left).isRed) {
                    if (localRoot.left.left != null
                            && ((RedBlackTreeVertex) localRoot.left.left).isRed) {
                        // Left-left grandchild is also red.
                        // Single rotation is necessary.
                        ((RedBlackTreeVertex) localRoot.left).isRed = false;
                        localRoot.isRed = true;
                        return (RedBlackTreeVertex) rotateRight(localRoot);
                    } else if (localRoot.left.right != null
                            && ((RedBlackTreeVertex) localRoot.left.right).isRed) {
                        // Left-right grandchild is also red.
                        // Double rotation is necessary.
                        localRoot.left = rotateLeft(localRoot.left);
                        ((RedBlackTreeVertex) localRoot.left).isRed = false;
                        localRoot.isRed = true;
                        return (RedBlackTreeVertex) rotateRight(localRoot);
                    }
                }
                return localRoot;
            }
        }
        else {
            // item > localRoot.data.
            if (localRoot.right == null) {
                // Create a new right child.
                localRoot.right = new RedBlackTreeVertex(item);
                return localRoot;
            }
            else { // Need to search.
                // Check for red children, swap colors if found.
                moveBlackDown(localRoot);
                // Recursively add on the right.
                localRoot.right = add((RedBlackTreeVertex) localRoot.right, item);
                // See whether the right child is now red
                if (((RedBlackTreeVertex) localRoot.right).isRed) {
                    if (localRoot.right.right != null
                            && ((RedBlackTreeVertex) localRoot.right.right).isRed) {
                        // Right-right grandchild is also red.
                        // Single rotation is necessary.
                        ((RedBlackTreeVertex) localRoot.right).isRed = false;
                        localRoot.isRed = true;
                        return (RedBlackTreeVertex) rotateLeft(localRoot);
                    } else if (localRoot.right.left != null
                            && ((RedBlackTreeVertex) localRoot.right.left).isRed) {
                        // Right-left grandchild is also red.
                        // Double rotation is necessary.
                        localRoot.right = rotateRight(localRoot.right);
                        ((RedBlackTreeVertex) localRoot.right).isRed = false;
                        localRoot.isRed = true;
                        return (RedBlackTreeVertex) rotateLeft(localRoot);
                    }
                }
                return localRoot;
            }
        }
    }
    private void moveBlackDown(RedBlackTreeVertex localRoot) {
        if ( localRoot.left != null && localRoot.right != null)
            // See whether both the left child and the right child are red
            if (  ((RedBlackTreeVertex) localRoot.left).isRed
                    && ((RedBlackTreeVertex) localRoot.right).isRed) {
                // Change the color of the children to black and change local root to red.
                ((RedBlackTreeVertex) localRoot.left).isRed = false;
                ((RedBlackTreeVertex) localRoot.right).isRed = false;
                localRoot.isRed = true;
            }
    }
}
