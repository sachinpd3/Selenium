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


public class HomePage
{
	
	WebDriver driver;
	
	public  HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By CreatAccount = By.xpath("//ul[contains(@class,'ltr')]/li[3]/a");
	By NextDetail = By.id("accountDetailsNext");
	By AllLink   = By.tagName("a");
  private  By Signin=	  By.linkText("Sign in");



public WebElement AccountCreate()
{

return driver.findElement(CreatAccount);
}

public SignInPage Signin()
{
driver.findElement(Signin).click();
 SignInPage sp= new SignInPage(driver);
 return sp;
}


public WebElement NextDetail()
{

return driver.findElement(NextDetail);
}


public List<WebElement> AllLinks()
{

return driver.findElements(AllLink);
}

}