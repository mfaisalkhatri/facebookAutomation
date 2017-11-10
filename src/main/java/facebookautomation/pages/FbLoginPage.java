/*
This Class finds the page elements of the Login Page,i.e User Id, Password and Login Button and creates a dynamic
query so that user can use the same while creating the tests.


*/
package facebookautomation.pages;

import static facebookautomation.pages.Sleeper.sleep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FbLoginPage {

	private final WebDriver	driver;
	private WebDriverWait	wait;

	public FbLoginPage (final WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		// wait = new WebDriverWait(driver, 5);
	}

	public void fbLogin (final String username, final String password) {
		// TODO Auto-generated constructor stub

		final By usrid = By.cssSelector ("#email");
		final By passw = By.cssSelector ("#pass");
		final By loginbtn = By.cssSelector ("#loginbutton");

		final WebElement userid = this.driver.findElement (usrid);
		final WebElement passwrd = this.driver.findElement (passw);
		final WebElement loginbttn = this.driver.findElement (loginbtn);

		userid.clear ();
		userid.sendKeys (username);
		sleep ();
		passwrd.clear ();
		passwrd.sendKeys (password);
		sleep ();
		loginbttn.click ();

	}

}
