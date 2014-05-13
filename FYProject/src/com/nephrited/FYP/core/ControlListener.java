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

	public void onInit (Controller controller){
		System.out.println("Listener Attached");
		
		//Enable Gesture Support
		//controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		//controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
		//controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);

	}

	public void onConnect (Controller controller){
		System.out.println("Ready to begin tracking");        
	}

	public void onDisconnect (Controller controller){
		System.out.println("Leap controller lost.");
	}

	public void onFrame (Controller controller){
		//Access the latest frame data
		Frame frame = controller.frame();
		
		//Access the gestures seen within this frame
		GestureList gestures = frame.gestures();
		
		//For each gesture reported
		for (int i=0;i<gestures.count();i++) {
            Gesture gesture = gestures.get(i);
            
            //Circle Gesture?
            if(gesture.type() == Gesture.Type.TYPE_CIRCLE) {
            	new Circle(gesture);
            }
            
            if(gesture.type() == Gesture.Type.TYPE_SWIPE) {
            	//TODO Redo ALL OF THIS
            	 SwipeGesture swipe = new SwipeGesture(gesture);
            	 
            	 if(swipe.direction().getX() < 0) {
            		 try {
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_WINDOWS);
						Thread.sleep(10);
						robot.keyPress(KeyEvent.VK_C);
						Thread.sleep(10);
						robot.keyRelease(KeyEvent.VK_C);
						Thread.sleep(10);
						robot.keyRelease(KeyEvent.VK_WINDOWS);
						Thread.sleep(10);
						Thread.sleep(500);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		 
            	 }
            }
		}
	}

}
