package com.nephrited.FYP.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ActionRobot {
	
	private static final ActionRobot INSTANCE = new ActionRobot();	
	Robot robot;
	
	private ActionRobot() {
		//Constructor is private as this is a singleton class
		super();
		try {
			//Set up the robot
			robot = new Robot();
			//Set the automatic delay after keypresses
			robot.setAutoDelay(30);			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Singleton return function
	public static ActionRobot getInstance() {
		return INSTANCE;
	}
	
	public void callAction(int action) {
		//Action integers correspond to functions
		//
		//	0 - No action / Unset
		//	1 - Zoom In (zoom(1))
		//	2 - Zoom Out (zoom(-1))
		//	3 - Reset Zoom (zoom(0))
		//	4 - Undo (undo())
		//	5 - Photoshop Redo (redo(true))
		//	6 - Standard Redo (redo(false))
		//	7 - Lock (lock())
		//	8 - Charms Bar (charms())
		//	9 - Multitasking (tab())
		//	10 - View Desktop (desktop())
		//	11 - Show context (context())
		//	12 - Start Screen (start())
		
		switch(action) {
			case 0:	break;
			case 1: zoom(1); break;
			case 2: zoom(-1); break;
			case 3: zoom(0); break;
			case 4: undo(); break;
			case 5: redo(true); break;
			case 6: redo(false); break;
			case 7: lock(); break;
			case 8: charms(); break;
			case 9: tab(); break;
			case 10: desktop(); break;
			case 11: context(); break;
			case 12: start(); break;
		}
	}
	
	public void zoom(int level) {
		
		//If level is -1, zoom out.
		//If level is 0, reset zoom.
		//If level is 1, zoom in.
		switch(level) {
			case -1:
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.mouseWheel(-1);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				break;
			case 0:
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_0);
				robot.keyRelease(KeyEvent.VK_0);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				break;
			case 1:
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.mouseWheel(1);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				break;
		}
	}
		
	public void undo() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_Z);
		robot.keyRelease(KeyEvent.VK_Z);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public void redo(boolean photoshop) {
		if(!photoshop) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_Y);
			robot.keyRelease(KeyEvent.VK_Y);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} else {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_Z);
			robot.keyRelease(KeyEvent.VK_Z);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}
	
	public void lock() {
		try {
			Runtime.getRuntime().exec("rundll32 user32.dll,LockWorkStation");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void charms() {
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
	}
	
	public void tab() {
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
	}
	
	public void desktop() {
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
	}
	
	public void context() {
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_Z);
		robot.keyRelease(KeyEvent.VK_Z);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
	}
	
	public void start() {
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
	}
	
}
