import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonMethods {
	static WebDriver driver = new ChromeDriver();

	public static void login(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/");

	}

	public static void selectIcon(WebDriver driver, String iconName) {
		WebElement selectIcon = driver.findElement(By.xpath("//h5[text()='" + iconName + "']"));
		selectIcon.click();
	}

	public static void EditIconTextBox(String label, String Text) {
		WebElement selectTextBox = driver
				.findElement(By.xpath("//label[text()='" + label + "']/following-sibling::input"));
		selectTextBox.sendKeys(Text);
	}

	public static String getAttribute(WebDriver driver, By by) {
		String text = driver.findElement(by).getAttribute("value");
		return text;

	}
	public static String getText(WebDriver driver, By by) {
		String text = driver.findElement(by).getAttribute("value");
		return text;

	}

	public static void clear(WebDriver driver, String label) {
		driver.findElement(By.xpath("//label[text()='" + label + "']/following-sibling::input")).clear();
	}

	public static boolean isDisplayed() {
		boolean displayed = driver.findElement(By.xpath(
				"//label[text()='Confirm that edit field is disabled']/following-sibling::input[@disabled='true']"))
				.isDisplayed();
		return displayed;
	}

	//@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
