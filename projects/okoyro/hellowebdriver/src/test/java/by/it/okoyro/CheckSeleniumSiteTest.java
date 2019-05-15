package by.it.okoyro;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class CheckSeleniumSiteTest {
	@Test
	public void checkSeleniumhq() throws Exception {
		WebDriver driver = new ChromeDriver();  // use @Before annotation
		try {
			driver.get("https://google.com");
			WebElement firstElement =(new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.gLFyf.gsfi")));
			firstElement.sendKeys("seleniumhq");
			firstElement.submit();
//			driver.findElement(By.xpath("//input[@class = 'gLFyf gsfi']")).sendKeys("seleniumhq");
//			driver.findElement(By.xpath("//input[@class = 'gLFyf gsfi']")).submit();
			(new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='csb ch']")));
			driver.findElements(By.className("LC20lb")).get(0).click();
			(new WebDriverWait(driver, 5))
					.until(ExpectedConditions.titleIs("Selenium - Web Browser Automation"));

			driver.findElement(By.cssSelector("li#menu_download>a")).click();
			(new WebDriverWait(driver, 5))
								.until(ExpectedConditions.presenceOfElementLocated(By.className("sectionDownload")));
			driver.findElements(By.xpath("//*[@id='nav']//a[text()='Maven Information']")).get(0).click();
			(new WebDriverWait(driver, 5))
											.until(ExpectedConditions.textMatches(By.cssSelector("#mainContent h2"),
																				  Pattern.compile("Maven Information")));
			String dependencyText = driver.findElements(By.tagName("pre")).get(0).getText();
			Assert.assertTrue(dependencyText.contains("<artifactId>selenium-java</artifactId>"));
//			dependencyText.split("<version>(.*)<\\/version>"); add pattern/matcher regexp

		}
		finally {    // use @After annotation
			driver.close();
		}
	}
}

