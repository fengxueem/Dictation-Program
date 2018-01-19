package controller;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import model.DictationManager;
import model.FileSelector;
import util.mvc.controller.AbstractServiceController;
import view.WordRepoPane;

public class WordRepoPaneController extends AbstractServiceController {
	private WordRepoPane wordRepoPane;
	private DictationManager dictationManager;
	private FileSelector fileSelector;
	
	// Constructor
	public WordRepoPaneController(WordRepoPane wordRepoPane) {
		super(wordRepoPane);
	}
	
	// getters and setters
	public DictationManager getDictationManager() {
		return dictationManager;
	}

	public void setDictationManager(DictationManager dictationManager) {
		this.dictationManager = dictationManager;
	}
	
	public FileSelector getFileSelector() {
		return fileSelector;
	}

	public void setFileSelector(FileSelector fileSelector) {
		this.fileSelector = fileSelector;
	}

	public JPanel getPane() {
		return wordRepoPane;
	}
	
	// functioning methods
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
		dictationManager.addWordsFromFiles(filePaths);
	}
	
	@Override
	protected void showView(boolean isToShow) {
		wordRepoPane.setVisible(isToShow);
		if (isToShow) {
			if (dictationManager != null) {
				wordRepoPane.wordRepoInfo.setText(dictationManager.getRepo().getRepoName());
			}
		}
	}

	@Override
	protected void setPanel(JPanel jPanel) {
		this.wordRepoPane = (WordRepoPane)jPanel;
	}
	
	@Override
	protected void addActionEvents() {
		addActionEvent(wordRepoPane.btnAdd, "btnAdd", "add_file");
		addActionEvent(wordRepoPane.btnRemove, "btnRemove", "remove_file");
	}
	
	public void actionBtnadd(String command) {
		addWordsFromFiles(fileSelector.listModel.toArray());
		fileSelector.listModel.removeAllElements();
	}
	
	public void actionBtnremove(String command) {
		int[] index = getSelectedIndices();
		for (int i : index) {
			fileSelector.listModel.remove(i);
		}
	}
}
