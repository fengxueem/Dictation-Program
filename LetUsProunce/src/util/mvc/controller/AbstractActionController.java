package util.mvc.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import util.mvc.controller.MessageHandler;

// This class implements observer pattern, where it contains a list of message handler,
// provides ways to set action performed message for a Swing component by addActionEvent(),
// and finally it's an action listener handling the action message registered by itself. 
abstract public class AbstractActionController extends ActionListenerManager {
	public String source;
	public String command;
	
	protected List<MessageHandler> aimObjects=new ArrayList<MessageHandler>();
	
	abstract protected void addActionEvents();
	
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
	
	public void addActionMessageHandler(MessageHandler aimObject){
		aimObjects.add(aimObject);
	}
	
	public void removeActionMessageHandler(MessageHandler aimObject){
		aimObjects.remove(aimObject);
	}
	
	public void setActionMessageHandlers(ArrayList<MessageHandler> aimObjects){
		this.aimObjects = aimObjects;
	}
	
	public List<MessageHandler> getActionMessageHandlers(){
		return aimObjects;
	}
	
	public void removeActionMessageHandlers(){
		aimObjects.clear();
	}
	
	protected void sendActionMessageToHandlers(String sourceName,String command){
		for(MessageHandler aimObject:aimObjects){
			aimObject.achieveMessage(sourceName,command);
		}
	}
	
	protected void sendActionMessageToOneHandler(MessageHandler aimObject,String sourceName,String command){
			aimObject.achieveMessage(sourceName,command);
	}
	
	protected void sendActionMessageToHandlerList(List<MessageHandler> aimObjects,String sourceName,String command){
		for(MessageHandler aimObject:aimObjects){
			aimObject.achieveMessage(sourceName,command);
		}
	}
}
