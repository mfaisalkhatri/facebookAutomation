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
		this.driver = driver;
	}

	public void postStatus (final String status) {

		final WebDriverWait wait = new WebDriverWait (this.driver, 10);
		final By statbx = By.id ("pagelet_composer");
		WebElement statsbox = this.driver.findElement (statbx);

		final By statusbox = By.name ("xhpc_message");

		final WebElement sbx = statsbox.findElement (statusbox);

		sbx.click ();

		final By editBox = By.cssSelector ("div.notranslate._5rpu");
		statsbox = this.driver.findElement (statbx);
		final WebElement post = statsbox.findElement (editBox);
		post.clear ();

		final char [] chars = status.toCharArray ();
		for (final char c : chars) {
			post.sendKeys (Character.toString (c));
		}

		sleep ();

		final By pbtn = By.tagName ("button");
		final WebElement postbtn = statsbox.findElement (pbtn);
		this.driver.manage ()
			.timeouts ()
			.implicitlyWait (5, TimeUnit.SECONDS);

		postbtn.click ();
		sleep ();
		System.out.println ("Fb status Posted!!");

		final String profileName = "Your Name"; // Enter the Profile Name here.
		final By header = By.cssSelector ("._2t-a._50tj");
		final WebElement hdr = this.driver.findElement (header);

		final By profile = By.linkText (profileName);
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
