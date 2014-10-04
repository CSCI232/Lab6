
package edu.montana.csci;

/**
 *
 * @author barrionuevo
 */
public class Edge {
    private int edgeVal;
    private int edgeLabel;
    private Vertex v1;
    private Vertex v2;    
    
    public Edge(Vertex u1, Vertex u2) {
        v1 = u1;
        v2 = u2;        
    }
    
    public Vertex getVertex1() {
        return v1;
    }
    
    public Vertex getVertex2() {
        return v2;
    }
    
    public void setValue (int val) {
        edgeVal = val;
    }
    
    public int getValue () {
        return edgeVal;
    }
    
    public void setEdgeLabel(int label) {
    	this.edgeLabel=label;    	
    }
    
    public int getEdgeLabel() {
    	return edgeLabel;
    }
    
    public String toString() {
    	return edgeLabel + "";
    }       
}