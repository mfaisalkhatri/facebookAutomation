/**
 *
 */
package facebookautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Faisal Khatri
 * @since 25-Aug-2017 11:29:10 AM
 */
public class FbLogOut {

	private static WebDriver driver;

	public FbLogOut (final WebDriver driver) {
		FbLogOut.driver = driver;
	}

	public void logOutFb () {

		final WebDriverWait wait = new WebDriverWait (driver, 10);

		final By nvgtpanel = By.cssSelector ("#userNavigationLabel");
		final WebElement navigation = wait.until (ExpectedConditions.elementToBeClickable (nvgtpanel));

		System.out.println ("Waiting  for LogOut!!");
		final Actions act = new Actions (driver);
		act.moveToElement (navigation)
			.click ()
			.build ()
			.perform ();

		final By logOBtn = By.linkText ("Log out");

		final WebElement logOutBtn = wait.until (ExpectedConditions.visibilityOfElementLocated (logOBtn));
		act.moveToElement (logOutBtn)
			.click ()
			.build ()
			.perform ();
		System.out.println ("Clicked on LogOut!");
	}

}
