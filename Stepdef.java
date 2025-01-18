package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdef {
	
	//Creating object of webdriver
	 WebDriver driver;
	
	//Creating object of page object class 


	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABHILAS\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//initialize the object of login page
		

		
	}

	@When("user open URL {string}")
	public void user_open_url(String url) {
		

		driver.get("https://www.facebook.com");
	}
       
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		 loginpage loginpg = new loginpage(driver);

		//Using login page object to enter email and paswword
		loginpg.enterusername("email");
		loginpg.enterpwd("password");
	}
	
	
	@When("click on login")
	public void click_on_login() {
		 loginpage loginpg = new loginpage(driver);

		loginpg.clickonloginbutton();

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expeectedtitle)
	{
		
         String actualtitle = driver.getTitle();
        		 
        		 if(actualtitle.equals(expeectedtitle))
        		 {
        			 Assert.assertTrue(true);
        		 }
         
        		 else 
        		 {
        			 Assert.assertTrue(false);
        		 }
	}
	

	@When("user click on logout link")
	public void user_click_on_logout_link() {
		 loginpage loginpg = new loginpage(driver);

		loginpg.Clickonlogout();

	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
		driver.quit();

	}



}
