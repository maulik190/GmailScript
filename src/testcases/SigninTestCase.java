package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.CommonUtils;
import base.TestBase;



public class SigninTestCase extends TestBase{
	
	@Test(dataProvider="getData")
	public void loginTest(String username) {
		this.username=username;
		
		// username is provided from Excel
		// password contains encrypted value
	
			//cu.signIn(driver,username ,password );
		WebElement usernameTextbox= driver.findElement(By.xpath("//*[@id='Email']"));
		usernameTextbox.sendKeys(username);
		
		WebElement nextButton= driver.findElement(By.xpath("//*[@id='next']"));
		nextButton.click();
		
		WebElement passwordTextbox= driver.findElement(By.xpath("//*[@id='Passwd']"));
		passwordTextbox.sendKeys(cu.decode(password));
		//OTQyNjk4MTM5OA==
		
		WebElement signinButton = driver.findElement(By.xpath("//*[@id='signIn']"));
		signinButton.click();
			Assert.assertEquals(driver.findElement(By.linkText("Starred")).getText(), "Starred");
			//cu.signOut(driver, username);
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return CommonUtils.getData("UsernameData");	
		
	}
}

// catch (Exception e) {
//System.out.println(e.getMessage());
