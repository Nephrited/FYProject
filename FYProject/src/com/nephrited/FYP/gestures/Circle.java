package com.nephrited.FYP.gestures;

import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Gesture;

/**
 * @author Jade
 *
 */
public class Circle extends CircleGesture {
	
	public Circle(Gesture gesture) {
		super(gesture);
		
		gesture.state();
		//Only perform actions if the gesture has ended
		if(gesture.state() == State.STATE_STOP && this.radius() > 10) {
		
			//There are only two circle gestures, clockwise and anticlockwise.
			
			//Clockwise or Anticlockwise?
	    	boolean clockwise;
	        if (pointable().direction().angleTo(normal())<=Math.PI/4) {
	        	//If the angle between the normal and the finger is less than 90 degrees AKA Pi/4
	        	//	then the gesture is clockwise
	        	clockwise = true;
	        } else {
	        	//Otherwise it's not
	            clockwise = false;
	        }
	               
	        if(clockwise) {
	        	System.out.println("Clockwise Circle");
	        } else {
	        	System.out.println("Counterclockwise Circle");
	        }
	        
		}
	}
	
}
