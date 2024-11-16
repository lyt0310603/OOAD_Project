package project.Graph;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class UsecaseGraph extends BaseGraph{
	
	public UsecaseGraph(Point mouseLocation) {
		super("usecasegraph", mouseLocation, 80, 50);
	}
	
	@Override
	public void drawGraph(Graphics2D g) {
		g.setColor(Color.GRAY);
		g.fillOval(this.location.x, this.location.y, this.width, this.height);
		g.setColor(Color.BLACK);
		g.drawOval(this.location.x, this.location.y, this.width, this.height);
		
		if(this.selected) {
			this.drawPorts(g);
		}
		
		if(this.text != null) {
			g.drawString(this.text, this.location.x, this.location.y);
		}
	}
	
//	待修改
	@Override
	public Boolean clickPointCheck(int x, int y) {
		return x > this.location.x && y > this.location.y && x < this.location.x + this.width && y < this.location.y + this.height;
	}
}

