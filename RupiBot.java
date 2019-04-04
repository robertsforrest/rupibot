/**
 * A simple bot that generates bad poems in the vein of Rupi Kaur.
 * @Author Forrest Roberts
 * @Version 4-4-19
 */
public class RupiBot {
    // Object fields
	WordLoader wl;

	/**
	 * Constructor; gets shit ready to go.
	 */
	public RupiBot() {
		wl = new WordLoader();
	}
    
    /**
     * Method which actually composes and returns the poem.
     */
	public String compose() {
    	PoemFrame pf = wl.getFrame();
    	return pf.buildFrame(wl);
	}
}

