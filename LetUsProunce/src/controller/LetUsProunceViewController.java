package controller;

import java.awt.event.ActionEvent;

import util.mvc.controller.AbstractActionController;
import util.mvc.controller.MessageHandler;
import view.LetUsProunceView;

public class LetUsProunceViewController extends AbstractActionController implements MessageHandler {
	private LetUsProunceView view;
	private DictatePaneController dictatePaneController;
//	private WordRepoPaneController wordRepoPaneController;
	
	public LetUsProunceViewController(LetUsProunceView view) {
		this.view = view;
		linkViewsWithController();
	}
	
	public void start() {
		initUI();
	}

	// Handle menu-related item's actions
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if ((e.getSource().equals(view.mnDictate))) {
			dictatePaneController.getPane().setVisible(true);
//			wordRepoPaneController.getPane().setVisible(false);
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
		addActionEvent(view.mnDictate,"mnDictate", "show_dictate_ui");
	}
	
	private void linkViewsWithController() {
		dictatePaneController = new DictatePaneController(view.dictatePane);
		// By implementing MessageHandler, this class has power to handler messages coming from its panels
		dictatePaneController.addActionMessageHandler(this);
		
//		wordRepoPaneController = new WordRepoPaneController(view.wordRepoPane);
//		wordRepoPaneController.addActionMessageHandler(this);
	}
	
	private void initUI() {
		view.setVisible(true);
		dictatePaneController.getPane().setVisible(false);
//		wordRepoPaneController.getPane().setVisible(true);
	}
}
