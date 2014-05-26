/**
 * 
 */
package com.nephrited.FYP.gestures;

import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.Vector;
import com.nephrited.FYP.core.ActionMapping;
import com.nephrited.FYP.core.ActionRobot;

/**
 * @author Jade
 *
 */
public class Swipe extends SwipeGesture {

	/**
	 * 
	 */
	public Swipe() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public Swipe(Gesture gesture) {
		super(gesture);

		//Check which direction the swipe is in
		Vector swipeDirection = this.direction();
		
		gesture.state();
		//Only perform actions if the gesture has ended.
		if(gesture.state() == State.STATE_STOP) {
		
			//If the absolute value of X is larger than the absolute value of Y, it's a horizontal gesture
			//	Otherwise, it's vertical
			if(Math.abs(swipeDirection.getX()) > Math.abs(swipeDirection.getY())) {
				
				//If the value of X is larger than 0, the movement is to the right
				//	Otherwise, it's to the left
				if(swipeDirection.getX() > 0) {
					System.out.println("Single Right Swipe");
					ActionRobot.getInstance().callAction(ActionMapping.getInstance().getMapping(3));
				} else {
					System.out.println("Single Left Swipe");
					ActionRobot.getInstance().callAction(ActionMapping.getInstance().getMapping(2));
				}
				
			} else {
				
				//If the value of Y is larger than 0, the movement is to the top
				//	Otherwise, it's to the bottom
				if(swipeDirection.getY() > 0) {
					System.out.println("Single Upward Swipe");
					ActionRobot.getInstance().callAction(ActionMapping.getInstance().getMapping(4));
				} else {
					System.out.println("Single Downward Swipe");
					ActionRobot.getInstance().callAction(ActionMapping.getInstance().getMapping(5));
				}
				
			}
			
		}
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public Swipe(long arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
