package edu.montana.csci;

/**
 * Created by Barrionuevo on 10/5/14.
 */
public class BinaryTreeVertex extends Vertex {
    // Data Fields
//        /** The information stored in this node. */
//        protected Object data;
    /** Reference to the left child. */
    protected BinaryTreeVertex left;
    /** Reference to the right child. */
    protected BinaryTreeVertex right;
    /** Reference to the parent. */
    protected BinaryTreeVertex parent;

    // Constructors
    /** Construct a node with given data and no children.
     *  @param data The data to store in this node
     */
    public BinaryTreeVertex(Object data) {
        super(data);
        left = null;
        right = null;
        parent = null;
    }
}
