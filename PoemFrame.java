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

			// insert newlines into string with a random chance
			if (rand.nextInt(3) == 1) {
				// inject a newline
				retstr += "\n";
			} else {
				// put space after word
				retstr += " ";
			}
    	}
		// return the string
		return retstr;
	}

	@Override
	public String toString() {
		return frame;
	}
}

