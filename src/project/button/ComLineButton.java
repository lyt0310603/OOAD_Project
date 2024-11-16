package project.button;

import project.Canvas;
import project.mode.ComLineMode;

public class ComLineButton extends BaseButton{
	public ComLineButton() {
		super("comline");
		mode = new ComLineMode();
	}
}
