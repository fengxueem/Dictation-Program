package util.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JComponent;

/**This class implements observer pattern, once it receives an action event or mouse event
 * or mouse wheel event, it will dynamically deliver the event to a handler method whose 
 * name starts with 'action' , 'mouse' or 'wheel'.
 */
abstract public class AbstractController extends EventListenerManager {
	private String source;
	private String command;
	
	abstract protected void addActionEvents();
	abstract protected void showView(boolean isToShow);
	
	// Action Event
	@Override
	public void actionPerformed(ActionEvent e) {
		source = ((JComponent)e.getSource()).getName();
		command = e.getActionCommand();
		try {
			Method actionSource = this.getClass().getDeclaredMethod("action" + source.substring(0, 1).toUpperCase() + source.substring(1).toLowerCase(), String.class);
			actionSource.invoke(this, command);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
			System.out.print("no such method");
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			System.out.print("illegal access");
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
			System.out.print("illegal argument");
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			System.out.print("invocation target");
		}
	}
	
	// Mouse Event
	@Override
	public void mouseClicked(MouseEvent e) {
		source=((JComponent)e.getSource()).getName();
		command = "clicked";
		try {
			Method actionSource = this.getClass().getDeclaredMethod("mouse" + source.substring(0, 1).toUpperCase() + source.substring(1).toLowerCase(), String.class, MouseEvent.class);
			actionSource.invoke(this, command, e);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
			System.out.print("no such method");
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			System.out.print("illegal access");
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
			System.out.print("illegal argument");
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			System.out.print("invocation target");
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		source=((JComponent)e.getSource()).getName();
		command = "pressed";
		try {
			Method actionSource = this.getClass().getDeclaredMethod("mouse" + source.substring(0, 1).toUpperCase() + source.substring(1).toLowerCase(), String.class, MouseEvent.class);
			actionSource.invoke(this, command, e);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
			System.out.print("no such method");
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			System.out.print("illegal access");
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
			System.out.print("illegal argument");
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			System.out.print("invocation target");
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		source=((JComponent)e.getSource()).getName();
		command = "released";
		try {
			Method actionSource = this.getClass().getDeclaredMethod("mouse" + source.substring(0, 1).toUpperCase() + source.substring(1).toLowerCase(), String.class, MouseEvent.class);
			actionSource.invoke(this, command, e);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
			System.out.print("no such method");
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			System.out.print("illegal access");
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
			System.out.print("illegal argument");
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			System.out.print("invocation target");
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		source=((JComponent)e.getSource()).getName();
		command = "entered";
		try {
			Method actionSource = this.getClass().getDeclaredMethod("mouse" + source.substring(0, 1).toUpperCase() + source.substring(1).toLowerCase(), String.class, MouseEvent.class);
			actionSource.invoke(this, command, e);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
			System.out.print("no such method");
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			System.out.print("illegal access");
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
			System.out.print("illegal argument");
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			System.out.print("invocation target");
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		source=((JComponent)e.getSource()).getName();
		command = "exited";
		try {
			Method actionSource = this.getClass().getDeclaredMethod("mouse" + source.substring(0, 1).toUpperCase() + source.substring(1).toLowerCase(), String.class, MouseEvent.class);
			actionSource.invoke(this, command, e);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
			System.out.print("no such method");
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			System.out.print("illegal access");
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
			System.out.print("illegal argument");
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			System.out.print("invocation target");
		}
	}
	
	// Mouse Wheel Event
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		source=((JComponent)e.getSource()).getName();
		command = "wheel";
		try {
			Method actionSource = this.getClass().getDeclaredMethod("wheel" + source.substring(0, 1).toUpperCase() + source.substring(1).toLowerCase(), MouseWheelEvent.class);
			actionSource.invoke(this, e);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
			System.out.print("no such method");
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			System.out.print("illegal access");
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
			System.out.print("illegal argument");
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
			System.out.print("invocation target");
		}
	}
}
