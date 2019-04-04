/**
 * The "driver" code which actually runs & generates the poem.
 * @Author Forrest Roberts
 * @Version 4-4-19
 */
public class Driver {
    private static RupiBot rupi;
	public static void main(String args[]) {
		rupi = new RupiBot();
		System.out.println("----- a poem by RupiBot v1.0 -----");
		System.out.println(rupi.compose());
	}
}

