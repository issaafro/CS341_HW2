package dabney;

/**
 * @author Devon Dabney
 * @version 1.0
 */
public class Password {
	private String password;
	private int largestBlock;
	
	/**
	 * Creates a password and uses a method to compute its largest block length.
	 * 
	 * @param password		The password's string value
	 * largestBlock			The integer length of the largest block of adjacent 
	 * 						characters that are exactly the same in the password.
	 */
	public Password(String password) {
		this.password = password;
		largestBlock = this.largestBlockLength();
	}

	/**
	 * Gets the password value.
	 * 
	 * @return A string representing the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the length of the largest block in the password.
	 * 
	 * @return An integer representing the length of the largest block in the password.
	 */
	public int getLargestBlock() {
		return largestBlock;
	}
	
	/**
	 * Tests the strength of the password by determining if the largest block is greater
	 * than or less than 2.
	 * 
	 * @return A string stating the largest block's length and whether or not the
	 * password is considered strong or weak. If weak then a suggestion is provided on 
	 * how to improve the password.
	 */
	public String strengthCheck() {
		String output = "The largest block in the password is " + largestBlock + ". ";
		String goodPass = "This is a decent password.";
		String badPass = "This password can be made stronger by reducing this block by "
				+ (largestBlock - 2) + ".";
		return output + (largestBlock <= 2 ? goodPass : badPass);
	}
	
	/**
	 * Determines the length of the largest block of exact same adjacent characters
	 * in the password.
	 * 
	 * @return An integer representing the largest block in the password.
	 */
	public int largestBlockLength() {
		String currentBlock = "";
		String largestBlock = "";
		for(int i = 0; i < this.length() - 1; i++) {
			if(i == 0)
				currentBlock += password.charAt(i);
			else if(password.charAt(i) != currentBlock.charAt(0)) {
				if(currentBlock.length() > largestBlock.length()) {
					largestBlock = currentBlock;
					currentBlock = "" + password.charAt(i);
				}
				else {
					currentBlock = "" + password.charAt(i);
				}
			}
			else if(password.charAt(i) == currentBlock.charAt(0)) 
				currentBlock += password.charAt(i);
		}
		if(currentBlock.length() > largestBlock.length())
			return currentBlock.length();
		
		return largestBlock.length();
	}
	
	/**
	 * Gets the length of the password.
	 * 
	 * @return An integer representing the length of the password.
	 */
	public int length() {
		return password.length();
	}
	
	/**
	 * Checks to see if an entered password is valid to test.
	 * 
	 * @return True if password meets all conditions (proper length and no spaces)
	 * or false if one/both of the conditions is/are not met.
	 */
	public Boolean isValid() {
		return password.length() >= 8 && password.length() <= 12 && !password.contains(" ");
	}
	
	/**
	 * Output for an invalid password.
	 * 
	 * @return A string explaining the entered password is invalid in some way 
	 * and can't be tested.
	 */
	public String invalidPass() {
		return "The password entered is invalid! Check to make sure the password is "
				+ "between 8 to 12 characters long and contains no spaces.";
	}

	
	
	
	
	

}
