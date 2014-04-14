package metal.gustav.namegenerator;
import java.io.*;
import java.util.*;

public class Words {
	private static int genre;
	
	public static void setGenre(int g) {
		genre = g;
	}
	
	public static String getSentence() throws IOException, FileNotFoundException {
		return getWord("sentences.txt");
	}
	
	public static String getTestSentence() throws IOException, FileNotFoundException {
		return getWord("testingFile.txt");
	}
	
	public static String getAdjective () throws IOException, FileNotFoundException {
		return getWord("adjectiveT.txt");
	}
	
	public static String getConcreteNoun () throws IOException, FileNotFoundException { //konkreta substantiv
		return getWord("concreteNounT.txt");
	}
	
	public static String getAbstractNoun () throws IOException, FileNotFoundException { //abstrakta substantiv
		return getWord("abstractNounT.txt");
	}
	
	public static String getItem () throws IOException, FileNotFoundException { //abstrakta substantiv
		return getWord("itemT.txt");
	}
	
	public static String getVerb () throws IOException, FileNotFoundException {
		return getWord("verbT.txt");
	}
	
	public static String getPeople () throws IOException, FileNotFoundException {
		return getWord("peopleT.txt");
	}
	
	public static String getBeasts () throws IOException, FileNotFoundException {
		return getWord("beastsT.txt");
	}
	
	public static String getBeginningPhrase () throws IOException, FileNotFoundException {
		return getWord("beginningPhrase.txt");
	}
	
	public static String getEndPhrase () throws IOException, FileNotFoundException {
		return getWord("endPhrase.txt");
	}
	
	private static String getWord (String filename) throws IOException, FileNotFoundException {
		InputStream in = Words.class.getResourceAsStream("/data/"+filename);

		Scanner sc = new Scanner (in);
		Random number = new Random();
		
		List<String> words = new ArrayList<String>();
		
		int i = 0;
		while (sc.hasNext()) {
			words.add(sc.nextLine());
			String s = words.get(i);
			if (s.charAt(genre) == '-')
				words.remove(i);
			else
				i++;
		}
		int randomWord = number.nextInt(i);
		
		String s = words.get(randomWord);
		s = s.substring(0,1)+s.substring(5);
		return s;
	}
}
