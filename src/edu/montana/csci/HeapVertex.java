package edu.montana.csci;

public class HeapVertex extends BinaryTreeVertex {
	
	private int heapIndex;
	
	public HeapVertex(int val) {
		super(val);		
	}

	public int getHeapIndex() {
		return heapIndex;
	}

	public void setHeapIndex(int heapIndex) {
		this.heapIndex = heapIndex;
	}
	
	public String toString() {
		return"("+heapIndex+")"+getValue();
	}
	
}
