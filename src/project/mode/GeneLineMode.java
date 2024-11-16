package project.mode;
import project.Canvas;
import project.Line.GeneLine;

public class GeneLineMode extends LineMode{

	public GeneLineMode() {
		
	}
	
	public void saveItem() {
		Canvas.lineItems.add(new GeneLine(lineStartPort, lineEndPort));
	}
}
