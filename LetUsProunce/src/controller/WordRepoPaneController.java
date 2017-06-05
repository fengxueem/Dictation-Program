package controller;

import javax.swing.JPanel;

import util.mvc.controller.AbstractActionController;
import view.WordRepoPane;

public class WordRepoPaneController extends AbstractActionController {
	private WordRepoPane wordRepoPane;
	
	public WordRepoPaneController(WordRepoPane wordRepoPane) {
		this.wordRepoPane = wordRepoPane;
	}

	public JPanel getPane() {
		return wordRepoPane;
	}

	@Override
	protected void addActionEvents() {
		// TODO Auto-generated method stub
		
	}

}
