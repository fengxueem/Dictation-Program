package util.mvc.controller;

import javax.swing.JFrame;

public abstract class AbstractManagerController extends AbstractController{
	// set pre-defined methods for manager controller
	protected abstract void start(); 
	protected abstract void linkViewsWithController(JFrame jFrame);
	protected abstract void linkModelsWithController();
	
	public AbstractManagerController(JFrame jFrame) {
		linkViewsWithController(jFrame);
		linkModelsWithController();
		addActionEvents();
	}
}
