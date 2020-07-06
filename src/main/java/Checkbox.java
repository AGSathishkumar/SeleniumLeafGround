import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkbox extends CommonMethods{
	
	@Test
	public static void CheckBoxFeature() throws InterruptedException
	{
		CommonMethods.login(driver);
		CommonMethods.selectIcon(driver, "Checkbox");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Interact with Checkboxes')]")).getText(),
				"Interact with Checkboxes");
		selectCheckBox("SQL");
		boolean displayed = driver.findElement(By.xpath("//div[text()='Selenium']/input[@checked]")).isDisplayed();
		if(displayed==true)
		{
			System.out.println("Selenium checkboxis selected");
		}
		else
		{
			System.out.println("Selenium checkbox is not selected");
		}
		driver.findElement(By.xpath("//div[@class='example'][2]//following::label[text()='DeSelect only checked']/following-sibling::div/input[@checked]")).click();
		
		List<WebElement> sizeelement=driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::div/input"));
		int size = sizeelement.size();
		for(int i=1;i<=size;i++)
		{
			driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::div[ "+i+"]/input")).click();
		}
		Thread.sleep(5000);
		
		
		
	}
	public static void selectCheckBox(String label)
	{
		driver.findElement(By.xpath("//div[text()='"+label+"']/input")).click();
	}

}
