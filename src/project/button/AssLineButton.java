package project.button;

import project.Canvas;
import project.mode.AssLineMode;

public class AssLineButton extends BaseButton{
	public AssLineButton() {
		super("assline");
		mode = new AssLineMode();
	}
}
