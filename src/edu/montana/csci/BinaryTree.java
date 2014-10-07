package edu.montana.csci;

import java.util.Objects;

/** Class for a binary tree that stores Object objects. */
public class BinaryTree extends Graph {

	// Data Fields
    /** The root of the binary tree */
	protected BinaryTreeVertex root;

    // Constructors
    /** Protected constructor that takes a BinaryTreeVertex as a parameter.
     *  @param root
     */
    protected BinaryTree(BinaryTreeVertex root) {
        this.root = root;
    }
    /** Constructs a new binary tree with a empty root. */
    public BinaryTree() {
        root =null;
    }
    /** Constructs  a new binary tree with data in its root.
     *  @param data
     */
    public BinaryTree(Object data) {
        root = new BinaryTreeVertex(data);
    }

    // Methods
    /** Iterative search method.
     * pre: The target object must implement
     *      the Comparable interface.
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    public Object search(Comparable target){
        BinaryTreeVertex localRoot = root;
        int compResult = target.compareTo(root.data);
    while (localRoot != null && compResult !=0 ) {
        if (compResult < 0)
            localRoot = localRoot.left;
        else localRoot = localRoot.right;
    }
    return localRoot == null ? null : target;
    }


	protected void updateEdges() {
		clearVertices();
		inorderWalk(root);
	}

	protected void inorderWalk(BinaryTreeVertex vertex) {
		if (vertex.left!=null) {
			addEdge(new Edge( vertex, vertex.left));
			inorderWalk(vertex.left);
		}
		if (vertex.right!=null) {
			addEdge(new Edge(vertex, vertex.right));
			inorderWalk(vertex.right);
		}
	}

	public void treeInsert(Comparable item) {
		BinaryTreeVertex temp = new BinaryTreeVertex(null);
        BinaryTreeVertex vertex = new BinaryTreeVertex(item);
		BinaryTreeVertex localRoot = this.root;
		while (localRoot!=null) {
			temp = localRoot;
			if (item.compareTo(localRoot.data) < 0)
				localRoot = localRoot.left;
			else localRoot = localRoot.right;
		}
		vertex.parent = temp;
		if (temp==null)
			this.root = vertex;
		else if (item.compareTo(temp.data) < 0)
			temp.left = vertex;
		else temp.right = vertex;
		this.addVertex(vertex);
	}

	public void transplant(BinaryTreeVertex u, BinaryTreeVertex v) {
		if (u.parent == null)
			this.root=v;
		else if (u == u.parent.left)
			u.parent.left = v;
		else u.parent.right = v;
		if (v!=null)
			v.parent = u.parent;
	}

	public void treeDelete(BinaryTreeVertex z) {
		if (z.left == null)
			transplant(z,z.right);
		else if (z.right == null)
			transplant(z,z.left);
		else {
			BinaryTreeVertex y = treeMinimum(z.right);
			if (y.parent != z) {
				transplant(y,y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z,y);
			y.left =  z.left;
			y.left.parent = y;
		}
		this.removeVertex(z);
	}

	public BinaryTreeVertex treeMinimum(BinaryTreeVertex x) {
		while (x.left !=null)
			x = x.left;
		return x;
	}
}
