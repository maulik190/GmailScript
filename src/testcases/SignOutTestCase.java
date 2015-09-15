package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.CommonUtils;
import base.TestBase;

public class SignOutTestCase extends TestBase {
	
	// username is provided from excel
	
	@Test(dataProvider="getData")
	public void SignOut(String username)
	{
		WebElement profileButton = driver.findElement(By.linkText(username));
		profileButton.click();

		WebElement signoutButton = driver.findElement(By.xpath("//*[@id='gb_71']"));
		signoutButton.click();

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='signIn']")).getAttribute("value"), "Sign in");
	}
	@DataProvider
	public static Object[][] getData()
	{
		return CommonUtils.getData("UsernameData");	
		
	}

}
