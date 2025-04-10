package MsgPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFact {
	
	WebDriver driver;
	WebDriverWait wait;
	Robot r;
	Actions act;
	
	
//------------------------------LOGGING AND NAVIGATING TO MESSAGE PAGE----------------------------------------------------------------
	@FindBy(css="#session_key")
	WebElement email;
	
	@FindBy(id="session_password")
	WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement logbtn;
	
	@FindBy(xpath="//span[@ title=\"Messaging\"]")
	WebElement msgicon;
	
	
	
   public void background() throws InterruptedException, IOException
	{
	    
	    File file = new File ("C:\\Users\\SHADEEPA\\Documents\\ID PROOF\\Messaging\\src\\test\\resource\\Excel Data\\Data1.xlsx");
		FileInputStream fis1 = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis1);
		Sheet s = w.getSheetAt(0);
		
		String mail = s.getRow(0).getCell(0).getStringCellValue();
		String pass =s.getRow(0).getCell(1).getStringCellValue();
		
		email.sendKeys(mail);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(pass);
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(logbtn));
		logbtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(msgicon));
		msgicon.click();
		Thread.sleep(2000);
		
	}
   
   public PageFact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//---------------------------------SCENARIO 1(sending a message)---------------------------------------------------------
	
	
	@FindBy(xpath="//input[@id=\"search-conversations\"]") 
	WebElement searchbar;
	
	@FindBy(xpath="//div[@class=\"msg-conversation-card__rows\"]")
	WebElement person;
	
	@FindBy(xpath="//div[@class=\"msg-form__msg-content-container--scrollable scrollable relative\"]/descendant::p")
	WebElement textbox;
	
	@FindBy(xpath="//button[text()=\"Send\"]")
	WebElement sendbtn;

	
	public void search () throws IOException
	{
		File file = new File ("C:\\Users\\SHADEEPA\\Documents\\ID PROOF\\Messaging\\src\\test\\resource\\Excel Data\\Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheetAt(0);
		String cellvalue = s.getRow(0).getCell(0).getStringCellValue();
		searchbar.sendKeys(cellvalue);
	}
	
	
	public void typemsg(String Text) throws InterruptedException, IOException
	{
		person.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(textbox));
		textbox.sendKeys(Text);
	}
	
	public void btn()
	{
		act=new Actions(driver);
		act.moveToElement(sendbtn).click().build().perform();
		
	}
	
//-----------------------------SCENARIO 2(managing conversion "Mark as Unread")--------------------------------------------------------------------------------------------	
	
	
	
	@FindBy(xpath="//button[@title=\"Mark unread\"]")
	WebElement markbtn;
	
	@FindBy(xpath="//button[@aria-label=\"See more messaging options\"]")
	WebElement msgdrop;
	
	
	public void mainDropdown() throws AWTException, InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(msgdrop));
		msgdrop.click();
		
	}
	
	public void manage() throws AWTException, InterruptedException
	{
		r=new Robot();
		r.delay(2000);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_ENTER); 
		r.delay(1000);
	}
	
	public void boxCheck() throws InterruptedException, AWTException
	{
		r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.delay(1000);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(1000);
	}
	
	public void clickBtn() throws InterruptedException
	{
	  markbtn.click();
	  Thread.sleep(2000);
	  
	}
	
//------------------------------SCENARIO 3(Moving conversion into "OTHER")------------------------------------------------------------------------------------	
	
	@FindBy(xpath="//button[@class=\"msg-thread-actions__control artdeco-button artdeco-button--circle artdeco-button--2 artdeco-button--muted artdeco-button--tertiary artdeco-dropdown__trigger artdeco-dropdown__trigger--placement-bottom ember-view\"]") 
	WebElement dropicon;
	
	@FindBy(xpath="//button[@class=\"artdeco-tab ember-view\"]")
	WebElement other;
	
	@FindBy(xpath="//button[@class=\"msg-search-form__cancel-search artdeco-button artdeco-button--circle artdeco-button--muted artdeco-button--1 artdeco-button--tertiary ember-view\"]")
	WebElement cancelbtn;
	
	
	public void search(String name) throws AWTException, InterruptedException 
	{
		act=new Actions(driver);
		r=new Robot();
		r.delay(2000);
		searchbar.sendKeys(name);
		r.delay(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(person));
		person.click();
	}
	
	public void dropbtn() throws InterruptedException 
	{
		dropicon.click();
		Thread.sleep(2000);
	}
	
	public void deleteconvo() throws AWTException, InterruptedException 
	{
		r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(2000);
	}
	
	public void otherbtn() throws InterruptedException, AWTException
	{
		r=new Robot();
		wait.until(ExpectedConditions.elementToBeClickable(cancelbtn));
		cancelbtn.click();	
		wait.until(ExpectedConditions.elementToBeClickable(other));
		other.click();
		r.delay(2000);
		
	}
	
//-----------------------------SCENARIO 4(Sending an instant video meeting invite)-----------------------------------------------------------------------------------------
	
	
	@FindBy(xpath="//button[@aria-label=\"Create video meeting\"]")
	WebElement videoicon;
	
	@FindBy(xpath="(//li[@class=\"virtual-meeting-modal__list-item\"]//child::p)[1]")
	WebElement instantmeet;
	
	@FindBy(xpath="//p[text()=\"Join video meeting\"]")
	WebElement message;
	
	public void search1(String name) throws AWTException, InterruptedException 
	{
		r=new Robot();
		act=new Actions(driver);
		searchbar.sendKeys(name);
		r.delay(1000);
		act.sendKeys(Keys.ENTER).build().perform();
		r.delay(2000);
		person.click();		
    }
	
	public void videomeet()
	{
		videoicon.click();
	}
	
	public void instantvideo() throws AWTException, InterruptedException
	{
		r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER); 
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(2000);
    }
	
//-------------------------------SCENARIO 5(searching a person and starting a conversation)-------------------------------------------------------------------------------------------
	
	
	public void new_person(String name) throws AWTException, InterruptedException 
	{
		searchbar.sendKeys(name);
		Thread.sleep(2000);
		act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
			
    }
	
	public void click_name()
	{
		person.click();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

	
	
	
	


