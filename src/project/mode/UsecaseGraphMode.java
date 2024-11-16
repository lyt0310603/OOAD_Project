package project.mode;

import project.Canvas;
import project.Graph.UsecaseGraph;

public class UsecaseGraphMode extends GraphMode{

	public UsecaseGraphMode() {
		
	}
	
	public void saveItem() {
		Canvas.graphItems.add(new UsecaseGraph(mouseStartLocation));
	}
}