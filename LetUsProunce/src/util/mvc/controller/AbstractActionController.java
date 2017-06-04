package util.mvc.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import util.mvc.controller.ActionMessageHandler;

abstract public class AbstractActionControler extends ActionListenerManager{
	public String source;
	public String command;
	protected JComponent view;
	protected List<ActionMessageHandler> aimObjects=new ArrayList<ActionMessageHandler>();
	
	public AbstractActionControler(JComponent view){
		this.view=view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		source=((JComponent)e.getSource()).getName();
		command=e.getActionCommand();
		sendActionMessageToHandlers(source,command);
	}
	
	public String getSource(){
		return source;
	}
	
	public String getCommand(){
		return command;
	}
	
	public JComponent getView(){
		return view;
	}
	
	public void addActionMessageHandler(ActionMessageHandler aimObject){
		aimObjects.add(aimObject);
	}
	
	public void removeActionMessageHandler(ActionMessageHandler aimObject){
		aimObjects.remove(aimObject);
	}
	
	public void setActionMessageHandlers(ArrayList<ActionMessageHandler> aimObjects){
		this.aimObjects = aimObjects;
	}
	
	public List<ActionMessageHandler> getActionMessageHandlers(){
		return aimObjects;
	}
	
	public void removeActionMessageHandlers(){
		aimObjects.clear();
	}
	
	protected void sendActionMessageToHandlers(String sourceName,String command){
		for(ActionMessageHandler aimObject:aimObjects){
			aimObject.achieveMessage(sourceName,command);
		}
	}
	
	protected void sendActionMessageToOneHandler(ActionMessageHandler aimObject,String sourceName,String command){
			aimObject.achieveMessage(sourceName,command);
	}
	
	protected void sendActionMessageToHandlerList(List<ActionMessageHandler> aimObjects,String sourceName,String command){
		for(ActionMessageHandler aimObject:aimObjects){
			aimObject.achieveMessage(sourceName,command);
		}
	}
}
