package project.Graph;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public abstract class BaseGraph {
	String name;
	String text = null;
	public Point location;
	public Boolean selected = false;
	ArrayList<PortPoint> ports = new ArrayList<PortPoint>();
	public int width;
	public int height;
	
	public BaseGraph(String name, Point mouseLocation, int width, int height) {
		this.name = name;
		this.location = mouseLocation;
		this.width = width;
		this.height = height;
		addPorts();
	}
	
	private void addPorts() {
		ports.add(new PortPoint(location.x + (width/2 - 5), location.y - 10));
		ports.add(new PortPoint(location.x - 10, location.y + (height/2 - 5)));
		ports.add(new PortPoint(location.x + width, location.y + (height/2 - 5)));
		ports.add(new PortPoint(location.x + (width/2 - 5), location.y + height));
	}
	
	public void updateLocation(int moveX, int moveY) {		
//		update ports' location
		for(int i=0; i<ports.size(); i++) {
			ports.get(i).updateLocation(moveX, moveY);
		}
		
//		update graph's location
		this.location.x = this.location.x + moveX;
		this.location.y = this.location.y + moveY;
	}
	
	public PortPoint nearestPort(int x, int y) {
		double mindist = Double.MAX_VALUE;
		double dist;
		int minIdx = 0;
		for(int i=0; i<this.ports.size(); i++) {
			dist = Math.pow(this.ports.get(i).location.x - x, 2) + Math.pow(this.ports.get(i).location.y - y, 2);
			if(dist < mindist) {
				minIdx = i;
				mindist = dist;
			}
		}
		return this.ports.get(minIdx);
	}
	
	public void areaSelectCheck(Point mouseStartLocation, Point mouseEndLocation) {
		
		int startX = Math.min(mouseStartLocation.x, mouseEndLocation.x);
		int startY = Math.min(mouseStartLocation.y, mouseEndLocation.y);
		int endX = Math.max(mouseStartLocation.x, mouseEndLocation.x);
		int endY = Math.max(mouseStartLocation.y, mouseEndLocation.y);
		
		Boolean check = location.x < endX && location.y < endY && 
				location.x > startX && location.y > startY &&
				location.x+width < endX && location.y+height < endY &&
				location.x+width > startX && location.y+height > startY;
				
		if(check) {
			this.selected = true;
		}
		else {
			this.selected = false;
		}
	}
	
	public void drawPorts(Graphics2D g) {
		for(PortPoint port : ports) {
			port.drawPort(g);
		}
	}
	
	public void setString(String s) {
		this.text = s;
	}
	
	public abstract void drawGraph(Graphics2D g);	
	public abstract Boolean clickPointCheck(int x, int y);
}
