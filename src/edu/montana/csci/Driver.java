package edu.montana.csci;

public class Driver {
	
		public static void main(String[] args) {

            RedBlackTree myTree = new RedBlackTree();

//            for (int i = 1; i<=11; i++)
//                myTree.add(i);

            myTree.add(10);
            myTree.add(5);
            myTree.add(8);
            myTree.add(13);
            myTree.add(2);
            myTree.add(1);
            myTree.add(9);
            myTree.add(14);
            myTree.add(15);
            myTree.add(11);
            myTree.add(3);


            Visualizer viewTree = new Visualizer(myTree);
            viewTree.treeBuilder();
            viewTree.viewGraph();
		}


	}


