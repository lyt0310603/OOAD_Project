package project.mode;

import java.awt.Color;
import project.Canvas;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import project.Graph.BaseGraph;
import project.Graph.GroupGraph;

public class SelectMode extends BaseMode{

	public Boolean groupSelect = false;
	public BaseGraph singleSelectedGraph = null;
	public GroupGraph groupSelectedGraph = null;
	
	public SelectMode() {
		
	}

	public void pressed(MouseEvent e) {
		
		mouseStartLocation = e.getPoint();
		mouseEndLocation = e.getPoint();
		
		graphStatusReset();
		singleSelectedGraph = null;
		groupSelectedGraph = null;
		
		selectedGraphCheck(mouseStartLocation);
		if(singleSelectedGraph != null) {
			singleSelectedGraph.selected = true;					
			groupSelect = false;
		}
		else if(groupSelectedGraph != null) {
			groupSelectedGraph.setGroupSelected(true);
			groupSelect = false;
		}
		else {
			groupSelect = true;
		}
	}
	
	public void released(MouseEvent e) {
		mouseEndLocation = e.getPoint();
		groupSelect = false;
	}
	
	public void dragged(MouseEvent e) {
		mouseEndLocation = e.getPoint();
		if(!groupSelect) {
			if(singleSelectedGraph != null) {
				singleSelectedGraph.updateLocation(mouseEndLocation.x - mouseStartLocation.x, 
						mouseEndLocation.y - mouseStartLocation.y);
			}
			else if(groupSelectedGraph != null) {
				groupSelectedGraph.updateGroupLocation(mouseEndLocation.x - mouseStartLocation.x, 
						mouseEndLocation.y - mouseStartLocation.y);
			}
			mouseStartLocation = mouseEndLocation;
		}
		else
		{
			for(BaseGraph graph : Canvas.graphItems) {
				graph.areaSelectCheck(mouseStartLocation, mouseEndLocation);
			}
			for(GroupGraph groupgraph : Canvas.groupGraphItems) {
				groupgraph.groupAreaSelectCheck(mouseStartLocation, mouseEndLocation);
			}
		}
	}
	
	public void paint(Graphics g) {
		
		graphLineDraw(g);
		
		if(groupSelect) {
			
			groupSelectDraw(g);
		}
		
		
	}
	
	public void groupSelectDraw(Graphics g) {
		Color transparentGray = new Color(128, 128, 128, 128);
		g.setColor(transparentGray);
		g.fillRect(mouseStartLocation.x, mouseStartLocation.y, 
				mouseEndLocation.x - mouseStartLocation.x, mouseEndLocation.y - mouseStartLocation.y);
	}
	
	public void selectedGraphCheck(Point mouseLocation) {
		for(BaseGraph graph : Canvas.graphItems) {
			if(graph.clickPointCheck(mouseLocation.x, mouseLocation.y)) {
				singleSelectedGraph = graph;
			}
		}
		
		for(GroupGraph groupgraph : Canvas.groupGraphItems) {
			if(groupgraph.clickGroupPointCheck(mouseLocation.x, mouseLocation.y)) {
				groupSelectedGraph = groupgraph;
			}
		}
	}
}
