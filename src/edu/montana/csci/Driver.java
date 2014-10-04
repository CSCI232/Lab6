package edu.montana.csci;

public class Driver {
	
		public static void main(String[] args) {
			
			AVLTree myTree = new AVLTree();
			
			AVLVertex v1 = new AVLVertex(1);
			AVLVertex v2 = new AVLVertex(2);
			AVLVertex v3 = new AVLVertex(3);
			AVLVertex v4 = new AVLVertex(4);
			AVLVertex v5 = new AVLVertex(5);
			AVLVertex v6 = new AVLVertex(6);
			AVLVertex v7 = new AVLVertex(7);
			AVLVertex v8 = new AVLVertex(8);
			AVLVertex v9 = new AVLVertex(9);
			AVLVertex v10 = new AVLVertex(10);
			AVLVertex v11 = new AVLVertex(11);
			AVLVertex v12 = new AVLVertex(12);
			AVLVertex v13 = new AVLVertex(13);
			
			myTree.treeInsert(v1);						
			myTree.treeInsert(v5);
			myTree.treeInsert(v7);
			myTree.treeInsert(v2);
			myTree.treeInsert(v3);
			myTree.treeInsert(v13);
			myTree.treeInsert(v4);
			myTree.treeInsert(v6);
			myTree.treeInsert(v10);
			myTree.treeInsert(v8);
			myTree.treeInsert(v9);			
			myTree.treeInsert(v11);
			myTree.treeInsert(v12);

			// myTree.treeInsert(v13);						
			// myTree.treeInsert(v12);
			// myTree.treeInsert(v11);
			// myTree.treeInsert(v10);
			// myTree.treeInsert(v9);
			// myTree.treeInsert(v8);
			// myTree.treeInsert(v7);
			// myTree.treeInsert(v6);
			// myTree.treeInsert(v5);
			// myTree.treeInsert(v4);
			// myTree.treeInsert(v3);			
			// myTree.treeInsert(v2);
			// myTree.treeInsert(v1);

			// myTree.treeInsert(v1);						
			// myTree.treeInsert(v2);
			// myTree.treeInsert(v3);
			// myTree.treeInsert(v4);
			// myTree.treeInsert(v5);
			// myTree.treeInsert(v6);
			// myTree.treeInsert(v7);
			// myTree.treeInsert(v8);
			// myTree.treeInsert(v9);
			// myTree.treeInsert(v10);
			// myTree.treeInsert(v11);			
			// myTree.treeInsert(v12);
			// myTree.treeInsert(v13);
			 

			Visualizer tree = new Visualizer(myTree);
			tree.treeBuilder();
			tree.viewGraph();	
		}
		public static void printStats(AVLTree inTree) {
			for (int i=0; i<inTree.getVertices().size(); i++){
				BinaryTreeVertex printVertex = (BinaryTreeVertex)inTree.getVertices().get(i);
				System.out.println("root="+inTree.getRoot());
				System.out.println(printVertex+") left ="+printVertex.getLeftChild()+" right="+printVertex.getRightChild());
			}
		}
	}


