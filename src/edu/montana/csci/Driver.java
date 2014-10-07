package edu.montana.csci;

public class Driver {
	
		public static void main(String[] args) {
            RedBlackTree myTree = createTree("1 2 3 4 5 7 8 9 10 12 13 14 15");
			Visualizer viewTree = new Visualizer(myTree);
            viewTree.treeBuilder();
            viewTree.viewGraph();
		}

        public  static RedBlackTree createTree(String str){
            String[] words = str.split(" ");
            RedBlackTree RBTree = new RedBlackTree();
            for (int i=0; i< words.length; i++)
                RBTree.add(words[i]);
            return RBTree;
        }


	}


