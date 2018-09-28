//Leland Conn

//This class represents an entry in the list of codes, associating a character with a compression code.
public class CodePair {
	
	private char c;
	private String code;
	
	/**
	 * Constructor a code pair with a code and character
	 * @param c is the character
	 * @param code is the code
	 */
	public CodePair(char c, String code) {
		this.c = c;
		this.code = code;
	}
	
	
	/**
	 * getCode returns the code data of the CodePair
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * getCharacter returns the character data of the CodePair
	 * @return c which is the character
	 */
	public char getCharacter() {
		return this.c;
	}
	
	/**
	 * setCharacter sets the character data
	 * @param c is the new character data
	 */
	public void setCharacter(char c) {
		this.c = c;
	}
	
	/**
	 * setCode sets the code data
	 * @param code is the new code data
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * equals compares another CodePair object with this one
	 * @param anotherPair is the other CodePair being compared
	 * @return
	 */
	public boolean equals(CodePair anotherPair) {
		if (this.c == anotherPair.c) {
			return true;
		} else {
			return false;
		}
	}

}
