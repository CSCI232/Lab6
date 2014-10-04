package edu.montana.csci;

import javax.swing.*;

import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.DirectedOrderedSparseMultigraph;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
/**
 *
 * @author barrionuevo
 */
public class Visualizer {
	
	private Forest<Vertex,Edge> forest = new DelegateForest<Vertex,Edge>(new DirectedOrderedSparseMultigraph<Vertex,Edge>());   
    private Graph graph;
	
    public Visualizer(Graph inGraph) { 		
        this.graph=inGraph;
    }
	
	public void treeBuilder () {
		if (graph instanceof BinaryTree)
			((BinaryTree) graph).updateEdges();		
				
		for (Vertex v : graph.getVertices()) {
			forest.addVertex(v);
		}
		
		for (Edge e :graph.getEdges() ) {
			forest.addEdge(e, e.getVertex1(), e.getVertex2());
		}
	}
	
	public Forest<Vertex, Edge> getForest() {
		return this.forest;
	}
    
    public void viewGraph() {
    	Layout<Vertex, Edge> layout = new TreeLayout<Vertex,Edge>(getForest());
    	BasicVisualizationServer<Vertex,Edge> bvs = new BasicVisualizationServer<Vertex, Edge>(layout);
    	bvs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Vertex>());
    	JFrame frame = new JFrame("Graph View");    
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().add(bvs);
    	frame.pack();
    	frame.setVisible(true);
    }
 
}
