package program;

import controller.LetUsProunceViewController;
import view.LetUsProunceView;

public class LetUsProunce {
	public static void main(String[] args) {
		LetUsProunceViewController mainController = new LetUsProunceViewController(new LetUsProunceView());
		mainController.start();
	}
}
