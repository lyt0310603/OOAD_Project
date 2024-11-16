package project.mode;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import project.Canvas;
import project.Graph.BaseGraph;
import project.Graph.PortPoint;

public abstract class LineMode extends BaseMode{
	
	public BaseGraph lineStartGraph = null;
	public BaseGraph lineEndGraph = null;
	public PortPoint lineStartPort = null;
	public PortPoint lineEndPort = null;
	
	public Boolean testLineFlag = true;
	
	public LineMode() {
		
	}
	
	public void pressed(MouseEvent e) {
		mouseStartLocation = e.getPoint();
		mouseEndLocation = e.getPoint();
		
		graphStatusReset();
		
		testLineFlag = true;
		lineStartGraph = null;
		lineEndGraph = null;
		lineStartPort = null;
		lineEndPort = null;
		
		lineStartGraph = linkGraphCheck(mouseStartLocation);
	}
	
	public void released(MouseEvent e) {
		testLineFlag = false;
		mouseEndLocation = e.getPoint();
		
		if(lineStartGraph != null && lineEndGraph != null && lineStartGraph != lineEndGraph) {
			saveItem();
		}		
	}
	
	public void dragged(MouseEvent e) {
		mouseEndLocation = e.getPoint();
		lineEndGraph = linkGraphCheck(mouseEndLocation);
	}
	
	public void paint(Graphics g) {
		graphLineDraw(g);
		
		if(testLineFlag) {
			testLineDraw(g);
		}		
	}
	
	public void testLineDraw(Graphics g) {
		if(lineStartGraph != null) {
			lineStartPort = lineStartGraph.nearestPort(mouseEndLocation.x, mouseEndLocation.y);
//				if line's end doesn't in any graph then it will draw with mouse dragged
			if(lineEndGraph != null) {
				lineEndPort = lineEndGraph.nearestPort(lineStartPort.center.x, lineStartPort.center.y);	
				g.drawLine(lineStartPort.center.x, lineStartPort.center.y, lineEndPort.center.x, lineEndPort.center.y);
			}				
			else {
				g.drawLine(lineStartPort.center.x, lineStartPort.center.y, mouseEndLocation.x, mouseEndLocation.y);
				lineEndPort = null;
			}				
		}
	}
	
	private BaseGraph linkGraphCheck(Point mouseLocation) {
		BaseGraph linkGraph = null;
		for(BaseGraph graph : Canvas.graphItems) {
			if(graph.clickPointCheck(mouseLocation.x, mouseLocation.y)) {
				linkGraph = graph;
			}
		}
		return linkGraph;
	}
	
	public abstract void saveItem();
}
