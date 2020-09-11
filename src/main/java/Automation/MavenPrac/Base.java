package Automation.MavenPrac;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base
{
public WebDriver driver;
public Properties pp;
public String BrowserName;
	
public WebDriver initializeDriver() throws IOException
	{
	pp = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\SACHIN\\eclipse-workspace\\MavenPrac\\src\\main\\java\\Automation\\MavenPrac\\Global.properties");
		pp.load(fis);
		BrowserName=pp.getProperty("browser");
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SACHIN\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("firefox"))
		{
		driver = new FirefoxDriver();
	     }
			else
			{
				System.setProperty("webdriver.ie.driver", "C:\\Users\\SACHIN\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	


public String getscreenshot(String TestCaseName,WebDriver driver) throws IOException

{
	
   TakesScreenshot scrShot =(TakesScreenshot)driver;
    File SrcFile  =   scrShot.getScreenshotAs(OutputType.FILE);
    int counter=0;
	String DestFile=System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
	FileUtils.copyFile(SrcFile, new File(DestFile));
	return DestFile;
}

}
