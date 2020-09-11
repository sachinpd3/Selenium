package Automation.MavenPrac;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SignInPage
{
	
	WebDriver driver;
	
	public  SignInPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Next = By.xpath("//div[(@class='VfPpkd-RLmnJb')]");
	By UserId = By.xpath("//input[@id='identifierId']");
	

public WebElement UserId()
{
return driver.findElement(UserId);
}


public WebElement Next()
{
return driver.findElement(Next);
}

}