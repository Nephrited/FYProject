/**
 * 
 */
package com.nephrited.FYP.core;

import java.util.HashMap;

/**
 * @author Jade
 *
 */
public class ActionMapping {

	private static final ActionMapping INSTANCE = new ActionMapping();	
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	/**
	 * 
	 */
	private ActionMapping() {
		//Constructor is private as this is a singleton class
		super();
		
		//Key integers correspond to gestures
		//Value integers correspond to action functions
		//
		// Keys
		//	0 - Clockwise Circle
		//	1 - Counterclockwise Circle
		//	2 - Single Left
		//	3 - Single Right
		//	4 - Single Up
		//	5 - Single Down
		//	6 - Double Up
		//	7 - Double Down
		//	8 - Double Tap
		//	9 - Pinch In
		//	10 - Pinch Out
		
		// 	Values
		//	0 - No action / Unset
		//	1 - Zoom In (zoom(1))
		//	2 - Zoom Out (zoom(-1))
		//	3 - Reset Zoom (zoom(0))
		//	4 - Undo (undo())
		//	5 - Photoshop Redo (redo(true))
		//	6 - Standard Redo (redo(false))
		//	7 - Lock (lock())
		//	8 - Charms Bar (charms())
		//	9 - Multitasking (tab())
		//	10 - View Desktop (desktop())
		//	11 - Show context (context())
		//	12 - Start Screen (start())
		
		//Set default actions
		
		map.put(0, 0);
		map.put(1, 0);
		map.put(2, 8);
		map.put(3, 9);
		map.put(4, 0);
		map.put(5, 0);
		map.put(6, 12);
		map.put(7, 10);
		map.put(8, 0);
		map.put(9, 2);
		map.put(10, 1);
		
	}
	
	//Singleton return function
	public static ActionMapping getInstance() {
		return INSTANCE;
	}
	
	public int getMapping(int key) {
		return map.get(key);
	}
	
	public void setMapping(int key, int action) {
		map.put(key, action);
	}

}
