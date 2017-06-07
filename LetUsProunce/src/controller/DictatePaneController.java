package controller;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import util.Word;
import util.mvc.controller.AbstractActionController;
import view.DictatePane;

public class DictatePaneController extends AbstractActionController {
	private DictatePane dictatePane;
	
	public DictatePaneController(DictatePane dictatePane) {
		this.dictatePane = dictatePane;
		addActionEvents();
	}
	
	private void initUI() {
		dictatePane.btnNo.setVisible(false);
		dictatePane.btnYes.setVisible(false);
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
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource().equals(dictatePane.btnGo)) {
			showDictateUI();
		}
	}
	
	@Override
	protected void addActionEvents() {
		addActionEvent(dictatePane.btnGo, "btnGo", "start_dictate");
		addActionEvent(dictatePane.btnYes, "btnYes", "remove_word_and_next");
		addActionEvent(dictatePane.btnNo, "btnNo", "keep_word_and_next");
	}

	@Override
	protected void showView(boolean isToShow) {
		initUI();
		dictatePane.setVisible(isToShow);
	}
}
