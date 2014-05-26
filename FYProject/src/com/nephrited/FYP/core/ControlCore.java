package com.nephrited.FYP.core;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.leapmotion.leap.Controller;

public class ControlCore {

	static Scanner s = new Scanner(System.in);

	
	public static void main(String[] args) {
		//Inital User Interface Setup
		System.out.println("Scanner for Leap Motion");
		boolean running = true;		
		//Setting up the Leap Listener
		ControlListener listener = new ControlListener();
		//Setting up the Leap controller
		Controller controller = new Controller();
		
		//Link the controller and the listener
		controller.addListener(listener);
		
		//Request background access
		controller.setPolicyFlags(Controller.PolicyFlag.POLICY_BACKGROUND_FRAMES); 
		
		//Print menu options
		System.out.println("1) Set up Gestures");
		System.out.println("2) View current configuration");
		System.out.println("3) Quit Scanner");
		
		//Keep this process running until keypress
		while(running) {
			String input;
			try {
				input = s.nextLine();
				
				if(input.equals("1")) {
					
					controller.removeListener(listener);
					configure();
					controller.addListener(listener);
					
				} else if(input.equals("2")) {
					
					controller.removeListener(listener);
					viewMapping();
					controller.addListener(listener);
					
				} else if(input.equals("3")) {
					
					running = false;
					
				}
				
			} catch (IOException e) {
			}
		}
		
		//Remove the listener from the controller
		controller.removeListener(listener);
	}
	
	private static void configure() throws IOException {
		
		int gesture = 0;
		int action = 0;
		
		System.out.println("Selected a gesture to configure, or any other key to cancel:");
		
		System.out.println("0 - Clockwise Circle (1 finger)\n"+
			"1 - Counterclockwise Circle (1 finger)\n"+
			"4 - Up Swipe (1 finger)\n"+
			"5 - Down Swipe (1 finger)\n"+
			"8 - Tap  (2 fingers)\n");
		
		try {
			gesture = Integer.parseInt(s.nextLine());
		} catch(Exception e) {
			System.out.println("Please enter a number from the options provided");
			return;
		}
		if(gesture != 1 && gesture != 0 && gesture != 4 && gesture != 5 && gesture != 8 ) {
			System.out.println("Please enter a number from the options provided");
			return;
		}
		
		System.out.println("Assign an action, or any other key to cancel:");
		
		System.out.println("0 - No action / Unset\n"+
			"3 - Reset Zoom (zoom(0))\n"+
			"4 - Undo (undo())\n"+
			"5 - Photoshop Redo (redo(true))\n"+
			"6 - Standard Redo (redo(false))\n"+
			"7 - Lock (lock())\n"+
			"11 - Show context (context())\n");
		
		try {
			action = Integer.parseInt(s.nextLine());
		} catch(Exception e) {
			System.out.println("Please enter a number from the options provided");
			return;
		}
		if(action != 0 && action != 3 && action != 4 && action != 5 && action != 6 && action!=7 && action!=8) {
			System.out.println("4Please enter a number from the options provided");
			return;
		}
		
		ActionMapping.getInstance().setMapping(gesture, action);
		
		//Print menu options
		System.out.println("1) Set up Gestures");
		System.out.println("2) View current configuration");
		System.out.println("3) Quit Scanner");

	}

	private static void viewMapping() {
		int gesture = 0;

		System.out.println("Select a gesture to view, or any other key to cancel:");
		
		System.out.println("0 - Clockwise Circle (1 finger)\n"+
				"1 - Counterclockwise Circle (1 finger)\n"+
				"2 - Left Swipe (1 finger)\n"+
				"3 - Right Swipe (1 finger)\n"+
				"4 - Up Swipe (1 finger)\n"+
				"5 - Down Swipe (1 finger)\n"+
				"6 - Up Swipe (2 fingers)\n"+
				"7 - Down Swipe (2 fingers)\n"+
				"8 - Tap  (2 fingers)\n"+
				"9 - Pinch In (2 fingers)\n"+
				"10 - Pinch Out (2 fingers)\n");
		
		try {
			gesture = Integer.parseInt(s.nextLine());
		} catch(Exception e) {
			System.out.println("Please enter a number from the options provided");
			return;
		}
		if(gesture < 0 || gesture > 10) {
			System.out.println("Please enter a number from the options provided");
			return;
		}
		
		int map = ActionMapping.getInstance().getMapping(gesture);
		
		System.out.println("Map:"+map);
		
		switch(map) {
			case 0: System.out.println("This gesture is not mapped");break;
			case 1: System.out.println("This gesture is mapped to zoom in");break;
			case 2: System.out.println("This gesture is mapped to zoom out");break;
			case 3: System.out.println("This gesture is mapped to reset zoom levels");break;
			case 4: System.out.println("This gesture is mapped to undo an action");break;
			case 5: System.out.println("This gesture is mapped to undo an action in photoshop");break;
			case 6: System.out.println("This gesture is mapped to redo an action");break;
			case 7: System.out.println("This gesture is mapped to lock the computer");break;
			case 8: System.out.println("This gesture is mapped to the Charms bar");break;
			case 9: System.out.println("This gesture is mapped to switch applications");break;
			case 10: System.out.println("This gesture is mapped to show the Desktop");break;
			case 11: System.out.println("This gesture is mapped to show the Context Menu");break;
			case 12: System.out.println("This gesture is mapped to show the Start Screen");break;
		}
		
		System.out.println("\nPress enter to continue");
		s.nextLine();
		
		//Print menu options
		System.out.println("1) Set up Gestures");
		System.out.println("2) View current configuration");
		System.out.println("3) Quit Scanner");
	}
	
}
