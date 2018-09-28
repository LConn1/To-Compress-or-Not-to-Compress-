//Leland Conn

/*The input to this program consists of two files: a compressed file
 * and a file containing the compression codes.
 * The output will be the decompressed file.
 */
public class Decompress {

	public static void main(String[] args) {
		
		String decompressedFileName = args[0].substring(0, args[0].length() - 3) + "dec";
		String compressedFile = args[0].substring(0, args[0].length() - 3) + "zzz";
		CompressedFile compressedFileName = new CompressedFile(compressedFile, "read");
		TextFile compressionCodesName = new TextFile(args[1], "read");
		TextFile decompressedFile = new TextFile(decompressedFileName, "write");
		
		ArrayCode arrayOfCodePairs = new ArrayCode(10);
		char c = compressionCodesName.readChar();
		String line = compressionCodesName.readLine();

//Using a while loop the codes.txt file is used to make the Array of CodePairs
		while (c != TextFile.EOF && line != null) {
			arrayOfCodePairs.add(new CodePair(c, line));
			c = compressionCodesName.readChar();
			line = compressionCodesName.readLine();
		}
		char bit  = compressedFileName.readBit();
		String code = "";
		code += bit;

/*The compressed text file is read through and compared with the code in the CodePairs found in the Array of Code Pairs.
 * If there is a match with one of the Code Pairs, then the character associated with that code is written to the decompressed file.
 */
		while (bit != TextFile.EOF) {
			if (arrayOfCodePairs.findCode(code) != -1) {
				int position = arrayOfCodePairs.findCode(code);
				char characterToWrite = arrayOfCodePairs.getCharacter(position);
				decompressedFile.writeChar(characterToWrite);
				code = "";
			} else {
				bit = compressedFileName.readBit();
				code += bit;
			}
		}
		
		compressedFileName.close();
		compressionCodesName.close();
		decompressedFile.close();
	}

}
