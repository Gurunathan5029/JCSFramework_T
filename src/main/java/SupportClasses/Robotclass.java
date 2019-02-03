package SupportClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Robotclass {
	Robot robot;
	Robotclass() throws AWTException
	{
		 robot=new Robot();
	}
	
	public void keypress(int keyevent)
	{
		robot.keyPress(keyevent);
	}
	
	public void keyrelease(int keyevent)
	{
		robot.keyRelease(keyevent);
	}
	
	public void mousepress(int mouseevent)
	{
		robot.mousePress(mouseevent);
	}
	
	public void mouserelease(int mouseevent)
	{
		robot.mouseRelease(mouseevent);
	}
	public void pressEnter()
	{
		keypress(KeyEvent.VK_ENTER);
		keyrelease(KeyEvent.VK_ENTER);
	}
	
	public void pressEscape()
	{
		keypress(KeyEvent.VK_ESCAPE);
		keyrelease(KeyEvent.VK_ENTER);
	}
	
	public void leftmousepress()
	{
		mousepress(InputEvent.BUTTON1_DOWN_MASK);
		mouserelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public void rightmousepress()
	{
		mousepress(InputEvent.BUTTON3_DOWN_MASK);
		mouserelease(InputEvent.BUTTON3_DOWN_MASK);
	}	
	
	public void tabpress()
	{
		keypress(KeyEvent.VK_TAB);
		keyrelease(KeyEvent.VK_TAB);
	}	
	

}
