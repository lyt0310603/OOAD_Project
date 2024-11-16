package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import project.button.AssLineButton;
import project.button.BaseButton;
import project.button.ClassButton;
import project.button.ComLineButton;
import project.button.GeneLineButton;
import project.button.SelectButton;
import project.button.UsecaseButton;
import project.menu.EditMenu;

public class main_panel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new main_panel();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main_panel() {
		f=new JFrame("OOAD Project");
	    f.setBounds(1000,250,700,500); 
	    f.setVisible(true); 
	    Container cp=f.getContentPane();
	    
//	    Create Canvas
	    JPanel canva = new Canvas();
	    cp.add(canva);
	    
//	    create a ArrayList with button 
	    ArrayList <BaseButton> buttonList = new ArrayList<BaseButton>();
	    buttonList.add(new SelectButton());
	    buttonList.add(new AssLineButton());
	    buttonList.add(new GeneLineButton());
	    buttonList.add(new ComLineButton());
	    buttonList.add(new ClassButton());
	    buttonList.add(new UsecaseButton());
	    
//	    create a JPanel as a side bar with button 
	    JPanel sideBar = new JPanel();
	    sideBar.setBounds(0, 40, 50, 240);
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        for(int i=0; i<buttonList.size(); i++) {
        	sideBar.add(buttonList.get(i));
        }
	    cp.add(sideBar);
	    
//	    create a JPanel as a top bar with file and edit
//	    UNFINISH
	    JMenuBar menuBar = new JMenuBar();
	    
	    JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new EditMenu(canva);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
	    f.setJMenuBar(menuBar);
	    

	}

}
