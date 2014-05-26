package com.nephrited.FYP.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.GestureList;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.SwipeGesture;
import com.nephrited.FYP.gestures.*;

public class ControlListener extends Listener {

	boolean firstRun = true;
	
	public void onInit (Controller controller){
		
		if(firstRun) {
			System.out.println("Please Connect the Leap Motion");
			firstRun = false;
		}
		//Enable Gesture Support
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
		//controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
	}

	public void onConnect (Controller controller){
		
		System.out.println("Leap Connected - Ready to begin tracking");        
	}

	public void onDisconnect (Controller controller){
		System.out.println("Leap controller disconnected.");
	}

	public void onFrame (Controller controller){
		//Access the latest frame data
		Frame frame = controller.frame();
		
		//Access the gestures seen within this frame
		GestureList gestures = frame.gestures();
		
		//For each gesture reported
		if(gestures.count() == 1) {
			for (int i=0;i<gestures.count();i++) {
	            Gesture gesture = gestures.get(i);
	            
	            if(gesture.type() == Gesture.Type.TYPE_CIRCLE) {
	            	Circle circle = new Circle(gesture);
	            }
	            
	            if(gesture.type() == Gesture.Type.TYPE_SWIPE) {
	            		Swipe swipe = new Swipe(gesture);
	            }
	            
			}
		} else if (gestures.count() == 2) {
            Gesture gesture0 = gestures.get(0);
            Gesture gesture1 = gestures.get(1);
            	            
            if(gesture0.type() == Gesture.Type.TYPE_SWIPE) {
            		DoubleSwipe swipe = new DoubleSwipe(gesture0, gesture1);
            }
            
            if(gesture0.type() == Gesture.Type.TYPE_KEY_TAP) {
            		KeyTap keyTap = new KeyTap(gesture0, gesture1);
            }  
		}

	}

}
