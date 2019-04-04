import java.util.Random;

/**
 * A Mad-libs style "frame" into which words are inserted to make a poem.
 * @Author Forrest Roberts
 * @Version 4-4-19
 */
public class PoemFrame extends Word {
    private Random rand;

	/**
	 * Constructor
	 */
	public PoemFrame(String _frame) {
		super(_frame);
    	rand = new Random();
	}

	/**
	 * Takes the frame and parses through, inserting words as needed.
	 */
	@Override
	public String buildFrame(WordLoader wl) {
    	// split up the frame at spaces to parse one word at a time
    	String[] words = getWord().split(" ");
		// parse through the words
		String retstr = "";
		for (int i = 0; i < words.length; i++) {
			// check for word insertions
			// insert a noun
			if (words[i].equals("[n]")) {
				retstr += wl.getNoun();

			// insert an adjective
			} else if (words[i].equals("[a]")) {
    			retstr += wl.getAdjective();

    		// insert a verb
			} else if (words[i].equals("[v]")) {
    			retstr += wl.getVerb();

    		// insert a noun, augmented by an adjective
			} else if (words[i].equals("[a-n]")) {
				Word noun = wl.getNoun();
				if (noun.getWord().contains(" ")) {
					// if the noun has a space, place adjective between article and noun
					String[] splitNoun = noun.getWord().split(" ");
					retstr += splitNoun[0] + " ";	// put the article
					retstr += wl.getAdjective();	// put the adjective
					for (int j = 1; j < splitNoun.length; j++) {
    					// put the rest of the noun
    					retstr += " " + splitNoun[j];
					}
				} else {
    				// if the noun is one-word, just put them both in regularly
    				retstr += wl.getAdjective();
    				retstr += noun;
				}
    			
			} else {
    			retstr += words[i];
			}
			retstr += " ";
    	}
    	// insert newlines at random into the poem
    	// use a counter to ensure a newline occurs at least once every 5 words
    	int wcount = 0, maxwords = 5;
    	String[] retwords = retstr.split(" ");
		String newretstr = "";
    	for (int i = 0; i < retwords.length; i++) {
			newretstr += retwords[i];
			if ((rand.nextInt(3) == 1 || wcount == maxwords) && i < retwords.length-1) {
    			newretstr += "\n";	// inject newline escape character
    			wcount = 0;
			} else {
				newretstr += " ";	// in the absence of newline, put a space
			}
			wcount++;
    	}
		// return the string
		return newretstr;
	}
}

