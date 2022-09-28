package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Blaze {
	WebDriver driver;
	
	@Given("the BlazeDemo page is opened in Chrome Browser")
	public void the_BlazeDemo_page_is_opened_in_Chrome_Browser() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://blazedemo.com/index.php ");
	}
	@When("the pageTitle is displayed")
	public void the_pageTitle_is_displayed() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String titletext= driver.findElement(By.xpath("//div[@class='container']/h1")).getText();
		String title= "Welcome to the Simple Travel Agency!";
		String title= "Welcome to the Simple Travel Agency1!";
		Assert.assertEquals(title, titletext);
	}
	@And("user clicks on hyperlink and see a new tab is opened")
	public void user_clicks_on_hyperlink_and_see_a_new_tab_is_opened() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	driver.findElement(By.xpath("//div[@class='container']/p[2]/a")).click();
	
}
	@And("user verifies that the url has string vacation")
	public void user_verifies_that_the_url_has_string_vacation() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String CurrentURL= driver.getCurrentUrl();
		//System.out.println(CurrentURL);
		//String Vacation1= CurrentURL.split("/")[1].split(".")[0].toString();
		//Assert.assertEquals("vacation", Vacation1);
		driver.navigate().back();
		
	}
	@Then("User selects Mexico is departure city and London in destination city")
	public void user_selects_Mexico_is_departure_city_and_London_in_destination_city(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Select s= new Select(driver.findElement(By.name("fromPort")));
			s.selectByValue("Mexico City");
			Select s1= new Select(driver.findElement(By.name("toPort")));
			s1.selectByValue("London");
			driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}
	@And("user selects the flight with lowest price and navigated to the purchase page")
	public void user_selects_the_flight_with_lowest_price_and_navigated_to_the_purchase_page() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//tbody/tr[3]/td[1]")).click();
		
	
	}
	@And("the user verifies total cost is available and clicks on purchase flight")
	public void the_user_verifies_total_cost_is_available_and_clicks_on_purchase_flight() {
		String cost= driver.findElement(By.xpath("//div[@class='container']/p[5]")).getText();
		Assert.assertEquals("Total Cost: 914.76", cost);
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}
	@Then("the user is navigated to the purchase conf page and store the id")
	public void the_user_is_navigated_to_the_purchase_conf_page_and_store_the_id() {
		String ID= driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
		System.out.println(ID);
	}
	
	
}
