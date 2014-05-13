package com.nephrited.FYP.robot;

import java.awt.AWTException;
import java.awt.Robot;

public class ScrollRobot {
	
	Robot robot;
	
	public ScrollRobot() {
		super();
		
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scrollDown() {
		robot.mouseWheel(1);
	}
	
	public void scrollUp() {
		robot.mouseWheel(-1);
	}
}
