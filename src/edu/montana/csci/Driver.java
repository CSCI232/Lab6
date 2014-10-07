package edu.montana.csci;

public class Driver {
	
		public static void main(String[] args) {
            RedBlackTree myTree = createTree("The quick brown fox jumps over the lazy dog");
			Visualizer tree = new Visualizer(myTree);
		}

        public  static RedBlackTree createTree(String str){
            String[] words = str.split(" ");
            RedBlackTree RBTree = new RedBlackTree();
            for (int i=0; i< words.length; i++)
                RBTree.add(words[i]);
            return RBTree;
        }


	}


