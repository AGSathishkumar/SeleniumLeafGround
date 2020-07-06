

import org.openqa.selenium.By;
import org.openqa.selenium.remote.Command;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Edit extends CommonMethods {

	@Test
	public static void EditFeature() throws InterruptedException {
		CommonMethods.login(driver);
		CommonMethods.selectIcon(driver, "Edit");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Work with Edit Fields')]")).getText(),
				"Work with Edit Fields");
		EditIconTextBox("Enter your email address", "Test@test.com");
		Thread.sleep(1000);	
		EditIconTextBox("Append a text and press keyboard tab", "Test@test.com");
		Thread.sleep(1000);
		By getvalue = By.xpath("//label[text()='Get default text entered']/following-sibling::input");
		Assert.assertEquals(CommonMethods.getText(driver, getvalue), "TestLeaf");
		CommonMethods.clear(driver, "Clear the text");
		Assert.assertEquals(CommonMethods.isDisplayed(), true);
	}
}
