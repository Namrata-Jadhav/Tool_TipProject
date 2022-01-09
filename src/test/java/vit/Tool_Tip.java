package vit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Tool_Tip {

	WebDriver driver = new ChromeDriver();

	@Before
	public void setUp() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://demoqa.com/tool-tips/");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void droDown() {
		
		WebElement hoverButton = driver.findElement(By.id("toolTipButton"));
		
		Actions act = new Actions(driver);
		act.moveToElement(hoverButton).build().perform();
		
		
		WebElement HoverText = driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		
		String htext = HoverText.getText();
		
		System.out.println("suggestion text is : "+htext);
	    Assert.assertEquals("You hovered over the Button", htext);
					
	}
	
	@After
	public void tearDown() {
	driver.quit();
	}
}

