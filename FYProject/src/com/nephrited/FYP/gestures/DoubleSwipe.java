/**
 * 
 */
package com.nephrited.FYP.gestures;

import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.Gesture.State;
import com.nephrited.FYP.core.ActionMapping;
import com.nephrited.FYP.core.ActionRobot;

/**
 * @author Jade
 *
 */
public class DoubleSwipe {
	
	public DoubleSwipe(Gesture gesture0, Gesture gesture1) {
		SwipeGesture swipe0 = new SwipeGesture(gesture0);
		SwipeGesture swipe1 = new SwipeGesture(gesture1);
		
		SwipeGesture leftSwipe;
		SwipeGesture rightSwipe;
		
		//Only perform actions if the gesture has ended.
		if(gesture0.state() == State.STATE_STOP || gesture1.state() == State.STATE_STOP) {
		
			//Figure out which gesture is on the left and which is on the right.
			if(swipe0.position().getX()<swipe1.position().getX()) {
				leftSwipe = swipe0;
				rightSwipe = swipe1;
			} else {
				rightSwipe = swipe0;
				leftSwipe = swipe1;
			}
			
			//Check if the overall motion is horizontal or vertical
			if((Math.abs(leftSwipe.direction().getX()) + Math.abs(rightSwipe.direction().getX()))
					> (Math.abs(leftSwipe.direction().getY()) + Math.abs(rightSwipe.direction().getY()))) {
						//If horizontal, we only care about the pinch actions
				
						//Check for pinch in action
						if(leftSwipe.direction().getX() > 0 && rightSwipe.direction().getX() < 0) {
							System.out.println("Pinch In");
							ActionRobot.getInstance().callAction(ActionMapping.getInstance().getMapping(9));
						//Check for pinch out action
						} else if(leftSwipe.direction().getX() < 0 && rightSwipe.direction().getX() > 0) {
							System.out.println("Pinch Out");
							ActionRobot.getInstance().callAction(ActionMapping.getInstance().getMapping(10));
						}
						
					} else {
						
						//If Vertical, Check for overall up or down movement
						if(leftSwipe.direction().getY() > 0 && rightSwipe.direction().getY() > 0) {
							//This is upward
							System.out.println("Double Upward Swipe");
							ActionRobot.getInstance().callAction(ActionMapping.getInstance().getMapping(6));
						} else if(leftSwipe.direction().getY() < 0 && rightSwipe.direction().getY() < 0) {
							//This is downward
							System.out.println("Double Downward Swipe");
							ActionRobot.getInstance().callAction(ActionMapping.getInstance().getMapping(7));
						}
						
					}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
