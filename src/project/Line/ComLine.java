package project.Line;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import project.Graph.PortPoint;

public class ComLine extends BaseLine{
	public ComLine(PortPoint lineStartPort, PortPoint lineEndPort) {
		super("comline", lineStartPort, lineEndPort);
	}
	
	@Override
	public void drawLine(Graphics2D g) {
		
		this.endPort_x = endPort.center.x;
		this.endPort_y = endPort.center.y;
		this.startPort_y = startPort.center.y;
		this.startPort_x = startPort.center.x;
		
		this.slope = (double) (endPort_y - startPort_y) / (endPort_x - startPort_x);
		
		g.setColor(Color.black);        

        // 繪製箭頭
        int DiamondSize = 7;
        int DiamondX1, DiamondY1, DiamondX2, DiamondY2;
        double lineLen = Math.sqrt(Math.pow(endPort_x - startPort_x, 2) + Math.pow(endPort_y - startPort_y, 2));
        
        if(lineLen < DiamondSize * 2) {
        	DiamondSize = DiamondSize / 2;
        }
        if (startPort_x < endPort_x) {
            DiamondX1 = (int) (endPort_x - DiamondSize * Math.cos(Math.atan(slope)) - DiamondSize * Math.sin(Math.atan(slope)));
            DiamondY1 = (int) (endPort_y - DiamondSize * Math.sin(Math.atan(slope)) + DiamondSize * Math.cos(Math.atan(slope)));
            DiamondX2 = (int) (endPort_x - DiamondSize * Math.cos(Math.atan(slope)) + DiamondSize * Math.sin(Math.atan(slope)));
            DiamondY2 = (int) (endPort_y - DiamondSize * Math.sin(Math.atan(slope)) - DiamondSize * Math.cos(Math.atan(slope)));
        } 
        else {
            DiamondX1 = (int) (endPort_x + DiamondSize * Math.cos(Math.atan(slope)) + DiamondSize * Math.sin(Math.atan(slope)));
            DiamondY1 = (int) (endPort_y + DiamondSize * Math.sin(Math.atan(slope)) - DiamondSize * Math.cos(Math.atan(slope)));
            DiamondX2 = (int) (endPort_x + DiamondSize * Math.cos(Math.atan(slope)) - DiamondSize * Math.sin(Math.atan(slope)));
            DiamondY2 = (int) (endPort_y + DiamondSize * Math.sin(Math.atan(slope)) + DiamondSize * Math.cos(Math.atan(slope)));
        }
        
        
        double diagonalLen = Math.sqrt(2) * Math.sqrt(Math.pow(DiamondX1-endPort_x, 2)+Math.pow(DiamondY1-endPort_y, 2));
        
        int lineEndX = (int) (startPort_x*(diagonalLen/(diagonalLen+lineLen)) + endPort_x*(lineLen/(diagonalLen+lineLen)));
        int lineEndY = (int) (startPort_y*(diagonalLen/(diagonalLen+lineLen)) + endPort_y*(lineLen/(diagonalLen+lineLen)));

		g.drawLine(startPort_x, startPort_y, lineEndX, lineEndY);
        int[] xPoints = {lineEndX, DiamondX1, endPort_x, DiamondX2};
        int[] yPoints = {lineEndY, DiamondY1, endPort_y, DiamondY2};
        g.drawPolygon(xPoints, yPoints, 4);
	};
}
