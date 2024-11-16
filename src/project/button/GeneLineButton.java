package project.button;

import project.Canvas;
import project.mode.GeneLineMode;

public class GeneLineButton extends BaseButton{
	public GeneLineButton() {
		super("geneline");
		mode = new GeneLineMode();
	}
}
