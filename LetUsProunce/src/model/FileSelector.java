package model;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import controller.WordRepoPaneController;
import util.mvc.controller.MessageHandler;

public class FileSelector implements MessageHandler {
	private WordRepoPaneController wordRepoPaneController;
	private JFileChooser chooser = new JFileChooser();
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	{
		// enable multiple selection
		chooser.setMultiSelectionEnabled(true);
	}
	
	@Override
	public boolean achieveMessage(String source, String command) {
		switch (source + command) {
			case "btnAddadd_file":
				wordRepoPaneController.addWordsFromFiles(listModel.toArray());
				listModel.removeAllElements();
				return true;
			case "btnRemoveremove_file":
				int[] index = wordRepoPaneController.getSelectedIndices();
				for (int i : index) {
					listModel.remove(i);
				}
				return true;
			default:
				break;
		}
		return false;
	}

	public void setController(WordRepoPaneController controller) {
		this.wordRepoPaneController = controller;
	}

	public void openChooser() {
		int result;
		result = chooser.showOpenDialog(wordRepoPaneController.getPane());
		if (result == JFileChooser.APPROVE_OPTION) {
			for (File f : chooser.getSelectedFiles()) {
				listModel.addElement(f.getAbsolutePath());
			}
			wordRepoPaneController.updateList(listModel);
		}
	}

}
