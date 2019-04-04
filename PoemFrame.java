import java.util.Random;

/**
 * A Mad-libs style "frame" into which words are inserted to make a poem.
 * @Author Forrest Roberts
 * @Version 4-4-19
 */
public class PoemFrame {
    private Random rand;
	private String frame;

	/**
	 * Constructor
	 */
	public PoemFrame(String _frame) {
    	rand = new Random();
		frame = _frame;
	}

	/**
	 * Takes the frame and parses through, inserting words as needed.
	 */
	public String buildFrame(WordLoader wl) {
    	// split up the frame at spaces to parse one word at a time
    	String[] words = frame.split(" ");
		// parse through the words
		String retstr = "";
		for (int i = 0; i < words.length; i++) {
			// DEBUG: output each word
			//System.out.println(words[i]);
			// check for word insertions
			if (words[i].equals("[n]")) {
				retstr += wl.getNoun();
			} else if (words[i].equals("[a]")) {
    			retstr += wl.getAdjective();
			} else if (words[i].equals("[v]")) {
    			retstr += wl.getVerb();
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
			if (rand.nextInt(3) == 1 || wcount == maxwords) {
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

	@Override
	public String toString() {
		return frame;
	}
}

