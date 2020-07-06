import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dropdown extends CommonMethods {
	@Test
	public void dropdownFeature() throws InterruptedException {
		CommonMethods.login(driver);
		CommonMethods.selectIcon(driver, "Drop down");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Learn Listboxes')]")).getText(),
				"Learn Listboxes");
		WebElement firstDropdown = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select dropdown = new Select(firstDropdown);
		dropdown.selectByIndex(1);
		WebElement secondDropdown = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select dropdown1 = new Select(secondDropdown);
		dropdown1.selectByVisibleText("Appium");
		WebElement thirdDropdown = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select dropdown2 = new Select(thirdDropdown);
		dropdown2.selectByValue("2");
		WebElement fourthDropdown = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select dropdown3 = new Select(fourthDropdown);
		List<WebElement> options = dropdown3.getOptions();
		System.out.println("Size" + options.size());
		//using sendkeys selecting dropdown is not completed
		driver.findElement(By.xpath("//select[@multiple]//following::option[text()='Appium']")).click();


	}
}
