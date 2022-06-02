package SetupClass.TestStep;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Non_Logged_In_User extends Set {
	WebDriverWait wait = new WebDriverWait(driver,50);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       
       @Given("^user is already on PDP Page MD viii$")
	public void user_is_already_on_PDP_Page_MD_viii() throws Throwable {
		
		driver.get("https://www.slideteam.net/");
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		driver.get("https://www.slideteam.net/change-management-powerpoint-presentation-slides.html");
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	    
	}

	@Then("^User click on Download button to download the product viii$")
	public void User_click_on_Download_button_to_download_the_product_viii() throws Throwable {
	    
		 WebElement download = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Download this presentation']")));
	         download.click();
	         Thread.sleep(3000);
	         WebElement registeredUsers = wait
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Registered Users")));
	 
	         js.executeScript("arguments[0].click();", registeredUsers);
		 Thread.sleep(4000);
		
		
	}

	@Then("^user is redirected to Login page viii$")
	public void user_is_redirected_to_Login_page_viii() throws Throwable {
	   
	}
  
  @Then("^user login with correct details viii$")
	public void user_login_with_correct_details_viii() throws Throwable {
		WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		
		username.sendKeys("sumit@slideteam.net");
		Thread.sleep(2000);
		
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
		
		password.sendKeys("sumittest@21234");
		Thread.sleep(2000);
		
		WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.id("send2")));
	
		login_btn.click();
		Thread.sleep(2000);
		
		
	}

	@Then("^user will be redirected to same pdp page viii$")
	public void user_will_be_redirected_to_same_pdp_page_viii() throws Throwable {
	   
	}

	@Then("^user download the product viii$")
	public void user_download_the_product_viii() throws Throwable {
		Thread.sleep(3000);
	   
		
		WebElement download_btn_pdp= wait.until(ExpectedConditions.elementToBeClickable(By.id("clicking")));
		js.executeScript("arguments[0].scrollIntoView();",download_btn_pdp);	
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
				Thread.sleep(8000);
			}
		} catch (NoSuchElementException Ext) {

		}
		
		// verify the message after signout
		String verifySignOutMessage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@class='base']"))).getText();

		Assert.assertTrue("user is not logout from the application",
				verifySignOutMessage.contains("YOU ARE NOW LOGGED OUT"));
		
	}
}
