/* This Class is a setup of basic settings required to load the driver and the site and contains the information
 * regarding the what all necessary actions to be taken before the tests start and after the test ends.
 *
 *
 */

package facebookautomation.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Settings {

	public WebDriver driver;

	@BeforeSuite (alwaysRun = true)
	public void InitialLoad () throws InterruptedException {
		// TODO Auto-generated constructor stub
		final String exe = "chromedriver.exe";
		final String path = getClass ().getClassLoader ()
			.getResource (exe)
			.getPath ();
		final String baseurl = "https:\\www.facebook.com";

		System.setProperty ("webdriver.chrome.driver", path);
		final ChromeOptions options = new ChromeOptions ();
		options.addArguments ("--test-type");
		options.addArguments ("--disable-notifications");
		// options.addArguments("--lang=en-us");
		// options.addArguments("--disable-popup-blocking");

		this.driver = new ChromeDriver (options);

		this.driver.get (baseurl);
		this.driver.manage ()
			.timeouts ()
			.implicitlyWait (10, TimeUnit.SECONDS);
		this.driver.manage ()
			.window ()
			.maximize ();
		final String title = this.driver.getTitle ();
		System.out.println ("Title is " + title);

	}

	@AfterSuite (alwaysRun = true)
	public void teardown () {
		this.driver.quit ();
	}
}
