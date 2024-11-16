package project.Graph;

import java.awt.Graphics2D;
import java.awt.Point;

public class PortPoint {
	public Point location = new Point();
	public Point center = new Point();
	
	public PortPoint(int x, int y) {
		this.location.setLocation(x, y);
		this.center.setLocation(x+5, y+5);
	}
	
	public void drawPort(Graphics2D g) {
		g.fillRect(this.location.x, this.location.y, 10, 10);
	}
	
	public void updateLocation(int moveX, int moveY) {
		this.location.x = this.location.x + moveX;
		this.location.y = this.location.y + moveY;
		this.center.x = this.center.x + moveX;
		this.center.y = this.center.y + moveY;
	}
}
