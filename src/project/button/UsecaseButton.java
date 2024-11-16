package project.button;

import project.Canvas;
import project.mode.UsecaseGraphMode;

public class UsecaseButton extends BaseButton{
	public UsecaseButton() {
		super("usecasegraph");
		mode = new UsecaseGraphMode();
	}
	
}
