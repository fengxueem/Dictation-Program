package util.mvc.controller;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;

import javax.swing.AbstractButton;
import javax.swing.JTextField;

abstract public class EventListenerManager implements ActionListener, MouseListener, MouseWheelListener {
	// add/remove action listener to any subclass of AbstractButton,
	// like: JButton, JMenuItem, JRadioButton and JCheckBox
	public void addActionEvent(AbstractButton jbutton, String componentName){
		addActionEvent(jbutton, componentName, "null");
	}
	
	public void addActionEvent(AbstractButton jbutton, String componentName, String command){
		jbutton.addActionListener(this);
		jbutton.setName(componentName);
		jbutton.setActionCommand(command);
	}
	
	public void removeActionEvent(AbstractButton jbutton){
		jbutton.removeActionListener(this);
	}
	
	// add/remove action listener to JTextField
	public void addActionEvent(JTextField jtextField){
		jtextField.addActionListener(this);
	}

	public void addActionEvent(JTextField jtextField, String componentName, String command){
		jtextField.addActionListener(this);
		jtextField.setName(componentName);
		jtextField.setActionCommand(command);
	}

	public void removeActionEvent(JTextField jtextField){
		jtextField.removeActionListener(this);
	}
	
	// add/remove mouse and mouse wheel listener to any subclasses of java.awt.Component
	public void addMouseEvent(Component component){
		component.addMouseListener(this);
		component.addMouseWheelListener(this);
	}
	
	// Compared with an action event, mouse event cannot take a command.
	public void addActionEvent(Component component, String componentName){
		component.addMouseListener(this);
		component.addMouseWheelListener(this);
		component.setName(componentName);
	}

	public void removeActionEvent(Component component){
		component.removeMouseListener(this);
		component.removeMouseWheelListener(this);
	}
}
