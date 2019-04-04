/**
 * A base class for all sorts of words to use in poems.
 * @Author Forrest Roberts
 * @Version 4-4-19
 */
public class Word {
    private String word;
	public Word(String _word) { word = _word; }
	public String getWord() { return word; }
	@Override
	public String toString() { return word; }
}

