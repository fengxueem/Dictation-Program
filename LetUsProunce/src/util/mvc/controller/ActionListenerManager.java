package util.mvc.controller;

import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JTextField;

abstract public class ActionListenerManager implements ActionListener {
	// add/remove action listener to any subclass of AbstractButton,
	// like: JButton, JMenuItem, JRadioButton and JCheckBox
	public void addActionEvent(AbstractButton jbutton){
		jbutton.addActionListener(this);
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
}
