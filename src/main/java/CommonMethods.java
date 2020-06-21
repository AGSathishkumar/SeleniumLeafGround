import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonMethods {

	public static void selectIcon(WebDriver driver,String iconName)
	{
		WebElement selectIcon = driver.findElement(By.xpath("//h5[text()='"+iconName+"']"));
		selectIcon.click();
	}
}
