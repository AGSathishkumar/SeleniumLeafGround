import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	

	/**
	 * 
	 */
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		System. setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver.get("http://www.leafground.com/");

	}
}
