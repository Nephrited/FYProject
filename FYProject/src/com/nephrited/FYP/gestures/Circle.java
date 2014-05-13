package com.nephrited.FYP.gestures;

import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Gesture;
import com.nephrited.FYP.robot.*;

public class Circle extends CircleGesture {
	
	public Circle(Gesture gesture) {
		super(gesture);
		
		//Clockwise or Anticlockwise?
    	boolean clockwise;
        if (pointable().direction().angleTo(normal())<=Math.PI/4) {
        	//If the angle between the normal and the finger is less than 90 degrees AKA Pi/4
        	//then the gesture is clockwise
        	clockwise = true;
        } else {
        	//Otherwise it's not
            clockwise = false;
        }
        
        ScrollRobot scrollRobot = new ScrollRobot();
        
        if(clockwise) {
        	System.out.println("o>");
        	scrollRobot.scrollDown();
        } else {
        	System.out.println("<o");
        	scrollRobot.scrollUp();
        }
	}
	
}
