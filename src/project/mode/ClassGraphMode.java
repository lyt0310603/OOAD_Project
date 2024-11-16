package project.mode;

import project.Canvas;
import project.Graph.ClassGraph;

public class ClassGraphMode extends GraphMode{

	public ClassGraphMode() {
		
	}
	
	public void saveItem() {
		Canvas.graphItems.add(new ClassGraph(mouseStartLocation));
	}
}
