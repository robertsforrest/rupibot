/**
 * The "driver" code which actually runs & generates the poem.
 * @Author Forrest Roberts
 * @Version 4-4-19
 */
public class Driver {
    private static RupiBot rupi;
	public static void main(String args[]) {
		rupi = new RupiBot();
		System.out.println(rupi.compose());
	}
}

