package project.mode;

import project.Canvas;
import project.Line.ComLine;

public class ComLineMode extends LineMode{

	public ComLineMode() {
		
	}
	
	public void saveItem() {
		Canvas.lineItems.add(new ComLine(lineStartPort, lineEndPort));
	}
}
