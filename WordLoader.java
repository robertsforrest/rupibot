import java.util.Scanner;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * An object responsible for loading and handling words (like a "word factory")
 * @Author Forrest Roberts
 * @Version 4-4-19
 */
public class WordLoader {
	// Object fields
	Scanner load;
	File fread;
	Random rand;
	Word[] nouns, verbs, adjectives;
	PoemFrame[] frames;
	
    /**
     * Constructor method; loads words into arrays from files.
     */
    public WordLoader() {
        // get the random object ready
        rand = new Random();
        
        // load in words from external files
        try {
            // create the word arrays
            nouns = trimArr(readFile("nouns"));
            verbs = trimArr(readFile("verbs"));
            adjectives = trimArr(readFile("adjectives"));

			// read the frames file
			fread = new File("frames");
			load = new Scanner(fread);
			// TODO: clean up this code
			PoemFrame[] tempframes = new PoemFrame[100];
			int counter = 0;
			while (load.hasNextLine()) {
    			if (counter == tempframes.length) {
					PoemFrame[] newtemp = new PoemFrame[tempframes.length*2];
					for (int i = 0; i < tempframes.length; i++) {
						newtemp[i] = tempframes[i];
					}
					tempframes = newtemp;
    			}
				tempframes[counter] = new PoemFrame(load.nextLine());
				counter++;
			}
			// trim down the array
			int newSize = 0;
			for (int i = 0; i < tempframes.length; i++) {
				if (tempframes[i] == null) {
					newSize = i;
					break;
				}
			}
			// copy into new array
			frames = new PoemFrame[newSize];
			for (int i = 0; i < newSize; i++) {
				frames[i] = tempframes[i];
			}
			// close the loader
			load.close();
        } catch (FileNotFoundException e) { System.out.println(e); }

        // print out the words as a test
		//printLoad();
    }
    /**
     * Test output; prints the results of loading in all the words & templates.
     */
    private void printLoad() {
		System.out.println("Printing the nouns...");
		System.out.println("Length: " + nouns.length);
        for (int i = 0; i < nouns.length; i++) {
			System.out.println(nouns[i]);
		}
		System.out.println();
		System.out.println("Printing the verbs...");
		System.out.println("Length: " + verbs.length);
		for (int i = 0; i < verbs.length; i++) {
			System.out.println(verbs[i]);
		}
		System.out.println();
		System.out.println("Printing the adjectives...");
		System.out.println("Length: " + adjectives.length);
		for (int i = 0; i < adjectives.length; i++) {
			System.out.println(adjectives[i]);
		}
		System.out.println();
		System.out.println("Printing the frames...");
		System.out.println("Length: " + frames.length);
		for (int i = 0; i < frames.length; i++) {
			System.out.println(frames[i]);
		}
    }

	/**
	 * Helper methods; reads the words from provided file and returns them in an array.
	 */
    private Word[] readFile(String fname) throws FileNotFoundException {
		// initialize the array
        Word[] ret = new Word[100];
        // open the file for reading
        fread = new File(fname);
		load = new Scanner(fread);
		// loop through and read lines from the file
		int counter = 0;
		while (load.hasNextLine()) {
    		// account for needing to expand the array
			if (counter == ret.length) {
				Word[] newRet = new Word[ret.length*2];
				for (int i = 0; i < ret.length; i++) {
					newRet[i] = ret[i];
				}
				ret = newRet;
			}
    		
    		// load the next line into the return array
			ret[counter] = new Word(load.nextLine());
			counter++;
		}
		// close the file
		load.close();
		// return the array
		return ret;
    }

    /**
     * Helper method which "trims" an array down to size.
     */
    private Word[] trimArr(Word[] wordarr) {
        // step 1: loop through array to find amount of real elements
        int newSize = 0;
        for (int i = 0; i < wordarr.length; i++) {
			if (wordarr[i] == null) {
				newSize = i;
				break;
			}
        }
        // step 2: create a 2nd array of the right size
        Word[] ret = new Word[newSize];
        // step 3: copy old elements into new array
        for (int j = 0; j < newSize; j++) {
			ret[j] = wordarr[j];
        }
        // step 4: return trimmed array
		return ret;
    }

	/**
	 * Provides a poem frame at random from the loaded array.
	 */
	public PoemFrame getFrame() {
		return frames[rand.nextInt(frames.length)];
	}
	
	/**
	 * Provides a noun at random from the loaded array.
	 */
	public Word getNoun() {
    	return nouns[rand.nextInt(nouns.length)];
	}

	/**
	 * Provides a verb at random from the loaded array.
	 */
	public Word getVerb() {
    	return verbs[rand.nextInt(verbs.length)];
	}

	/**
	 * Provides an adjective at random from the loaded array.
	 */
	public Word getAdjective() {
    	return adjectives[rand.nextInt(adjectives.length)];
	}
}

