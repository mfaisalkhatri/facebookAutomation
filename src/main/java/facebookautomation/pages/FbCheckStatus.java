/**
 *
 */
package facebookautomation.pages;

import static facebookautomation.pages.Sleeper.sleep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author DELL
 * @since 25-Aug-2017 11:28:58 AM
 */
public class FbCheckStatus {

	private final WebDriver driver;

	public FbCheckStatus (final WebDriver driver) {
		this.driver = driver;
	}

	public void checkStatus () {
		final By post = By.cssSelector ("._1dwg._1w_m");
		final WebElement postChk = this.driver.findElement (post);
		final WebElement mainPost = postChk.findElement (By.tagName ("p"));
		// postChk.click ();

		sleep ();
		final String mainPostTxt = mainPost.getText ();
		final String statusPosted = "This is the status posted via Test 1.";

		Assert.assertEquals (statusPosted, mainPostTxt);
	}
}
