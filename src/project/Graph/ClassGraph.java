package project.Graph;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class ClassGraph extends BaseGraph{
	
	public ClassGraph(Point mouseLocation) {
		super("classgraph", mouseLocation, 80, 70);
	}
	
	@Override
	public void drawGraph(Graphics2D g) {
		
		g.setColor(Color.GRAY);
		g.fillRect(this.location.x, this.location.y, this.width, this.height);
		g.setColor(Color.BLACK);
		g.drawRect(this.location.x, this.location.y, this.width, this.height);
		g.drawLine(this.location.x, this.location.y + (int)(this.height * 1/3), this.location.x + this.width, this.location.y + (int)(this.height * 1/3));
		g.drawLine(this.location.x, this.location.y + (int)(this.height * 2/3), this.location.x + this.width, this.location.y + (int)(this.height * 2/3));
		
		if(this.selected) {
			this.drawPorts(g);
		}
		
		if(this.text != null) {
			g.drawString(this.text, this.location.x, this.location.y);
		}
	}
	
	@Override
	public Boolean clickPointCheck(int x, int y) {
		return x > this.location.x && y > this.location.y && x < this.location.x + this.width && y < this.location.y + this.height;
	}
	
}
