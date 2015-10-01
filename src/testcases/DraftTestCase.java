package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;


public class DraftTestCase extends TestBase {
	
	@Test
	public void  draftEmail()
	{
		//cu.signIn(driver,"maulik190@gmail.com","9426981398");
				
		WebElement composeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
		composeButton.click();
		
		WebElement toTextArea = driver.findElement(By.xpath("//textarea[@aria-label='To']"));
		toTextArea.clear();
		toTextArea.sendKeys("maulik190@gmail.com");
		
		WebElement subjectTextArea = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		final String draftSubject= "Draft Test";
		
		
		
		subjectTextArea.clear();
		subjectTextArea.sendKeys(draftSubject);
		
		WebElement bodyTextArea = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		final String draftBody = "Draft is working";
		
		
		bodyTextArea.clear();
		bodyTextArea.sendKeys(draftBody);
			
		WebElement closeButton = driver.findElement(By.xpath("//img[@alt='Close']"));
		closeButton.click();
		

		
		WebElement starred = driver.findElement(By.partialLinkText("Starred"));
		Actions action = new Actions(driver);
		action.moveToElement(starred).build().perform();
		
		
		WebElement drafts = driver.findElement(By.partialLinkText("Drafts"));
		drafts.click();
		
		WebElement draftEmail = driver.findElement(By.xpath("//span[text()='Draft Test']"));
		draftEmail.click();
		//xpath=div[@class='y6']/span/b
		//div[@class='y6']/span[@class='y2']
		
		
		WebElement draftSubjectText= driver.findElement(By.xpath("//span[text()='Draft Test']"));
		Assert.assertEquals(draftSubjectText.getText(),draftSubject);
		
		WebElement bodyText= driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		Assert.assertEquals(bodyText.getText(),draftBody);
		
		WebElement closeButtonNew = driver.findElement(By.xpath("//img[@alt='Close']"));
		closeButtonNew.click();
		//cu.signOut(driver, username);
		
	}

}
