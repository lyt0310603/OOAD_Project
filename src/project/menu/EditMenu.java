package project.menu;

import java.util.Iterator;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.Canvas;
import project.Graph.BaseGraph;
import project.Graph.GroupGraph;

public class EditMenu extends JMenu{
	JPanel panel;
	public EditMenu(JPanel panel) {
		super("edit");
		
		this.panel = panel;
		
		JMenuItem groupOrder = new JMenuItem("group");
		JMenuItem ungroupOrder = new JMenuItem("ungroup");
		JMenuItem editOrder = new JMenuItem("edit");
		
		this.add(groupOrder);
		this.add(ungroupOrder);
		this.add(editOrder);
		
		groupOrder.addActionListener(e -> groupFunc());
		ungroupOrder.addActionListener(e -> ungroupFunc());
		editOrder.addActionListener(e -> editFunc());
	}	
	
	private void groupFunc() {
		GroupGraph group = new GroupGraph();
		
		int selectedGraphNum = 0;
		
		for(BaseGraph graph : Canvas.graphItems) {
			if(graph.selected) {
				selectedGraphNum += 1;
			}
		}
		
		for(GroupGraph groupgraph : Canvas.groupGraphItems) {
			if(groupgraph.selected) {
				selectedGraphNum += 1;
			}
		}
		
		if(selectedGraphNum > 1) {
			Iterator<BaseGraph> iterator = Canvas.graphItems.iterator();
			while(iterator.hasNext()) {
				BaseGraph graph = iterator.next();
				if(graph.selected) {
					group.singleGraphAdd(graph);
					iterator.remove();
				}
			}
			
			Iterator<GroupGraph> groupiterator = Canvas.groupGraphItems.iterator();
			while(groupiterator.hasNext()) {
				GroupGraph groupgraph = groupiterator.next();
				if(groupgraph.selected) {
					group.groupGraphAdd(groupgraph);
					groupiterator.remove();
				}
			}
			group.selected = true;
			Canvas.groupGraphItems.add(group);
		}
	}
	
	private void ungroupFunc() {
		Iterator<GroupGraph> groupiterator = Canvas.groupGraphItems.iterator();
		GroupGraph groupgraph = null;
		while(groupiterator.hasNext()) {
			groupgraph = groupiterator.next();
			if(groupgraph.selected) {
				groupiterator.remove();
				break;
			}			
		}
		if(groupgraph != null) {
			Canvas.graphItems.addAll(groupgraph.singlechildren);
			Canvas.groupGraphItems.addAll(groupgraph.groupchildren);
		}
	}
	
	private void editFunc() {
		for(BaseGraph graph : Canvas.graphItems) {
			 if(graph.selected) {
				 JTextField textField = new JTextField();
				 Object[] message = {"Enter text:", textField};
		         int option = JOptionPane.showOptionDialog(null, message, "Enter Text", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
		         if (option == JOptionPane.OK_OPTION) {
		        	 graph.setString(textField.getText());
					 this.panel.repaint();
		         }
			 }
		}
		
		for(GroupGraph groupgraph : Canvas.groupGraphItems) {
			if(groupgraph.selected) {
				 JTextField textField = new JTextField();
				 Object[] message = {"Enter text:", textField};
		         int option = JOptionPane.showOptionDialog(null, message, "Enter Text", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
		         if (option == JOptionPane.OK_OPTION) {
		        	 groupgraph.setString(textField.getText());
					 this.panel.repaint();
		         }
			}
		}
	}
}
