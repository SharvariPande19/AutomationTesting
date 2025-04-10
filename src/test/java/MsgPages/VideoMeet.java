package MsgPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideoMeet {
	
	WebDriver driver;
	@FindBy(xpath="//input[@id=\"search-conversations\"]")
	WebElement searchbar;
	@FindBy(xpath="//div[@class=\"msg-conversation-card__rows\"]") 
	WebElement person;
	@FindBy(xpath="//button[@aria-label=\"Create video meeting\"]")
	WebElement videoicon;
	@FindBy(xpath="(//li[@class=\"virtual-meeting-modal__list-item\"]//child::p)[1]")
	WebElement instantmeet;
	@FindBy(xpath="//p[text()=\"Join video meeting\"]")
	WebElement message;
	
	
	
	
	
	
	public VideoMeet(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void search(String name) throws AWTException, InterruptedException {
		Actions act=new Actions(driver);
		searchbar.sendKeys(name);
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		person.click();		
     }
	
	public void videomeet()
	{
		videoicon.click();
	}
	
	public void instantvideo() throws AWTException, InterruptedException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER); 
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
