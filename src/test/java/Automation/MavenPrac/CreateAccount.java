package Automation.MavenPrac;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Automation.MavenPrac.Base;
import Automation.MavenPrac.HomePage;

public class CreateAccount extends Base
{
	public static	Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void Navigate() throws IOException
	{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(pp.getProperty("url"));
		log.info("Browser is opened");
	}
	
	
@Test
public void CreateAccount() throws IOException, InterruptedException
{
	int counter = 0;
    
	HomePage hp = new HomePage(driver);
	hp.AccountCreate().click();
	
	Set<String> ids = driver.getWindowHandles();
	Iterator<String> itr = ids.iterator();
	//We can also use pp.getProperty("browser").equals"chrome".
	//Only thing is object/variable need to be declared outside the block and public.
	
	if (BrowserName.equals("chrome"))
	{
	String Parent = itr.next();
	}
	String child = itr.next();
	String childn = itr.next();
	driver.switchTo().window(childn);
	Thread.sleep(5000);
	// code to get links count and their name
	System.out.println(hp.AllLinks().size());
	for (int i = 0; i < hp.AllLinks().size() ; i++) 
	{
		System.out.println(hp.AllLinks().get(i).getText());
		hp.AllLinks().get(i).click();
		// Thread.sleep(5000);
	}
//code to iterate on another window
	Set<String> idsn = driver.getWindowHandles();
	Iterator<String> itrn = idsn.iterator();
    
	while (itrn.hasNext())
	{
		driver.switchTo().window(itrn.next());
		System.out.println(driver.getTitle());
	}
	log.info("All links are clicked");

	//Thread.sleep(5000);

}

@AfterTest
public void close()
{
driver.quit();
}


}
	

	
	
	
