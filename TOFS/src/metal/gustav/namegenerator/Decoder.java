package metal.gustav.namegenerator;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Decoder {

	public static String decode (String sentence) throws FileNotFoundException, IOException {
		sentence = sentence.replace("BEG_PHRASE", Words.getBeginningPhrase());
		
		sentence = sentence.replace("END_PHRASE", Words.getEndPhrase());

		sentence = sentence.replace("ABS_NOUN", Words.getAbstractNoun());

		while (sentence.contains("ADJECTIVE")) {
			sentence = sentence.replaceFirst("ADJECTIVE", Words.getAdjective());
		}
		
		sentence = sentence.replace("CONC_NOUN", Words.getConcreteNoun());
		
		sentence = sentence.replace("PEOPLE", Words.getPeople());
				
		sentence = sentence.replace("BEAST", Words.getBeasts());
				
		sentence = sentence.replace("ITEM", Words.getItem());
		
		sentence = sentence.replace("VERB", Words.getVerb());
		
		sentence = sentence.replace(".", "");

		sentence = sentence.replace("**", "The ");
		sentence = sentence.replace ("*", "");
		
		return sentence;
	}
}

