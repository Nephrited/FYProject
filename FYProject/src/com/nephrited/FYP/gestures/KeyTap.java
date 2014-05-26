/**
 * 
 */
package com.nephrited.FYP.gestures;

import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.KeyTapGesture;
import com.nephrited.FYP.core.ActionMapping;
import com.nephrited.FYP.core.ActionRobot;

/**
 * @author Jade
 *
 */
public class KeyTap {
	
	/**
	 * 
	 */
	public KeyTap(Gesture gesture0, Gesture gesture1) {
		KeyTapGesture keyTap0 = new KeyTapGesture(gesture0);
		KeyTapGesture keyTap1 = new KeyTapGesture(gesture1);
		
		System.out.println("Two Finger Key Tap");
		ActionRobot.getInstance().callAction(ActionMapping.getInstance().getMapping(8));
	}

}
