package MsgPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageConvo {
	
WebDriver driver;
    //@FindBy(id="ember195")WebElement msgDropicon;
	//@FindBy(xpath="//div[@class=\"mr1 artdeco-dropdown artdeco-dropdown--placement-bottom artdeco-dropdown--justification-right ember-view\"]//button[starts-with(@id,'ember')]")WebElement msgDropicon;
//	@FindBy(xpath="//div[@class=\"msg-conversations-container__dropdown-container\"]//div")WebElement manageConvo;
	@FindBy(xpath="//div[starts-with(@id,'checkbox-msg-selectable-entity__checkbox-ember')]")WebElement checkbox1;
//	@FindBy(css="#checkbox-msg-selectable-entity__checkbox-ember1641")WebElement checkbox2;
	@FindBy(xpath="//button[@title=\"Mark unread\"]")WebElement markbtn;
	@FindBy(xpath="//button[@aria-label=\"See more messaging options\"]")WebElement msgdrop;
	
	
	public ManageConvo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void mainDropdown() throws AWTException, InterruptedException
	{
		
		msgdrop.click();
		  
		}
	
	
	public void manage() throws AWTException, InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER); 
		
		Thread.sleep(1000);
		
		//manageConvo.click();
	}
	
	public void boxCheck() throws InterruptedException, AWTException
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		
		
	}
	
	public void clickBtn() throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		markbtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
