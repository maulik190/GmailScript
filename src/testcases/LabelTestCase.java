package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class LabelTestCase extends TestBase {
	
	@Test
	public void moveToLabel()
	{
		//WebDriverWait wait = new WebDriverWait(driver,60);
		//cu.signIn(driver,"maulik190@gmail.com" ,"9426981398" );
		
		
		WebElement inbox = driver.findElement(By.partialLinkText("Inbox"));
		inbox.click();
		
		WebElement subjectEmail = driver.findElement(By.xpath("//tr[1]//td//div[@class='y6']/span[@id]"));
		String subjectMsg ="";
		subjectMsg=subjectEmail.getText();
		
		WebElement EmailCheckbox = driver.findElement(By.xpath("//tr[1]//td//div[@role='checkbox']//div"));
		EmailCheckbox.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=':33']")));
		WebElement moveButton = driver.findElement(By.xpath("//*[@id=':33']"));
		moveButton.click();
		
		WebElement label = driver.findElement(By.xpath("//div[text()='Test Label']"));
		label.click();
		
		WebElement starred = driver.findElement(By.partialLinkText("Starred"));
		Actions action = new Actions(driver);
		action.moveToElement(starred).build().perform();
		
		
		WebElement labelslideBar = driver.findElement(By.partialLinkText("Test Label"));
		labelslideBar.click();
		
		WebElement labelMail = driver.findElement(By.xpath("//tr[1]//td//div[@class='y6']//span[text()='"+subjectMsg+"']"));
		//Assert.assertEquals(labelMail.getText(),subjectMsg);
		
		
		
				//cu.signOut(driver, username);
	}

}
