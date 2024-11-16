package project.button;

import project.Canvas;
import project.mode.SelectMode;

public class SelectButton extends BaseButton{
	public SelectButton() {
		super("select");
		mode = new SelectMode();
	}
}
