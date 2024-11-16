package project.Line;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import project.Graph.PortPoint;

public class AssLine extends BaseLine{
	
	public AssLine(PortPoint lineStartPort, PortPoint lineEndPort) {
		super("assline", lineStartPort, lineEndPort);
	}
	
	@Override
	public void drawLine(Graphics2D g) {
		
		this.endPort_x = endPort.center.x;
		this.endPort_y = endPort.center.y;
		this.startPort_y = startPort.center.y;
		this.startPort_x = startPort.center.x;
		
		this.slope = (double) (endPort_y - startPort_y) / (endPort_x - startPort_x);

		g.setColor(Color.black);
		g.drawLine(startPort_x, startPort_y, endPort_x, endPort_y);
		double lineLen = Math.sqrt(Math.pow(endPort_x - startPort_x, 2) + Math.pow(endPort_y - startPort_y, 2));
		

        // 繪製箭頭
        int arrowHeadSize = 10;
        if (lineLen < arrowHeadSize *2) {
        	arrowHeadSize = arrowHeadSize / 2;
        }
        int arrowHeadX1, arrowHeadY1, arrowHeadX2, arrowHeadY2;

        if (startPort_x < endPort_x) {
            arrowHeadX1 = (int) (endPort_x - arrowHeadSize * Math.cos(Math.atan(slope)) - arrowHeadSize * Math.sin(Math.atan(slope)));
            arrowHeadY1 = (int) (endPort_y - arrowHeadSize * Math.sin(Math.atan(slope)) + arrowHeadSize * Math.cos(Math.atan(slope)));
            arrowHeadX2 = (int) (endPort_x - arrowHeadSize * Math.cos(Math.atan(slope)) + arrowHeadSize * Math.sin(Math.atan(slope)));
            arrowHeadY2 = (int) (endPort_y - arrowHeadSize * Math.sin(Math.atan(slope)) - arrowHeadSize * Math.cos(Math.atan(slope)));
        } 
        else {
            arrowHeadX1 = (int) (endPort_x + arrowHeadSize * Math.cos(Math.atan(slope)) + arrowHeadSize * Math.sin(Math.atan(slope)));
            arrowHeadY1 = (int) (endPort_y + arrowHeadSize * Math.sin(Math.atan(slope)) - arrowHeadSize * Math.cos(Math.atan(slope)));
            arrowHeadX2 = (int) (endPort_x + arrowHeadSize * Math.cos(Math.atan(slope)) - arrowHeadSize * Math.sin(Math.atan(slope)));
            arrowHeadY2 = (int) (endPort_y + arrowHeadSize * Math.sin(Math.atan(slope)) + arrowHeadSize * Math.cos(Math.atan(slope)));
        }
        g.drawLine(endPort_x, endPort_y, arrowHeadX1, arrowHeadY1);
        g.drawLine(endPort_x, endPort_y, arrowHeadX2, arrowHeadY2);
	};
}
