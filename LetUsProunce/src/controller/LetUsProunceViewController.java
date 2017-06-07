package controller;

import java.awt.event.ActionEvent;
import model.DictationManager;
import model.FileSelector;
import util.SortedWordRepo;
import util.TxtWordExtractor;
import util.mvc.controller.AbstractActionController;
import util.mvc.controller.MessageHandler;
import view.LetUsProunceView;

public class LetUsProunceViewController extends AbstractActionController implements MessageHandler {
	private LetUsProunceView view;
	private DictatePaneController dictatePaneController;
	private WordRepoPaneController wordRepoPaneController;
	private DictationManager dictationManager;
	private FileSelector fileSelector;
	
	public LetUsProunceViewController(LetUsProunceView view) {
		this.view = view;
		linkViewsWithController();
		linkModelsWithController();
		addActionEvents();
	}

	public void start() {
		showView(true);
	}
	
	@Override
	protected void showView(boolean isToShow) {
		dictatePaneController.showView(false);
		wordRepoPaneController.showView(true);
		view.setVisible(true);
	}
	
	// Handle menu-related item's actions
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		// once start button under dictate menu is activated
		// switch UI to dictatePane
		if ((e.getSource().equals(view.mntmDictationStart))) {
			dictatePaneController.showView(true);
			wordRepoPaneController.showView(false);
		} else if (e.getSource().equals(view.mntmFile)) {
			fileSelector.openChooser();
		} else if (e.getSource().equals(view.mntmWordRepoEdit)) {
			dictatePaneController.showView(false);
			wordRepoPaneController.showView(true);
		}
	}
	
	// Take care of the message coming from its panels.
	@Override
	public boolean achieveMessage(String source, String command) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	protected void addActionEvents() {
		// observe (JMenu: mnDictate) action events
		addActionEvent(view.mntmDictationStart);
		// observe (JMenu: mnFile) action events;
		addActionEvent(view.mntmFile);
		// observe (JMenu: mnWordRepo) action events;
		addActionEvent(view.mntmWordRepoEdit);
	}
	
	private void linkViewsWithController() {
		dictatePaneController = new DictatePaneController(view.dictatePane);
		// By implementing MessageHandler, this class has power to handler messages coming from its panels
		dictatePaneController.addActionMessageHandler(this);
		
		wordRepoPaneController = new WordRepoPaneController(view.wordRepoPane);
		wordRepoPaneController.addActionMessageHandler(this);
	}

	private void linkModelsWithController() {
		// init dictationManager and link it with controllers
		dictationManager = new DictationManager(
				new SortedWordRepo(), new TxtWordExtractor());
		dictationManager.setDictatePaneController(dictatePaneController);
		
		// init fileSelector and link it with wordRepoPaneController
		fileSelector = new FileSelector();
		fileSelector.setController(wordRepoPaneController);
		
		dictatePaneController.addActionMessageHandler(dictationManager);
		
		wordRepoPaneController.addActionMessageHandler(dictationManager);
		wordRepoPaneController.addActionMessageHandler(fileSelector);
	}
}
