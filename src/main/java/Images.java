import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Images extends CommonMethods {

	@Test
	public static void ImageTestcase() {
		CommonMethods.login(driver);
		CommonMethods.selectIcon(driver, "Image");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Interact with Images')]")).getText(),
				"Interact with Images");
		WebElement firstLinkImage = driver
				.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img"));
		firstLinkImage.click();

		Assert.assertEquals(
				driver.findElement(By.xpath("//h1[contains(text(),'Locators and Selenium Interactions')]")).getText(),
				"Locators and Selenium Interactions");
		CommonMethods.selectIcon(driver, "Image");
		WebElement brokenImage = driver
				.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img"));
		if (brokenImage != null) {
			verifyimageActive(brokenImage);
		}
		Actions action = new Actions(driver);
		WebElement link = driver
				.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img"));
		action.click((link)).perform();
		Assert.assertEquals(
				driver.findElement(By.xpath("//h1[contains(text(),'Locators and Selenium Interactions')]")).getText(),
				"Locators and Selenium Interactions");
		CommonMethods.selectIcon(driver, "Image");
	}

	public static void verifyimageActive(WebElement imgElement) {
		int invalidImageCount = 0;

		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
