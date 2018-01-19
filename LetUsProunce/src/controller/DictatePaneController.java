package controller;

import javax.swing.JPanel;

import model.DictationManager;
import util.Word;
import util.mvc.controller.AbstractServiceController;
import view.DictatePane;

public class DictatePaneController extends AbstractServiceController{
	private DictatePane dictatePane;
	private DictationManager dictationManager;
	
	public DictatePaneController(DictatePane dictatePane) {
		super(dictatePane);
	}
	
	public DictationManager getDictationManager() {
		return dictationManager;
	}

	public void setDictationManager(DictationManager dictationManager) {
		this.dictationManager = dictationManager;
	}
	
	private void initUI() {
		dictatePane.btnNo.setVisible(false);
		dictatePane.btnYes.setVisible(false);
		dictatePane.btnGo.setVisible(true);
		dictatePane.lblRepoNumber.setVisible(false);
		setWordField(new Word("Are you ready?"));
	}
	
	private void showDictateUI() {
		dictatePane.btnNo.setVisible(true);
		dictatePane.btnYes.setVisible(true);
		dictatePane.btnGo.setVisible(false);
		dictatePane.lblRepoNumber.setVisible(true);
	}

	public JPanel getPane() {
		return dictatePane;
	}
	
	public void setWordField(Word w) {
		dictatePane.wordField.setText(w.getName());
	}
	
	public void setWordNum(int size) {
		dictatePane.lblRepoNumber.setText(Integer.toString(size));
	}
	
	@Override
	protected void showView(boolean isToShow) {
		if (isToShow) {
			initUI();
		}
		dictatePane.setVisible(isToShow);
	}

	@Override
	protected void setPanel(JPanel jPanel) {
		this.dictatePane = (DictatePane)jPanel;
		
	}
	
	@Override
	protected void addActionEvents() {
		addActionEvent(dictatePane.btnGo, "btnGo", "start_dictate");
		addActionEvent(dictatePane.btnYes, "btnYes", "remove_word_and_next");
		addActionEvent(dictatePane.btnNo, "btnNo", "keep_word_and_next");
	}
	
	public void actionBtngo(String command) {
		showDictateUI();
	}
	
	public void actionBtnyes(String command) {
		dictationManager.removeWord();
		setWordField(dictationManager.getNext());
		setWordNum(dictationManager.getRepo().getSize());
	}
	
	public void actionBtnno(String command) {
		setWordField(dictationManager.getNext());
	}
}
