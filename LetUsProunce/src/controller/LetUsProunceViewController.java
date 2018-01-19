package controller;

import javax.swing.JFrame;

import model.DictationManager;
import model.FileSelector;
import util.SortedWordRepo;
import util.TxtWordExtractor;
import util.mvc.controller.AbstractManagerController;
import view.LetUsProunceView;

public class LetUsProunceViewController extends AbstractManagerController{
	private LetUsProunceView view;
	private DictatePaneController dictatePaneController;
	private WordRepoPaneController wordRepoPaneController;
	private DictationManager dictationManager;
	private FileSelector fileSelector;
	
	public LetUsProunceViewController(LetUsProunceView view) {
		super(view);
	}

	public void start() {
		showView(true);
	}
	
	@Override
	protected void showView(boolean isToShow) {
		if (isToShow) {
			dictatePaneController.showView(false);
			wordRepoPaneController.showView(true);
		}
		view.setVisible(isToShow);
	}
	
	@Override
	protected void addActionEvents() {
		// observe (JMenu: mnDictate) action events
		addActionEvent(view.mntmDictationStart, "Dictationstart");
		// observe (JMenu: mnFile) action events;
		addActionEvent(view.mntmFile, "File");
		// observe (JMenu: mnWordRepo) action events;
		addActionEvent(view.mntmWordRepoEdit, "WordRepoEdit");
	}
	
	protected void linkViewsWithController(JFrame view) {
		this.view = (LetUsProunceView)view;
		
		dictatePaneController = new DictatePaneController(this.view.dictatePane);
		
		wordRepoPaneController = new WordRepoPaneController(this.view.wordRepoPane);
	}

	protected void linkModelsWithController() {
		// init dictationManager and link it with controllers
		dictationManager = new DictationManager(new SortedWordRepo(), new TxtWordExtractor());
		dictationManager.setDictatePaneController(dictatePaneController);
		wordRepoPaneController.setDictationManager(dictationManager);
		dictatePaneController.setDictationManager(dictationManager);
		
		// init fileSelector and link it with wordRepoPaneController
		fileSelector = new FileSelector();
		fileSelector.setController(wordRepoPaneController);
		wordRepoPaneController.setFileSelector(fileSelector);
	}
	
	public void actionDictationstart(String command) {
		dictatePaneController.showView(true);
		wordRepoPaneController.showView(false);
	}
	
	public void actionFile(String command) {
		fileSelector.openChooser();
	}
	
	public void actionWordrepoedit(String command) {
		dictatePaneController.showView(false);
		wordRepoPaneController.showView(true);
	}
}
