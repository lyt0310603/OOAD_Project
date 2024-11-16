package project.Line;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import project.Graph.PortPoint;

public class GeneLine extends BaseLine{
	public GeneLine(PortPoint lineStartPort, PortPoint lineEndPort) {
		super("geneline", lineStartPort, lineEndPort);
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
		
		// 计算三角形的顶点坐标
        int[] triangleX = new int[3];
        int[] triangleY = new int[3];
        int arrowHeadSize = 10; // 三角形的大小

        double angle = Math.atan(slope);
        triangleX[0] = endPort_x;
        triangleY[0] = endPort_y;
        if (startPort_x < endPort_x) {
        	triangleX[1] = (int) (endPort_x - arrowHeadSize * Math.cos(angle - Math.PI / 6));
        	triangleY[1] = (int) (endPort_y - arrowHeadSize * Math.sin(angle - Math.PI / 6));
        	triangleX[2] = (int) (endPort_x - arrowHeadSize * Math.cos(angle + Math.PI / 6));
        	triangleY[2] = (int) (endPort_y - arrowHeadSize * Math.sin(angle + Math.PI / 6));
        }
        else {
        	triangleX[1] = (int) (endPort_x + arrowHeadSize * Math.cos(angle + Math.PI / 6));
        	triangleY[1] = (int) (endPort_y + arrowHeadSize * Math.sin(angle + Math.PI / 6));
        	triangleX[2] = (int) (endPort_x + arrowHeadSize * Math.cos(angle - Math.PI / 6));
        	triangleY[2] = (int) (endPort_y + arrowHeadSize * Math.sin(angle - Math.PI / 6));
        }


        // 绘制三角形
        g.setColor(Color.white);
        g.fillPolygon(triangleX, triangleY, 3);
        g.setColor(Color.black);
        g.drawPolygon(triangleX, triangleY, 3);
        
	};
}
