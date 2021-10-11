package edu.mtc.egr283;

import java.util.HashMap;

/**
 * Board class (models the game board for Uncle Wiggily
 * @author ryanleboeuf
 * @version 1.00 21-09-03
 */
public class Board {

	// contains the number of the space and specialSpace itself
	private HashMap<Integer, SpecialSpace> specialSpaceMap;
	
	/**
	 * Default constructor
	 */
	public Board() {
		this.specialSpaceMap = new HashMap<Integer, SpecialSpace>();
		
		this.initializeSpaceMap();
	}// Ending bracket of constructor
	
	/**
	 * Returns the SpecialSpace at the specified space number
	 * @param space to check
	 * @return SpecialSpace located at the space (null if empty)
	 */
	public SpecialSpace getSpecialSpaceAt(int space) {
		return this.specialSpaceMap.get(space);
	}// Ending bracket of method getSpecialSpaceAt
	
	// assigns the spaces for specialSpaceMap
	private void initializeSpaceMap() {
		this.specialSpaceMap.put(9, new SpecialSpace("Skillery Skallery Alligator", SpecialSpace.TYPE.LOSE_TURN, 1));
		this.specialSpaceMap.put(17, new SpecialSpace("Cluck Cluck Chicken House", SpecialSpace.TYPE.SKIP_TO_SPACE, 100));
		this.specialSpaceMap.put(23, new SpecialSpace("Rabbit Hole", SpecialSpace.TYPE.SKIP_TO_SPACE, 13));
		this.specialSpaceMap.put(28, new SpecialSpace("Bow Wow Dog House", SpecialSpace.TYPE.SKIP_TO_SPACE, 50));
		this.specialSpaceMap.put(39, new SpecialSpace("Woods", SpecialSpace.TYPE.LOSE_TURN, 1));
		this.specialSpaceMap.put(52, this.specialSpaceMap.get(23));
		this.specialSpaceMap.put(64, this.specialSpaceMap.get(17));
		this.specialSpaceMap.put(67, new SpecialSpace("The Bad Pipsisewah", SpecialSpace.TYPE.LOSE_TURN, 2));
		this.specialSpaceMap.put(76, new SpecialSpace("Wibble Wobble Duck Pond", SpecialSpace.TYPE.SKIP_TO_SPACE, 60));
		this.specialSpaceMap.put(79, new SpecialSpace("Fox Den", SpecialSpace.TYPE.LOSE_TURN, 2));
		this.specialSpaceMap.put(94, new SpecialSpace("5 & 10 Cent Store", SpecialSpace.TYPE.SKIP_TO_SPACE, 35));
		this.specialSpaceMap.put(101, new SpecialSpace("Trap", SpecialSpace.TYPE.LOSE_TURN, 2));
		this.specialSpaceMap.put(110, new SpecialSpace("Skeezicks", SpecialSpace.TYPE.LOSE_TURN, 1));
		this.specialSpaceMap.put(115, this.specialSpaceMap.get(39));
		this.specialSpaceMap.put(121, new SpecialSpace("Bushytail Squirrel Tree", SpecialSpace.TYPE.SKIP_TO_SPACE, 75));
		this.specialSpaceMap.put(138, this.specialSpaceMap.get(94));
		this.specialSpaceMap.put(141, this.specialSpaceMap.get(79));
	}// Ending bracket of method assignSkipSpaces
	
}// Ending bracket of class Board
