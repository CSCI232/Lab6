package edu.montana.csci;

import java.util.ArrayList;

public class Heap extends BinaryTree {
		
	public Heap(ArrayList<Integer> listOfIntegers) {	
		for (Integer value:listOfIntegers) {
			addVertex(new HeapVertex(value));
		}
		
		buildHeap(listOfIntegers.size());
		
		for (int a=0; a < getVertices().size(); a++) {
			if ((a<<1) + 1 < getVertices().size()) {
				((BinaryTreeVertex) getVertices().get(a)).setLeftChild((BinaryTreeVertex) getVertices().get((a<<1) + 1));
			}
			if ((a<<1) +2 < getVertices().size()) {
				((BinaryTreeVertex) getVertices().get(a)).setRightChild((BinaryTreeVertex) getVertices().get((a<<1) + 2));
			}
			((HeapVertex) getVertices().get(a)).setHeapIndex(a);
		}
		setRoot((BinaryTreeVertex) getVertices().get(0));			
	}

	public void heapify(int parent, int n) {
		int left, right, imax=0;
		while (true) {
			left=(imax<<1)+1;
			right = left +1;
			if ((left<n) && (getVertices().get(left).getValue() > getVertices().get(parent).getValue())) imax = left;
			else imax = parent;
			if ((right<n) && (getVertices().get(right).getValue()>getVertices().get(imax).getValue())) imax=right;
			if (imax!= parent) {
				swap(parent,imax);
				parent = imax;
			}
			else break;
		}
	
	}
	
	public void swap(int i, int j) {
		HeapVertex temp = (HeapVertex) getVertices().get(i);
		getVertices().set(i, getVertices().get(j));
		getVertices().set(j, temp);
	}
	
	public void buildHeap(int n) {
		for (int i=(n>>1)-1; i>=0; i--)
			heapify(i,n);
	}
	
	public void heapSort() {
		int n = getVertices().size();
		buildHeap(n);
		for (int t=n-1; t>0; t--) {
			swap(0,t);
			heapify(0,t);
		}
	}
}
