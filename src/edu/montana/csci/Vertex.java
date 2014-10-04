package edu.montana.csci;

/**
 *
 * @author barrionuevo
 */
public class Vertex {
    protected int vertexVal;
    
    public Vertex(int val) {
        this.vertexVal = val;
    }  
    public Vertex(){
        
    }

    public int getValue() { 
            return vertexVal; 
    }
    
    public void setValue(int val) { 
        this.vertexVal=val; 
    }
    
    public String toString()
    {    	
    	return (""+getValue());
    }
    
    
}