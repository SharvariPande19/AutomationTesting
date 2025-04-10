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

public class ChatDropdown {
	
	WebDriver driver;
	@FindBy(xpath="//input[@id=\"search-conversations\"]")
	WebElement searchbar;
	@FindBy(xpath="//button[@class=\"msg-thread-actions__control artdeco-button artdeco-button--circle artdeco-button--2 artdeco-button--muted artdeco-button--tertiary artdeco-dropdown__trigger artdeco-dropdown__trigger--placement-bottom ember-view\"]") 
	WebElement dropicon;
	@FindBy(xpath="//button[@class=\"artdeco-tab ember-view\"]")
	WebElement other;
	@FindBy(xpath="//button[@class=\"msg-search-form__cancel-search artdeco-button artdeco-button--circle artdeco-button--muted artdeco-button--1 artdeco-button--tertiary ember-view\"]")
	WebElement cancelbtn;
	@FindBy(xpath="//div[@class=\"msg-conversation-card__rows\"]") 
	WebElement person;
	
	
	
	
	public ChatDropdown(WebDriver driver)
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
	
	public void dropbtn() {
		dropicon.click();
	}
	
	public void deleteconvo() throws AWTException, InterruptedException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void otherbtn() throws InterruptedException
	{
		cancelbtn.click();	
		Thread.sleep(2000);
		other.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
