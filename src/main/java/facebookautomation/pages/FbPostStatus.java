package facebookautomation.pages;

import static facebookautomation.pages.Sleeper.sleep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FbPostStatus {

	private final WebDriver driver;

	public FbPostStatus (final WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	/**
	 * This Method is used to update FB Status!!
	 *
	 * @param Status
	 * @since 20-Aug-2017 11:29:03 AM
	 */
	public void postStatus (final String Status) {

		final WebDriverWait wait = new WebDriverWait (this.driver, 20);
		final By statbx = By.id ("pagelet_composer");
		final WebElement statsbox = this.driver.findElement (statbx);

		final By statusbox = By.name ("xhpc_message");
		final WebElement sbx = statsbox.findElement (statusbox);
		final Actions action = new Actions (this.driver);
		action.moveToElement (sbx)
			.click ()
			.sendKeys (Status)
			.build ()
			.perform ();
		sleep ();

		final By pbtn = By.tagName ("button");
		final WebElement postbtn = statsbox.findElement (pbtn);
		this.driver.manage ()
			.timeouts ()
			.implicitlyWait (5, TimeUnit.SECONDS);

		postbtn.click ();
		sleep ();
		System.out.println ("Fb status Posted!!");

		final By header = By.cssSelector ("._2t-a._50tj");
		final WebElement hdr = this.driver.findElement (header);

		final By profile = By.linkText ("Mohammad Faisal");
		final WebElement prfle = hdr.findElement (profile);

		final Actions act = new Actions (this.driver);
		act.moveToElement (prfle)
			.click ()
			.build ()
			.perform ();
		sleep ();
		System.out.println ("Profile Clicked!");

	}

}
