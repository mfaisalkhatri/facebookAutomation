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

		final String usrName = "userName@gmail.com "; // Enter FB UserName here.
		final String password = "Password"; // Enter FB Password here.
		final String title = "Facebook";
		final String fbPost = "This is the Status posted via Test 1"; // Enter your FB Status here.

		try {
			final FbLoginPage fblgn = new FbLoginPage (this.driver);
			fblgn.fbLogin (usrName, password);
			final String text = this.driver.getTitle ();
			System.out.println ("Text is:" + text);

			if (text.equals (title)) {
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
		pstatus.postStatus (fbPost);

		final FbCheckStatus postChk = new FbCheckStatus (this.driver);
		postChk.checkStatus ();
		final FbLogOut fbl = new FbLogOut (this.driver);
		fbl.logOutFb ();
		System.out.println ("LogOut Successful");

	}
}
