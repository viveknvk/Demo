package selinium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Puma_assignment {

	WebDriver driver = new ChromeDriver();
	Actions a = new Actions(driver);

	@Test
	public void login() {
		driver.get("https://in.puma.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Assert.assertEquals(
				"Buy Sports T-Shirts, Tracks, Running Shoes and Accessories Online - in.puma.com",
				driver.getTitle());
	}

	@Test
	public void click() throws InterruptedException {

		Thread.sleep(2000);
		WebElement s = driver
				.findElement(By
						.xpath(".//*[@data-subnav='men-subnav'][@class='digimeg-nav-item']"));
		a.moveToElement(s);
		WebElement e = driver.findElement(By
				.xpath(".//*[@id='men-subnav']/div/div/div[2]/ul/li[2]/a"));
		a.moveToElement(e).click(e).perform();

		System.out.println(driver.getTitle());

	}

	@Test
	public void selecting2Product() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		String mainwindow = driver.getWindowHandle();
		driver.switchTo().window(mainwindow);
		driver.findElement(
				By.xpath(".//*[@id='mp-pusher']/div/div[4]/div[2]/div[2]/div[2]/div/ul[1]/li[2]/a[1]"))
				.click();

	}

	@Test
	public void dropdown() throws InterruptedException {
		for (String s : driver.getWindowHandles()) {
			driver.switchTo().window(s);

		}
		System.out.println(driver.getCurrentUrl());
		WebElement drop = driver.findElement(By
				.className("product-size-click-btn"));
		drop.click();
		driver.findElement(
				By.xpath(".//*[@id='configurable_swatch_size']/li[1]")).click();

	}

	@Test
	public void add2cart() throws InterruptedException {
		WebElement addto = driver.findElement(By
				.xpath("//li/span[text()='Product Details']"));
		a.moveToElement(addto).doubleClick();
		// a.keyDown(Keys.TAB);
		// Thread.sleep(40000);
		System.out.println(driver.getCurrentUrl());
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Puma_assignment p = new Puma_assignment();
		p.login();
		p.click();
		p.selecting2Product();
		p.dropdown();
		p.add2cart();
	}

}
