package com.nephrited.FYP.core;

import java.io.IOException;

import com.leapmotion.leap.Controller;

public class ControlCore {

	public static void main(String[] args) {
		//Setting up the Leap Listener
		ControlListener listener = new ControlListener();
		//Setting up the Leap controller
		Controller controller = new Controller();
		
		//Link the controller and the listener
		controller.addListener(listener);
		
		//Request background access
		controller.setPolicyFlags(Controller.PolicyFlag.POLICY_BACKGROUND_FRAMES);
		
		//Keep this process running until keypress
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Remove the listener from the controller
		controller.removeListener(listener);
	}

}
