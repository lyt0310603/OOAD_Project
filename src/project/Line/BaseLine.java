package project.Line;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import project.Graph.PortPoint;

public class BaseLine {
	String name;
	PortPoint startPort;
	PortPoint endPort;
	int endPort_x;
	int endPort_y;
	int startPort_y;
	int startPort_x;
	double slope;
	
	public BaseLine(String name, PortPoint lineStartPort, PortPoint lineEndPort) {
		this.name = name;
		this.startPort = lineStartPort;
		this.endPort = lineEndPort;
	}
	
	public void drawLine(Graphics2D g) {};
}
