/**
 *
 */
package facebookautomation.pages;

public class Sleeper {

	public static void sleep () {

		try {
			Thread.sleep (3000);
		}
		catch (final InterruptedException e) {
			e.printStackTrace ();
		}
	}

	private Sleeper () {
	}

}
