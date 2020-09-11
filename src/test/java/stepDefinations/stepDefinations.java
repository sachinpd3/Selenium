package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Automation.MavenPrac.Base;
import Automation.MavenPrac.HomePage;
import Automation.MavenPrac.SignInPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinations extends Base
{
public static	Logger log = LogManager.getLogger(Base.class.getName());

@Given("^User has opened \"([^\"]*)\" and navigate to login page$")
public void user_has_opened_and_navigate_to_login_page(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions

	driver = initializeDriver();
	driver.manage().window().maximize();
	driver.get(arg1);
	log.info("Browser is opened");
}


@When("^User login using  (.+) and (.+)$")
	public void user_login_using_and(String arg1, String arg2) throws InterruptedException
	{
	System.out.println("User  login using username and password");
	System.out.println(arg1);
	System.out.println(arg2);
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
    sip.UserId().sendKeys(arg1);
	sip.Next().click();
	log.info("User enter sign in credentials");
	driver.quit();
	
	}
	
	
@Then("^Home Page is not populated$")
public void home_Page_is_not_populated() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}
	
}

