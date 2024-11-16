package project.Graph;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class GroupGraph {
	public ArrayList<GroupGraph> groupchildren = new ArrayList<GroupGraph>();
	public ArrayList<BaseGraph> singlechildren = new ArrayList<BaseGraph>();
	public Boolean selected = false;
	String text = null;
	
	public void singleGraphAdd(BaseGraph graph) {
		singlechildren.add(graph);
	}
	
	public void groupGraphAdd(GroupGraph groupgraph) {
		groupchildren.add(groupgraph);
	}
	
	public Boolean groupAreaSelectCheck(Point mouseStartLocation, Point mouseEndLocation) {
		Boolean groupselected = true;
		for(BaseGraph graph : singlechildren) {
			graph.areaSelectCheck(mouseStartLocation, mouseEndLocation);
			groupselected = groupselected && graph.selected;
		}
		
		for(GroupGraph groupgraph : groupchildren) {
			groupselected = groupselected && groupgraph.groupAreaSelectCheck(mouseStartLocation, mouseEndLocation);
		}
		
		this.setGroupSelected(groupselected);
		this.selected = groupselected;
		return groupselected;
	}
	
	public void setGroupSelected(Boolean f) {
		for(BaseGraph graph : singlechildren) {
			graph.selected = f;
		}
		
		for(GroupGraph groupgraph: groupchildren) {
			groupgraph.setGroupSelected(f);
		}
	}
	
	public void updateGroupLocation(int moveX, int moveY) {
		for(BaseGraph graph : singlechildren) {
			graph.updateLocation(moveX, moveY);
		}
		for(GroupGraph groupgraph : groupchildren) {
			groupgraph.updateGroupLocation(moveX, moveY);
		}
	}
	
	public void drawGroupGraph(Graphics2D g) {
		for(BaseGraph graph : singlechildren) {
			graph.drawGraph(g);
		}
		
		for(GroupGraph groupgraph: groupchildren) {
			groupgraph.drawGroupGraph(g);
		}
		this.drawGroupName(g);
	}
	
	public Boolean clickGroupPointCheck(int x, int y) {
		Boolean flag = false;
		for(BaseGraph graph : singlechildren) {
			flag = flag || graph.clickPointCheck(x, y);
		}
		for(GroupGraph groupgraph : groupchildren) {
			flag = flag || groupgraph.clickGroupPointCheck(x, y);
		}
		this.selected = flag;
		return flag;
	}
	
	public void setString(String s) {
		this.text = s;
	}
	
	public void drawGroupName(Graphics2D g) {
		if(this.text != null) {
			Point corner = this.groupUpperLeftCorner(Integer.MAX_VALUE, Integer.MAX_VALUE);			
			g.drawString(this.text, corner.x, corner.y);
		}
	}
	
	private Point groupUpperLeftCorner(int x, int y) {
		Point corner = new Point();
		corner.setLocation(x, y);
		
		for(BaseGraph graph : singlechildren) {
			if(graph.location.x < corner.x) {
				corner.x = graph.location.x;
			}
			if(graph.location.y < corner.y) {
				corner.y = graph.location.y;
			}
		}
		
		for(GroupGraph groupgraph : groupchildren) {
			corner = groupgraph.groupUpperLeftCorner(corner.x, corner.y);
		}
		return corner;
	}

}