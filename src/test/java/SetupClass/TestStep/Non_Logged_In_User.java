package SetupClass.TestStep;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.SetClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Non_Logged_In_User extends SetClass {
	WebDriverWait wait = new WebDriverWait(driver, 50);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("^user is already on PDP Page MD viii$")
	public void user_is_already_on_PDP_Page_MD_viii() throws Throwable {

		driver.get("https://www.slideteam.net/");
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);

		WebElement popularPPT = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Most Downloaded']")));
		popularPPT.click();
		Thread.sleep(3000);

		WebElement selectPPT = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]")));
		selectPPT.click();
		Thread.sleep(3000);

	}

	@Then("^User click on Download button to download the product viii$")
	public void User_click_on_Download_button_to_download_the_product_viii() throws Throwable {

		WebElement download = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[normalize-space()='Download this presentation']")));
		download.click();
		Thread.sleep(3000);
		/*
		 * WebElement registeredUsers = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.linkText("Registered Users"
		 * )));
		 * 
		 * js.executeScript("arguments[0].click();", registeredUsers);
		 * Thread.sleep(4000);
		 */

	}

	@Then("^user is redirected to Login page viii$")
	public void user_is_redirected_to_Login_page_viii() throws Throwable {

	}

	@Then("^user login with correct details viii$")
	public void user_login_with_correct_details_viii() throws Throwable {
		WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));

		username.sendKeys("sumit.kumar@slidetech.in");
		Thread.sleep(2000);

		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));

		password.sendKeys("redhat2090");
		Thread.sleep(2000);

		WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.id("send2")));

		login_btn.click();
		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//div[@class=' login-attempt-popup']")).isEmpty()) {
			WebElement approve = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirm-approve']")));
			Thread.sleep(3000);
			approve.click();
			Thread.sleep(3000);

			WebElement popularPPT = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Most Downloaded']")));
			popularPPT.click();
			Thread.sleep(3000);

			WebElement selectPPT = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]")));
			selectPPT.click();
			Thread.sleep(3000);
		}
	}

	@Then("^user will be redirected to same pdp page viii$")
	public void user_will_be_redirected_to_same_pdp_page_viii() throws Throwable {

	}

	@Then("^user download the product viii$")
	public void user_download_the_product_viii() throws Throwable {
		Thread.sleep(3000);

		WebElement download_btn_pdp = wait.until(ExpectedConditions.elementToBeClickable(By.id("clicking")));
		js.executeScript("arguments[0].scrollIntoView();", download_btn_pdp);
		Thread.sleep(2000);
		download_btn_pdp.click();
		Thread.sleep(2000);

	}

	@Then("^user logout from website viii$")
	public void user_logout_from_website_viii() throws Throwable {

		Thread.sleep(1000);
		try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(3000);
			}
		} catch (NoSuchElementException Ext) {

		}

		// verify the message after signout
		String verifySignOutMessage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@class='base']"))).getText();
		System.out.println("verifySignOutMessage = " + verifySignOutMessage);
		Assert.assertTrue("user is not logout from the application",
				verifySignOutMessage.contains("YOU ARE NOW LOGGED OUT"));

	}
}
