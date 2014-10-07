package edu.montana.csci;

/**
 * Created by Barrionuevo on 10/5/14.
 */

/** Class to represent a Red-Black node. */
public class RedBlackTreeVertex extends BinaryTreeVertex {
    //Additional data members
    /** Color indicator. True if red, false if black. */
    protected boolean isRed;

    //Constructor
    /** Create a RedBlackTreeVertex if the default color of red
     *  and the given data field
     *  @param item The data field
     */
    public RedBlackTreeVertex(Object item) {
        super(item);
        isRed = true;
    }
}

