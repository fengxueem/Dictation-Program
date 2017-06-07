package controller;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import model.DictationManager;
import util.mvc.controller.AbstractActionController;
import view.WordRepoPane;

public class WordRepoPaneController extends AbstractActionController {
	private WordRepoPane wordRepoPane;
	
	public WordRepoPaneController(WordRepoPane wordRepoPane) {
		this.wordRepoPane = wordRepoPane;
		addActionEvents();
	}

	public JPanel getPane() {
		return wordRepoPane;
	}
	
	public void updateList(DefaultListModel<String> listModel) {
		wordRepoPane.list.setModel(listModel);
	}
	
	public int[] getSelectedIndices() {
		return wordRepoPane.list.getSelectedIndices();
	}
	
	public void addWordsFromFiles(Object[] filePaths) {
		if (filePaths.length == 0) {
			// empty file paths 
			return;
		}
		getActionMessageHandlers(DictationManager.class).addWordsFromFiles(filePaths);
	}
	
	@Override
	protected void addActionEvents() {
		addActionEvent(wordRepoPane.btnAdd, "btnAdd", "add_file");
		addActionEvent(wordRepoPane.btnRemove, "btnRemove", "remove_file");
	}
}
