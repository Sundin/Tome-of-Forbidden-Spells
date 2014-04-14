package metal.gustav.namegenerator;
import java.io.FileNotFoundException;
import java.io.IOException;

//TOFS: Tome of Forbidden Spells


public class TOFSNameGen {
	private static boolean showTypeOfSentence = false;
	private static boolean onlyTestSentences = false;

	public static void main(String[] args) throws IOException, FileNotFoundException {
		
//		int genre = 0; //0=alla, 1 = Fantasy, 2 = Thrash, 3 = RnR

		new InputView();
		
	}
	
	public static void generate(int genre, int numberOfNames, int testMode) throws FileNotFoundException, IOException {
		Words.setGenre(genre);
		
		if (testMode == 0) {
			showTypeOfSentence = false;
			onlyTestSentences = false;
		} else if (testMode == 1) {
			showTypeOfSentence = true;
			onlyTestSentences = false;
		} else if (testMode == 2) {
			showTypeOfSentence = true;
			onlyTestSentences = true;
		}

		String[] result = new String [numberOfNames];
		for (int i = 0; i < numberOfNames; i++) {

			if (onlyTestSentences) {
				result[i] = Words.getTestSentence();
			} else {
				result[i] = Words.getSentence();
			}

			if (!showTypeOfSentence) {
				result[i] = result[i].substring(4);
			}
		}

		for (String d : result) {
			d = Decoder.decode(d);
			System.out.println(d);
		}
	}

	public static String removeCharAt(String s, int pos) {
		return s.substring(0,pos)+s.substring(pos+1);
	}
}