package edu.montana.csci;

import javax.swing.*;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.DirectedOrderedSparseMultigraph;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Paint;
import java.awt.Color;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.visualization.picking.PickedInfo;
/**
 *
 * @author barrionuevo
 */
public class Visualizer {
	
	private Forest<Vertex,Edge> forest = new DelegateForest<Vertex,Edge>(new DirectedOrderedSparseMultigraph<Vertex,Edge>());
    private Graph graph;
	
    public Visualizer(Graph inGraph) {
        this.graph=inGraph;
        treeBuilder();
        viewGraph();
    }
	
	private void treeBuilder () {
		if (graph instanceof BinaryTree)
			((BinaryTree) graph).updateEdges();		
				
		for (Vertex v : graph.getVertices()) {
			forest.addVertex(v);
		}
		
		for (Edge e :graph.getEdges() ) {
			forest.addEdge(e, e.getVertex1(), e.getVertex2());
		}
	}
	
	private Forest<Vertex, Edge> getForest() {
		return this.forest;
	}
    
    private void viewGraph() {
    	Layout<Vertex, Edge> layout = new TreeLayout<Vertex,Edge>(getForest());
    	BasicVisualizationServer<Vertex,Edge> bvs = new BasicVisualizationServer<Vertex, Edge>(layout);
    	bvs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Vertex>());
        if (graph instanceof RedBlackTree)
            bvs.getRenderContext().setVertexFillPaintTransformer(new VertexPaintTransformer(bvs.getPickedVertexState()));
        JFrame frame = new JFrame("Graph View");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().add(bvs);
    	frame.pack();
    	frame.setVisible(true);
    }

    private static class VertexPaintTransformer implements Transformer<Vertex,Paint> {

        // Data Fields
        private final PickedInfo<Vertex> pi;

        // Constructor

        VertexPaintTransformer ( PickedInfo<Vertex> pi ) {
            super();
            if (pi == null)
                throw new IllegalArgumentException("PickedInfo instance must be non-null");
            this.pi = pi;
        }

        // Methods
        @Override
        public Paint transform(Vertex v) {
            Color p = null;
            if (((RedBlackTreeVertex)v).isRed)
                p = Color.RED;
            else
                p =  Color.BLACK;
            return p;
        }
    }
}
