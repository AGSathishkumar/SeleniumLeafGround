import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Base extends CommonMethods {
	static WebDriver driver = new ChromeDriver();

	@Test
	public static void Testcases1() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver.get("http://www.leafground.com/");
		CommonMethods.selectIcon(driver, "Edit");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Work with Edit Fields')]")).getText(),
				"Work with Edit Fields");
	}
}
