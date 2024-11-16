package project.mode;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import project.Canvas;
import project.Graph.BaseGraph;
import project.Graph.GroupGraph;
import project.Line.BaseLine;

public abstract class  BaseMode {
	
	public Point mouseStartLocation;
	public Point mouseEndLocation;
	
	public BaseMode() {
		
	}
	
	public void graphStatusReset() {
		for(BaseGraph graph : Canvas.graphItems) {
			graph.selected = false;
		}
		for(GroupGraph groupgraph : Canvas.groupGraphItems) {
			groupgraph.setGroupSelected(false);
		}
	}
	
	public void graphLineDraw(Graphics g) {
		for(BaseLine line : Canvas.lineItems) {
			line.drawLine((Graphics2D) g);
		}

		for(BaseGraph graph : Canvas.graphItems) {
			graph.drawGraph((Graphics2D) g);
		}
		
		for(GroupGraph groupgraph : Canvas.groupGraphItems) {
			groupgraph.drawGroupGraph((Graphics2D) g);
		}
	}
	
	public abstract void pressed(MouseEvent e);
	public abstract void released(MouseEvent e);
	public abstract void dragged(MouseEvent e);
	public abstract void paint(Graphics g);
}
