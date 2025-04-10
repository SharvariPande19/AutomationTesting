package StepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import DriverSetup.SetupDriver;
import MsgPages.PageFact;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MsgStep {
	
    static WebDriver driver;
     PageFact page;
     Actions act;
     Robot r;
     
     
//----------------------------------------BACKGROUND---------------------------------------------------------------------------------------------
     
	@Given("User is on the messaging page")
	public void user_is_on_the_messaging_page() throws InterruptedException, IOException  
	{
		
		driver=SetupDriver.chromedriver();
		//driver=SetupDriver.edgedriver()
		
		page = new PageFact(driver);
		page.background();
		
	}

//========================================SCENARIO 1====================================================================================
	
	/* Created By :Sharvari Pande
	 * Reviewed By:Akasha KC 
	 * Motive: sending a message to the respective connection
	 */
	             
	@When("User will search a person on the searchbar")
	public void user_will_search_a_person_on_the_searchbar() throws InterruptedException, IOException 
	{
		act=new Actions(driver);
		Thread.sleep(2000);
	    page.search();
	    Thread.sleep(2000);
	    act.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
      
	}

	@When("write a {string} in the textbox")
	public void write_a_in_the_textbox(String string, DataTable dataTable) throws InterruptedException, IOException 
	{
		List<List<String>> cells = dataTable.cells();
		page.typemsg(cells.get(0).get(0));
	    
	}

	@And("click on the send button")
	public void click_on_the_send_button() throws InterruptedException 
	{
		
		page.btn();
	    Thread.sleep(2000);
	}

	@Then("message will be sent to respective person")
	public void message_will_be_sent_to_respective_person() 
	{
	    String actual = driver.findElement(By.xpath("//div[@data-placeholder=\"Write a message…\"]")).getText();
		String expected="";
		Assert.assertEquals(expected, actual);

	}
	
	
//=========================================SCENARIO 2===============================================================================
	
	/* Created By :Sharvari Pande
	 * Reviewed By:Akasha KC 
	 * Motive: To mark a read conversation as "mark as unread" for managing multiple conversation
	 */
	
	@When("User will click on messaging dropdown icon")
	public void user_will_click_on_messaging_dropdown_icon() throws AWTException, InterruptedException 
	{
		page.mainDropdown();
	    
	}

	@And("click on manage conversation option")
	public void click_on_manage_conversation_option() throws AWTException, InterruptedException 
	{
		page.manage();
	}

	@And("Select the conversation to be managed")
	public void select_the_conversation_to_be_managed() throws InterruptedException, AWTException 
	{
		page.boxCheck();
	}

	@And("click on mark as unread option")
	public void click_on_mark_as_unread_option() throws InterruptedException 
	{
		page.clickBtn();
	}

	@Then("coversations will be displayed as unread")
	public void coversations_will_be_displayed_as_unread() {
	    String actual=driver.findElement(By.xpath("//span[text()=\"1\"]")).getText();
	    String expected="1";
	    Assert.assertEquals(expected, actual);
	}

  

//==================================SCENARIO 3============================================================================
	
	/* Created By :Sharvari Pande
	 * Reviewed By:Akasha KC 
	 * Motive: To move message to "OTHER" criteria as per priority of message
	 */
	
  @When("Search a {string} on the searchbar")
  public void search_a_on_the_searchbar(String string,DataTable dataTable) throws AWTException, InterruptedException 
  {
	  List<List<String>> cells = dataTable.cells();
	  page.search(cells.get(0).get(0));
	  
  }
      
  @And("click on dropdown icon in the chat")
  public void click_on_dropdown_icon_in_the_chat() throws InterruptedException 
  {
	  page.dropbtn();
      
  }

  @And("click on move to other option in dropdown")
  public void click_on_move_to_other_option_in_dropdown() throws AWTException, InterruptedException 
  {
      page.deleteconvo();
  }

  @And("click on other button")
  public void click_on_other_button() throws InterruptedException, AWTException
  {
	  page.otherbtn();
	  
  }
      

  @Then("the person will be displayed in OTHER menu")
  public void the_person_will_be_displayed_in_OTHER_menu() 
  {
	  String actual= driver.findElement(By.xpath("//h3[text()=\"Dattesh Kachore\"]")).getText();
      String expected="Dattesh Kachore" ;
      Assert.assertEquals(expected, actual);
  }
  
//========================================SCENARIO 4=============================================================================
  
    /* Created By :Sharvari Pande
	 * Reviewed By:Akasha KC 
	 * Motive: To search a new conncetion to send a message
	 */
  
  @When("User searches a {string} in search bar")
  public void user_searches_a_in_search_bar(String string,DataTable dataTable) throws AWTException, InterruptedException {
	  List<List<String>> cells = dataTable.cells();
	  page.search(cells.get(0).get(0));
	  
  }

  @When("click on camera icon in the chat")
  public void click_on_camera_icon_in_the_chat() {
      page.videomeet();
  }

  @When("click on the instant video meeting option")
  public void click_on_the_instant_video_meeting_option() throws AWTException, InterruptedException {
      page.instantvideo();
  }

  @Then("meeting link will be sent to the respective person")
  public void meeting_link_will_be_sent_to_the_respective_person() {
	  String actual= driver.findElement(By.xpath("//p[text()=\"Join video meeting\"]")).getText();
      String expected="Join video meeting" ;
      Assert.assertEquals(expected, actual);
  }
  
//==========================================SCENARIO 5===================================================================
  
    /* Created By :Sharvari Pande
	 * Reviewed By:Akasha KC 
	 * Motive: 
	 */ 
  
  @When("Search the name of the {string} to message")
  public void search_the_name_of_the_to_message(String string,DataTable dataTable) throws AWTException, InterruptedException {
	  List<List<String>> cells = dataTable.cells();
	  page.new_person(cells.get(0).get(0));
	  
	     
  }

  @And("Click on the name")
  public void click_on_the_name() 
  {
      page.click_name();
  }

  @Then("start typing in the textbox")
  public void start_typing_in_the_textbox() 
  {
	  String expected = driver.findElement(By.xpath("//div[@class=\"msg-conversation-card__rows\"]")).getText();
	  String actual = "No messages";
      Assert.assertEquals(expected, actual);
  }
  
//=========================================AFTER STEP============================================================================================== 
  
@AfterStep
  
  public static void takeScreendown1(Scenario scenerio)
  {
	  
	   TakesScreenshot ts= (TakesScreenshot) driver;
	   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
	   scenerio.attach(src, "image/png",scenerio.getName());
  }
  
	

}
