package project.mode;

import project.Canvas;
import project.Line.AssLine;

public class AssLineMode extends LineMode{

	public AssLineMode() {
		
	}
	
	public void saveItem() {
		Canvas.lineItems.add(new AssLine(lineStartPort, lineEndPort));
	}
}
