package util.mvc.controller;

import javax.swing.JPanel;

public abstract class AbstractServiceController extends AbstractController{
	protected abstract void setPanel(JPanel jPanel);
	
	public AbstractServiceController(JPanel jPanel) {
		setPanel(jPanel);
		addActionEvents();
	}
}
