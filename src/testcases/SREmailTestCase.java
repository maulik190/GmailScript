package testcases;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;









import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.CommonUtils;
import base.TestBase;

public class SREmailTestCase extends TestBase {
	
	@Test
	public void  SendReceiveEmail()
	{
		
		//cu.signIn(driver,username ,password );
		
		WebElement composeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
		composeButton.click();
		
		WebElement toTextArea = driver.findElement(By.xpath("//textarea[@aria-label='To']"));
		toTextArea.clear();
		toTextArea.sendKeys("maulik190@gmail.com");
		
		WebElement subjectTextArea = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		//final String subject= "Gmail send email Test";
		// subject comes from notepad file
		
		String subject= "";
		subject=cu.subjectData(subject);
		String i="";
		
		
		subjectTextArea.clear();
		subjectTextArea.sendKeys(subject);
		
		WebElement bodyTextArea = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		//final String body = "Hello Testers";
		String body = "";
		rst= cu.messageQuery();
		
		// message comes from database
		
		try
		   {
		
		while(rst.next())
		{
		
			body= rst.getString("message");
			
		}
	
 	}
   catch (Exception e)
   {

   }
		
		
		bodyTextArea.clear();
		bodyTextArea.sendKeys(body);
		
		WebElement sendButton = driver.findElement(By.cssSelector("div[aria-label*='Send']"));
		//xpath=div[contains(@aria-label,'Send')]
		sendButton.click();
		
		WebElement inbox = driver.findElement(By.partialLinkText("Inbox"));
		inbox.click();
		
		WebElement unreadEmail = driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
		unreadEmail.click();
		//xpath=div[@class='y6']/span/b
		
		WebElement subjectText= driver.findElement(By.xpath("//h2[@class='hP']"));
		Assert.assertEquals(subjectText.getText(),subject);
		
		WebElement bodyText= driver.findElement(By.xpath("//div[@class='a3s']/*[@dir='ltr']"));
		Assert.assertEquals(bodyText.getText(),body);
		
		//cu.signOut(driver, username);
		
	}
	

	
}
