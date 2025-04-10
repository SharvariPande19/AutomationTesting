package MsgPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MsgPageFactory {
	
WebDriver driver;
WebDriver wait;
	
	
	@FindBy(xpath="//input[@id=\"search-conversations\"]") 
	WebElement searchbar;
	@FindBy(xpath="//div[@class=\"msg-conversation-card__rows\"]")
	WebElement person;
	@FindBy(xpath="//div[@class=\"msg-form__msg-content-container--scrollable scrollable relative\"]/descendant::p")
	WebElement textbox;
	@FindBy(xpath="//button[text()=\"Send\"]")
	WebElement sendbtn;
	
	@FindBy(css="#session_key")
	WebElement email;
	@FindBy(id="session_password")
	WebElement password;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement logbtn;
	@FindBy(xpath="//span[@ title=\"Messaging\"]")
	WebElement msgicon;
			
	
     
  
	
	public void background() throws InterruptedException
	{
	    
	    
		email.sendKeys("arvindps01@gmail.com");
		Thread.sleep(3000);
		password.sendKeys("#linkedln2001");
		Thread.sleep(3000);
		logbtn.click();
		Thread.sleep(15000);
		msgicon.click();
		Thread.sleep(2000);
		
	}
	
	
	public MsgPageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
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
		Thread.sleep(2000);
		textbox.sendKeys(Text);
	}
	
	public void btn()
	{
		Actions act=new Actions(driver);
		act.moveToElement(sendbtn).click().build().perform();
		//sendbtn.click();
	}
	
	

}
