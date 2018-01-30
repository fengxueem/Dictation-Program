package program;

import controller.LetUsProunceViewController;
import util.mvc.app.AbstractEntrance;
import view.LetUsProunceView;

public class LetUsProunce extends AbstractEntrance{
	public LetUsProunceViewController mainController;
	
	@Override
	protected void initManagerControllers() {
		mainController = new LetUsProunceViewController(new LetUsProunceView());
	}

	@Override
	protected void start() {
		showManagerFrame(mainController);
	}
	
	public static void main(String[] args) {
		LetUsProunce program = new LetUsProunce();
		program.start();
	}
}
