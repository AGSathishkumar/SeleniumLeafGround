import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Button extends CommonMethods {

	@Test
	public static void ButtonFeature() throws InterruptedException
	{

		CommonMethods.login(driver);
		CommonMethods.selectIcon(driver, "Button");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Bond with Buttons')]")).getText(),
				"Bond with Buttons");
		driver.findElement(By.xpath("//button[@id='home']")).click();
		WebElement getHeadingInHomePage = driver.findElement(By.xpath("//h1[@itemprop='name']"));
		Thread.sleep(2000);
		Assert.assertEquals(getHeadingInHomePage.getText(), "Locators and Selenium Interactions");
		CommonMethods.selectIcon(driver, "Button");
		WebElement ele = driver.findElement(By.xpath("//button[@id='position']"));
		Point location = ele.getLocation();
		System.out.println("Location" + location);
		System.out.println("X" + location.getX());
		System.out.println("Y" + location.getY());
		System.out.println(location.x);
		System.out.println(location.y);
		WebElement findColor=driver.findElement(By.xpath("//button[@id='color']"));
		System.out.println("Color"+findColor.getCssValue("color"));
		System.out.println(findColor.getAttribute("background"));
		System.out.println(findColor.getAttribute("style"));
		System.out.println(findColor.getAttribute("background-color")); 
		System.out.println(findColor.getCssValue("style"));
		System.out.println(findColor.getCssValue("color"));
		WebElement findSize=driver.findElement(By.xpath("//button[@id='size']"));
		Rectangle rect = driver.findElement(By.xpath("//button[@id='size']")).getRect();
		System.out.println("hashcode"+findSize.hashCode());
		System.out.println("height"+rect.getHeight());
		System.out.println("width"+rect.getWidth());
		System.out.println("dimension"+rect.getDimension());
		System.out.println("point"+rect.getPoint());
		System.out.println("size"+findSize.getSize());		
	
	}
	
}

