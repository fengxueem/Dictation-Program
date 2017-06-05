package controller;

import javax.swing.JPanel;

import util.mvc.controller.AbstractActionController;
import view.DictatePane;

public class DictatePaneController extends AbstractActionController {
	private DictatePane dictatePane;
	
	public DictatePaneController(DictatePane dictatePane) {
		this.dictatePane = dictatePane;
	}

	public JPanel getPane() {
		return dictatePane;
	}

	@Override
	protected void addActionEvents() {
		// TODO Auto-generated method stub
		
	}
}
