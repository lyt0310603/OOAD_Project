package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

import project.Graph.BaseGraph;
import project.Graph.ClassGraph;
import project.Graph.GroupGraph;
import project.Graph.PortPoint;
import project.Graph.UsecaseGraph;
import project.Line.AssLine;
import project.Line.BaseLine;
import project.Line.ComLine;
import project.Line.GeneLine;
import project.mode.BaseMode;
import project.mode.SelectMode;

public class Canvas extends JPanel{
//	the UML mode now
	public static BaseMode mode = new SelectMode();
	
//	save Items
	public static ArrayList<BaseGraph> graphItems = new ArrayList<BaseGraph>();
	public static ArrayList<GroupGraph> groupGraphItems = new ArrayList<GroupGraph>();
	public static ArrayList<BaseLine> lineItems = new ArrayList<BaseLine>();	
	
	
	public Canvas() {
		this.setBounds(120, 20, 520, 370);
		this.setBackground(Color.WHITE);
		
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {                
				
				mode.pressed(e);
				repaint();
            }
			
			@Override
            public void mouseReleased(MouseEvent e) {
				
				mode.released(e);
				repaint();
            }			
		});	
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
            public void mouseDragged(MouseEvent e) {
				mode.dragged(e);
				
                repaint();
            }
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		mode.paint(g);
	}
}
