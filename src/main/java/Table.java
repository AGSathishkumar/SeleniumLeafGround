import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Table extends CommonMethods {

	@Test
	public static void TableFeature() {
		CommonMethods.login(driver);
		CommonMethods.selectIcon(driver, "Table");
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Toy with Tables')]")).getText(),
				"Toy with Tables");
		// firstWay
		List<WebElement> column = driver.findElements(By.xpath("//table[@id='table_id']//th"));
		System.out.println("Column Size" + column.size());
		List<WebElement> row = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[1]"));
		System.out.println("row Size" + row.size());
		String text = driver.findElement(By.xpath(
				"//table[@id='table_id']//tr//td[text()='Learn to interact with Elements']/following-sibling::td[1]"))
				.getText();
		System.out.println("Progress" + text);
		ArrayList<String> obtainedList = new ArrayList<String>();
		List<WebElement> Progresslist = driver.findElements(By.xpath("//table[@id='table_id']//tr//td[2]"));
		String[] split = null;
		List<String> Progresslists = new ArrayList<String>();
		for (WebElement webElement : Progresslist) {
			split = webElement.getText().split("%");
			Progresslists.add(split[0]);
		}
		List<Integer> listInteger = Progresslists.stream().map(Integer::parseInt).collect(Collectors.toList());
		int indexOf = listInteger.indexOf(Collections.max(listInteger));
		driver.findElement(By.xpath("//table[@id='table_id']//tr[" + (indexOf + 2) + "]//td[3]/input")).click();
	}

}
