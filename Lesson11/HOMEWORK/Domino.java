public class Domino {

	// The values at each end of the domino
	private int value1, value2;
	// Which value is currently "in play" - 1 or 2 (0 indicated unplayed)
	private int freeValue;
	// Whether this domino has been placed, or is still in the bag
	private boolean placed;

	/**
	 * Construct a domino with a given value for each end.
	 * @param val1 The numeric value of one end of the domino.
	 * @param val2 The numeric value of the other end of the domino.
	 */
	public void domino(int val1, int val2) {
		if (val1 < 1 || val1 > 6 || val2 < 1 || val2 > 6) {
			throw new IllegalArgumentException("Domino values range from 1-6");
		}
		
		value1 = val1;
		value2 = val2;
		freeValue = 0;
		placed = false;
	}
	
	/**
	 * Retrieve the value of end#1 of the domino.
	 * @return The value of end 1.
	 */
	public int getValue1() {
		return value1;
	}
	
	/**
	 * Retrive the value of end#2 of the domino.
	 * @return The value of end 2.
	 */
	public int getValue2() {
		return value2;
	}
	
	/**
	 * Marks this domino as being played, in a specific orientation.
	 * @param value The end number that was matched against another domino.
	 */
	public void play(int value) {
		if (value < 1 || value > 2) {
			throw new IllegalArgumentException();
		}
		
		if (value == 1) {
			freeValue = 2;
		} else {
			freeValue = 1;
		}
		
		placed = true;
	}
	
	/**
	 * Marks this domino as being unplayed, and back in the bag.
	 */
	public void Free() {
		freeValue = 0;
		placed = false;
	}
	
	/**
	 * Retrieves whether this domino is in the bag.
	 * @return True if the domino is in the bag, or false if it has already been played.
	 */
	public boolean getFree() {
		return !placed;
	}
	
	/**
	 * Attempts to match a domino against this domino. It checks whether the domino
	 * passed in is actually available to be played (in the bag), and whether either end
	 * of the domino passed in matches the free end of this domino. If the match is successful,
	 * the domino passed in is marked as played and taken "out of the bag."
	 * @param d The domino you are testing for a match against this domino.
	 * @return True if this domino is matched with this domino, if false if it could not be matched.
	 */
	public boolean match(Domino d) {
		if (!d.GetFree()) {
			return false;
		}
		
		if (freeValue == 0) {
			throw new RuntimeException("Match called on a domino that is still in the bag.");
		}
		
		if (freeValue == 1) {
			if (d.GetValue1() == value1) {
				d.Play(1);
				return true;
			} else if (d.GetValue2() == value1) {
				d.Play(2);
				return true;
			}
		}
		
		if (freeValue == 2) {
			if (d.getValue1() == value2) {
				d.play(1);
				return true;
			} else if (d.getValue2() == value2) {
				d.play(2);
				return true;
			}			
		}
		
		return false;
	}

}
