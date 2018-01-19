package model;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import controller.WordRepoPaneController;

public class FileSelector {
	private WordRepoPaneController wordRepoPaneController;
	private JFileChooser chooser = new JFileChooser();
	public DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	{
		// enable multiple selection
		chooser.setMultiSelectionEnabled(true);
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Text(*.txt)";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.getName().endsWith("txt") || f.isDirectory()) {
					return true;
				}
				return false;
			}
		});
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
