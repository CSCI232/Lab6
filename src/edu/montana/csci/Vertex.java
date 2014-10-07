package edu.montana.csci;

/**
 *
 * @author barrionuevo
 */

public class Vertex {
    // Data Fields
    /** The information stored in this vertex. */
    protected Object data;

    // Constructors
    /** Create a vertex with the given data field.
     *  @param data The data field
     */
    public Vertex(Object data) {
        this.data = data;
    }
    /** Create a vertex with a empty data field. */
    public Vertex( ) {
        this.data = null;
    }

    // Methods
    /** Return a string representation of the vertex.
     *  @return String representation of the data fields
     */
    @Override
    public String toString() {
        return data.toString();
    }
    
    
}