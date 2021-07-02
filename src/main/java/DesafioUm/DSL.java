package DesafioUm;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DSL {

	private WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	public void selectElement(By by) {
		driver.findElement(by).click();
	}

	public void setInputs(String id, String value) {
		WebElement element = driver.findElement(By.id(id));
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);
	}

	public void NotMustFindElement(String className, String param) {
		List<WebElement> element = (List<WebElement>) driver.findElements(By.className(className));

		boolean hasCity = false;
		for (WebElement doctor : element) {
			if (doctor.getText().contains(param)) {
				hasCity = true;
			}
		}
		Assert.assertEquals(hasCity, false);
	}

	public void MustFindElement(String className, String param) {
		List<WebElement> element = (List<WebElement>) driver.findElements(By.className(className));

		boolean hasCity = false;
		for (WebElement doctor : element) {
			if (doctor.getText().contains(param)) {
				hasCity = true;
			}
		}
		Assert.assertEquals(true, hasCity);
	}

	public void nextPageResults() {
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//*[@id=\"gm-v3-root\"]/div/div[2]/div[2]/div[1]/div[3]/button")).click();
		}
	}
}
