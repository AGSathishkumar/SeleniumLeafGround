import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLink extends CommonMethods {

	@Test
	public void HyperLinkFeature() {
		CommonMethods.login(driver);
		CommonMethods.selectIcon(driver, "HyperLink");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Play with HyperLinks')]")).getText(),
				"Play with HyperLinks");
		WebElement firstLink = driver.findElement(By.xpath(
				"//label[text()='(Interact with same link name)']/preceding-sibling::a/preceding::a[text()='Go to Home Page']"));
		firstLink.click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//h1[contains(text(),'Locators and Selenium Interactions')]")).getText(),
				"Locators and Selenium Interactions");
		CommonMethods.selectIcon(driver, "HyperLink");
		WebElement secondLink = driver.findElement(
				By.xpath("//a[@href='Button.html' and text()='Find where am supposed to go without clicking me?']"));
		secondLink.click();
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Bond with Buttons')]")).getText(),
				"Bond with Buttons");
		driver.findElement(By.xpath("//button[@id='home']")).click();
		CommonMethods.selectIcon(driver, "HyperLink");
		WebElement third = driver.findElement(By.xpath("//a[ text()='Verify am I broken?']"));
		String attribute = third.getAttribute("href");
		if (attribute.contains("error")) {
			System.out.println("Error - Link is broken");
			//Assert.fail();
		} else {
			System.out.println("No Error - Link is not broken");
		}
		WebElement ele = driver
				.findElement(By.xpath("//label[text()='(Interact with same link name)']/preceding-sibling::a"));
		ele.click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//h1[contains(text(),'Locators and Selenium Interactions')]")).getText(),
				"Locators and Selenium Interactions");
		CommonMethods.selectIcon(driver, "HyperLink");
		 java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		 
		 System.out.println(links.size());
		 
		 for (int i = 1; i<=links.size()-1; i=i+1)
		 
		 {
		 
		 System.out.println(links.get(i).getText());
		 }
		 
		 }
	}


