//Leland Conn

/*This class stores a list of characters and their compression codes. Each pair (character,compression code) will be stored 
 * in an object of class CodePair. The list, then, will be stored in an array of CodePair objects.
 * This class will have an instance variables referencing this array, storing the size of the array,
 * and the number of new CodePair object elements that have been stored in it.
 */
public class ArrayCode {
	
	private int size;
	private CodePair[] ArrayOfCodePairs;
	private int newElements;
	
	/**
	 * Constructor creates an array of the given size
	 * @param size is the size of the array
	 */

	public ArrayCode (int size) {
		
		this.size = size;
		this.ArrayOfCodePairs = new CodePair[this.size];
		this.newElements = 0;
		
	}
	
/**The add method adds the given pair to the array of CodePairs. 
 * If the array is full before the new pair is added to it, 
 * then the capacity of the array needs to be expanded as follows:
 * If the length or size of the array is at most 100, then the size of the array will be doubled.
 * If the size of the array is larger than 100, then the size of the array will increase by 20.
 * 
 * @param pair is the CodePair being added to the array
*/
	public void add (CodePair pair) {
		
		if (this.size > this.newElements) {
			
		} else if (this.size <= 100) {
			CodePair[] oldCodePairs = this.ArrayOfCodePairs.clone();
			this.size = this.size*2;
			this.ArrayOfCodePairs = new CodePair[this.size];
			
			for(int i = 0; i < oldCodePairs.length; i++) {
				this.ArrayOfCodePairs[i] = oldCodePairs[i];
			}
			
			
		} else {
			CodePair[] oldCodePairs = this.ArrayOfCodePairs.clone();
			this.size = this.size + 20;
			this.ArrayOfCodePairs = new CodePair[this.size];
			
			for(int i = 0; i < oldCodePairs.length; i++) {
				this.ArrayOfCodePairs[i] = oldCodePairs[i];
			}
			
			
		}
		
		this.ArrayOfCodePairs[this.newElements] = pair;
		this.newElements++;
		
	}
	
/**
 * remove method removes pairToRemove from the array.
 * If pairToRemove is not in the array, then nothing is removed.
 * If after removing the specified object from the array the number of CodePair objects in the array is 
 * less than one fourth of the size of the array, then the size of the array will be decreased by half.
 * 
 * @param pairToRemove is the pair being removed
 */
	public void remove(CodePair pairToRemove) {
		
		int i = 0;
		while ((i < this.size) && (pairToRemove.getCharacter() != this.ArrayOfCodePairs[i].getCharacter() && pairToRemove.getCode() != this.ArrayOfCodePairs[i].getCode())) {
			i += 1;
		}
		
		if (i != this.size) {
			this.ArrayOfCodePairs[i] = this.ArrayOfCodePairs[this.newElements - 1];
			this.newElements--;
			
			if (this.newElements < this.size/4) {
				CodePair[] listOfCP = this.ArrayOfCodePairs.clone();
				this.size = this.size/2;
				this.ArrayOfCodePairs = new CodePair[this.size];
				
				for(int j = 0; j < this.size; j++) {
					this.ArrayOfCodePairs[j] = listOfCP[j];
				}
			}
		}
	}

/**The findCode method looks for the given code in the array. 
 * If the array contains a CodePair object with the given compression code,
 * the position of this object in the array is returned. 
 * If no entry of the array stores the given compression code, this method must return the value -1.
 * 
 * @param code is the code trying to be found
 */
	public int findCode(String code) {

		for(int i = 0; i < this.newElements; i++) {
			if (this.ArrayOfCodePairs[i].getCode().equals(code)) {
				return i;
			}
		}
		return -1;
	}
	
/**The findCharacter method looks for the given character in the array. If the array contains a CodePair object storing 
 * the given character, the position of this object in the array is returned. If no entry of the array stores
 * the given character, this method returns the value -1.
 * 
 * @param c is the character trying to be found
 */
	public int findCharacter(char c) {
		
		for(int i = 0; i < this.newElements; i++) {
			if (this.ArrayOfCodePairs[i].getCharacter() == c) {
				return i;
			}
		}
		return -1;
		
	}
	
	/**
	 * getCode method gets the code of the CodePair  at the given position
	 * @param i is the position in the array that code is trying to be retrieved from
	 * @return the code of the CodePair at the given position or returns null if the position doesn't exist
	 */
	
	public String getCode(int i) {
		if (i < 0 || i > this.newElements) {
			return null;
		}
		return this.ArrayOfCodePairs[i].getCode();
	}

/**The getCharacter method returns the character in the CodePair object stored in the i-th position of the array. 
 * If there is no CodePair object stored in position i of the array
 * this method returns the value 0 (null character).
 * 
 * @param i is the position in the array that character is trying to be retrieved from
 * @return 0 if the position does not exist, or return the character of the Code Pair at the position
 */
	public char getCharacter(int i) {
		if (i < 0 || i > this.newElements) {
			return 0;
		}
		return this.ArrayOfCodePairs[i].getCharacter();
	}
	
	/**
	 * getSize returns the size of the array
	 * @return size of the array
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * getNumPairs returns the number of CodePair elements in the array
	 * @return number of Code Pair elements in the array
	 */
	
	public int getNumPairs() {
		return this.newElements;
	}

}
