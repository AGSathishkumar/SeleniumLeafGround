import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButton extends CommonMethods {
	@Test
	public void RadiobuttonFeatures() throws InterruptedException {
		CommonMethods.login(driver);
		CommonMethods.selectIcon(driver, "Radio Button");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Play with Radio Buttons')]")).getText(),
				"Play with Radio Buttons");
		driver.findElement(By.xpath("//div[@id='first']//following-sibling::input[@id='yes']")).click();
		Thread.sleep(4000);
		WebElement findElement = driver.findElement(
				By.xpath("//label[text()='Find default selected radio button']/following::label/input[@checked]"));
		System.out.println("Default selected Radio button" + findElement.getAttribute("value"));
		WebElement ele = driver
				.findElement(By.xpath("//label[contains(text(),'Select your age group')]/following::input[@checked]"));
		boolean displayed = ele.isDisplayed();
		System.out.println(displayed);
		if (displayed == true) {
			System.out.println("Already Selected");
		} else {
			driver.findElement(By.xpath("//label[contains(text(),'Select your age group')]/following::input[@checked]"))
					.click();
			System.out.println("Now Element is got selected");
		}
	}
}
