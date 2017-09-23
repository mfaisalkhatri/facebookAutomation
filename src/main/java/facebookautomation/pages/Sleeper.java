/**
 *
 */
package facebookautomation.pages;

/**
 * @author DELL
 * @since 26-Aug-2017 5:51:24 PM
 */
public class Sleeper {

	public static void sleep () {

		try {
			Thread.sleep (2000);
		}
		catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace ();
		}
	}

	/**
	 * @since 26-Aug-2017 5:52:09 PM
	 */
	private Sleeper () {
		// TODO Auto-generated constructor stub
	}

}
