package project.button;

import project.Canvas;
import project.mode.ClassGraphMode;

public class ClassButton extends BaseButton{
	public ClassButton() {
		super("classgraph");
		mode = new ClassGraphMode();
	}
}
