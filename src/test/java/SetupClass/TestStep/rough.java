package SetupClass.TestStep;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rough {
	static WebDriver driver;
	protected static WebDriverWait wait;
	protected static JavascriptExecutor js;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 50);
		js = (JavascriptExecutor) driver;
		Thread.sleep(1000);

		long start = System.currentTimeMillis();
		System.out.println("start" + start);
		driver.get("https://www.slideteam.net/");

		WebElement ele = driver.findElement(By.xpath("//a[normalize-space()='Sign In']"));
		long finish = System.currentTimeMillis();
		System.out.println("finish" + finish);
		
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);
	}

}
