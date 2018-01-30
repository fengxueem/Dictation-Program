package util.mvc.app;

import util.mvc.controller.AbstractManagerController;

abstract public class AbstractEntrance {
	/**
	 * initiate all manager controller
	 */
	protected abstract void initManagerControllers();
	
	/**
	 * Start main controller
	 */
	protected abstract void start();
	
	public AbstractEntrance() {
		initManagerControllers();
	}
	
	public void showManagerFrame(AbstractManagerController managerController) {
		managerController.start();
	}
}
