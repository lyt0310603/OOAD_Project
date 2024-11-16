package project.mode;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public abstract class GraphMode extends BaseMode{
	
	public GraphMode() {
		
	}
	
	public void pressed(MouseEvent e) {
		mouseStartLocation = e.getPoint();
		mouseEndLocation = e.getPoint();
		
		graphStatusReset();
		
	}
	
	public void released(MouseEvent e) {
		mouseEndLocation = e.getPoint();
		saveItem();
	}
	
	public void dragged(MouseEvent e) {
		mouseEndLocation = e.getPoint();
	}
	
	public void paint(Graphics g) {
		graphLineDraw(g);
	}
	
	public abstract void saveItem();
}
