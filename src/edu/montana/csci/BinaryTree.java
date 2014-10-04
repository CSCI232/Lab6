package edu.montana.csci;

public class BinaryTree extends Graph {	
	
	protected BinaryTreeVertex root;		

	public BinaryTree() {
		super();
		this.root=null;
	}
	public void setRoot(BinaryTreeVertex newRoot) {
		this.root = newRoot;
		this.root.parent=null;
	}	
	public BinaryTreeVertex getRoot() {
		return this.root;
	}
	public void updateEdges() {
		clearVertices();
		inorderWalk(root);		
	}
	public void inorderWalk(BinaryTreeVertex vertex) {
		if (vertex.getLeftChild()!=null) {
			addEdge(new Edge(vertex, vertex.getLeftChild()));
			inorderWalk(vertex.getLeftChild());
		}
		if (vertex.getRightChild()!=null) {
			addEdge(new Edge(vertex, vertex.getRightChild()));
			inorderWalk(vertex.getRightChild());			
		}		
	}		
	public BinaryTreeVertex iterativeTreeSearch(BinaryTreeVertex x, int k){
		while (x != null && x.getValue()!=k ) {
			if (k < x.getValue())
				x = x.getLeftChild();
			else x = x.getRightChild();
		}
		return x;
	}	
	public BinaryTreeVertex treeSearch(BinaryTreeVertex x, int k){
		if (x==null || k==x.getValue())
			return x;
		if (k<x.getValue())
			return treeSearch(x.getLeftChild(),k);
		else return treeSearch(x.getRightChild(),k);
	}	
	public void treeInsert(BinaryTreeVertex vertex) {
		BinaryTreeVertex temp = null;
		BinaryTreeVertex localRoot = this.getRoot();
		while (localRoot!=null) {
			temp = localRoot;
			if (vertex.getValue() < localRoot.getValue())
				localRoot = localRoot.getLeftChild();
			else localRoot = localRoot.getRightChild();	
		}
		vertex.setParent(temp);
		if (temp==null)
			this.setRoot(vertex);
		else if (vertex.getValue() < temp.getValue())
			temp.setLeftChild(vertex);
		else temp.setRightChild(vertex);		
		this.addVertex(vertex);	
	}
	public void transplant(BinaryTreeVertex u, BinaryTreeVertex v) {
		if (u.getParent() == null)
			this.root=v;
		else if (u==u.getParent().getLeftChild())
			u.getParent().setLeftChild(v);
		else u.getParent().setRightChild(v);
		if (v!=null)
			v.setParent(u.getParent());
	}	
	public void treeDelete(BinaryTreeVertex z) {
		if (z.getLeftChild()==null)
			transplant(z,z.getRightChild());
		else if (z.getRightChild()==null)
			transplant(z,z.getLeftChild());
		else {
			BinaryTreeVertex y = treeMinimum(z.getRightChild());
			if (y.getParent()!=z) {
				transplant(y,y.getRightChild());
				y.setRightChild(z.getRightChild());
				y.getRightChild().setParent(y);
			}
			transplant(z,y);
			y.setLeftChild(z.getLeftChild());
			y.getLeftChild().setParent(y);
		}
		this.removeVertex(z);		
	}	
	public BinaryTreeVertex treeMinimum(BinaryTreeVertex x) {
		while (x.getLeftChild()!=null)
			x = x.getLeftChild();
		return x;
	}
}
