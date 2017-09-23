/*This is the Test case, here test is written to login the facebook and post a status.
 * "Settings" class is extended here to perform the initial load and use inheritance.
 *
 */

package facebookautomation.tests;

import org.testng.annotations.Test;

import facebookautomation.pages.FbCheckStatus;
import facebookautomation.pages.FbLogOut;
import facebookautomation.pages.FbLoginPage;
import facebookautomation.pages.FbPostStatus;

/**
 * Test Class.
 *
 * @author DELL
 * @since 15-Aug-2017 6:26:31 PM
 */
public class LoginTest extends Settings {

	/**
	 * @since 15-Aug-2017 6:29:25 PM
	 */
	@Test
	public void loginTest () {
		// TODO Auto-generated constructor stub

		try {
			final FbLoginPage fblgn = new FbLoginPage (this.driver);
			fblgn.fbLogin ("username", "password"); // Enter your FB Username and Password Here!
			final String text = this.driver.getTitle ();
			System.out.println ("Text is:" + text);
			if (text.equals ("Facebook")) {
				System.out.println ("Login Successful!!");

			}
			else {
				System.out.println ("Login Invalid!!");
			}

		}
		catch (final Throwable e) {
			System.out.println ("Invalid Login!!" + e.getMessage ());
			this.driver.quit ();
		}

		final FbPostStatus pstatus = new FbPostStatus (this.driver);
		pstatus.postStatus ("Test Run by Bot9 #fk!!"); //Enter the text you want to post as your FB Status!

		final FbCheckStatus postChk = new FbCheckStatus (this.driver);
		postChk.checkStatus ();

		final FbLogOut fbl = new FbLogOut (this.driver);
		fbl.logOutFb ();
		System.out.println ("LogOut Successful");

	}
}
