//Leland Conn, Student Number: 250946924 is the author of this code

/*The input to the program will consist of two files: a file to compress
 * and a file containing the compression codes.
 * The output will be the compressed file.
 */
public class Compress{
	
	public static void main(String[] args) {
		
		TextFile file = new TextFile(args[0], "read");
		TextFile codes = new TextFile(args[1], "read");
		String outputName = args[0].substring(0, args[0].length() - 3) + "zzz";
		CompressedFile outputFile = new CompressedFile(outputName, "write");
		
		ArrayCode arrayOfCodePairs = new ArrayCode(10);
		char c = codes.readChar();
		String line = codes.readLine();

//Using a while loop the codes.txt file is used to make the Array of CodePairs.
		while (c !=TextFile.EOF && line != null) {
			arrayOfCodePairs.add(new CodePair(c, line));
			c = codes.readChar();
			line = codes.readLine();
		}
		
		
		String textFileLine = file.readLine();
		int textLength = textFileLine.length();

/*A while loop is used to run through the characters in the text file to compare with the characters 
 * held by the CodePairs in the Array of Code Pairs. If there is a match, the code associated with 
 * that CodePair is written to the compressed file.
*/
		while (textFileLine != null) {
			for (int i = 0; i < textLength; i++) {
				//If there is no code associated with a character in the text file 
				//the NullPointerException catches it, prints out a statement, and stops running the code
				try {
					int position = arrayOfCodePairs.findCharacter(textFileLine.charAt(i));
					String codeToWrite = arrayOfCodePairs.getCode(position);
					for (int j = 0; j < codeToWrite.length(); j++) {
						outputFile.writeBit(codeToWrite.charAt(j));
					}
				} catch (NullPointerException e) {
					System.out.println("Sorry, the character " + textFileLine.charAt(i) + " does not have any compression code.");
					System.exit(0);
				}
			}
			textFileLine = file.readLine();
			if (textFileLine != null) {
				textLength = textFileLine.length();
			}
		}
	
		codes.close();
		file.close();
		outputFile.close();
	}
}