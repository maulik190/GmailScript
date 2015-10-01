package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class TrashTestCase extends TestBase{
	
	@Test
	public void  trashEmail()
	{
		
		//WebDriverWait wait = new WebDriverWait(driver,60);
	//	cu.signIn(driver,"maulik190@gmail.com","9426981398");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		
		WebElement inbox = driver.findElement(By.partialLinkText("Inbox"));
		inbox.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td//div[@class='y6']/span[@id]")));
		
		WebElement subjectEmail = driver.findElement(By.xpath("//tr[1]//td//div[@class='y6']/span[@id]"));
		String subjectMsg ="";
		subjectMsg=subjectEmail.getText();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td//div[@role='checkbox']//div")));
		WebElement EmailCheckbox = driver.findElement(By.xpath("//tr[1]//td//div[@role='checkbox']//div"));
		EmailCheckbox.click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Delete']/div/div")));
		WebElement deleteButton = driver.findElement(By.xpath("//div[@act='10']"));
		deleteButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Starred")));
		WebElement starred = driver.findElement(By.partialLinkText("Starred"));
		Actions action = new Actions(driver);
		action.moveToElement(starred).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='More'][@class='CJ']")));
		WebElement moreLabel = driver.findElement(By.xpath("//span[text()='More'][@class='CJ']"));
		moreLabel.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Trash")));
		WebElement trashLabel = driver.findElement(By.partialLinkText("Trash"));
		trashLabel.click();
		
		//tr[1]//td//div[@class='y6']//span[1]
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]//td//div[@class='y6']//span[1]")));
		// trashMail: xpath is not proper...two matching nodes
		WebElement trashMail = driver.findElement(By.xpath("//tr[1]//td//div[@class='y6']//span[text()='"+subjectMsg+"']"));
		//Assert.assertEquals(trashMail.getText(),subjectMsg);
	}

}
