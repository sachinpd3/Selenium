package Automation.MavenPrac;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Automation.MavenPrac.Base;
import Automation.MavenPrac.HomePage;

public class Signin extends Base
{
	public static	Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	public String val;
	
/*	@BeforeTest
	public void Navigate() throws IOException
	{
		
		
		
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(pp.getProperty("url"));
		log.info("Browser is opened");
	
	}*/
	

@Parameters({"Test"})
@Test
public void SigninPage(String Test) throws IOException, InterruptedException
{
	    
FileInputStream fisexcel=new FileInputStream("C:\\Users\\SACHIN\\Desktop\\Test.xlsx");
XSSFWorkbook workbook=new XSSFWorkbook(fisexcel);
Sheet worksheet=workbook.getSheet("testdata");
int	rowcount=worksheet.getLastRowNum()-worksheet.getFirstRowNum();
for(int i=1;i<rowcount+1;i++)
{
	
Row	rowsheet=worksheet.getRow(i);

if (rowsheet.getCell(0).getStringCellValue().equals(Test))
	
{
	System.out.println(rowsheet.getCell(0).getStringCellValue());
	
	System.out.println(rowsheet.getCell(1).getStringCellValue());
	val=rowsheet.getCell(1).getStringCellValue();
	System.out.println(rowsheet.getCell(2).getStringCellValue());

	driver = initializeDriver();
	driver.manage().window().maximize();
	driver.get(pp.getProperty("url"));
	log.info("Browser is opened");
	
	HomePage hp = new HomePage(driver);
	SignInPage sip =hp.Signin();
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
	String title= driver.getTitle();
	log.info(title);
	//Assert.assertEquals(title, "Create my Google Account");
    sip.UserId().sendKeys(val);
	sip.Next().click();
	log.info("User enter sign in credentials");
	driver.quit();
	
}

}
}



/*@AfterTest
public void close()
{
driver.quit();
}
*/

}
	

	
	
	
