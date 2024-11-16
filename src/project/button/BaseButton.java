package project.button;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import project.Canvas;
import project.mode.BaseMode;

public abstract class BaseButton extends JButton{
	String name;
	BaseMode mode = null;
	public BaseButton(String name){
		this.name = name;
		
//		Load Icon and change it size to fit button
		ImageIcon icon = new ImageIcon("src/image/"+ name +"_button.png");
		Image img = icon.getImage();
		this.setSize(30, 30);	
		img = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);		
		this.setIcon(new ImageIcon(img));		
		
		this.setBackground(Color.WHITE);
		this.addActionListener(e -> onClick());
	}
	
	
    private void onClick () {    	
//    	change the button color 
		this.setBackground(Color.GRAY);
		Canvas.mode = mode;
//		change else buttons color
		for(Component c : this.getParent().getComponents()) {
			if(c != this) {
				c.setBackground(Color.WHITE);
			}			
		}
    }
	
}
