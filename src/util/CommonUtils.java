package util;




import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import base.TestBase;

public class CommonUtils extends TestBase {
	
	/*	// Function is just for testing purpose. Otherwise separate tese case exists
	public void signIn(WebDriver driver, String username, String password){
		
		WebElement usernameTextbox= driver.findElement(By.xpath("//*[@id='Email']"));
		usernameTextbox.sendKeys(username);
		
		WebElement nextButton= driver.findElement(By.xpath("//*[@id='next']"));
		nextButton.click();
		
		WebElement passwordTextbox= driver.findElement(By.xpath("//*[@id='Passwd']"));
		passwordTextbox.sendKeys(decode(password));
		//OTQyNjk4MTM5OA==
		
		WebElement signinButton = driver.findElement(By.xpath("//*[@id='signIn']"));
		signinButton.click();
		
	}*/
	
	public static String decode(String encodedpassword)
	{
	
		byte[] valueDecoded= Base64.decodeBase64(encodedpassword );
		return new String(valueDecoded);
	}
	
	public static Object[][] getData(String sheetName)
	{
		
	
	int rows = excel.getRowCount(sheetName);
	int cols = excel.getColumnCount(sheetName);
	
	
	
	Object[][] data = new Object[rows-1][cols];
	
	for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
		
		for(int colNum=0 ; colNum< cols; colNum++){
			data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); //-2
		}
	}
	
	return data;

	}
	
	public Statement createConnection()
	{
		try
		 {
			
		   Class.forName("com.mysql.jdbc.Driver");
		   //System.out.println("Driver loaded...");

		   con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","root");
		   //System.out.println("Connected to the database");
		   
		   st=con.createStatement();

 		 }
		 catch (Exception e)
		 {
 	    
		 }
		return st;
	}
	
	public ResultSet messageQuery()
	{

		try
		   {
			   st=cu.createConnection();
			   String str_qry = "select message from gmaildata where username = '"+username + "'";
			   //System.out.println(str_qry);
				rst=st.executeQuery(str_qry);
				//System.out.println(rst);
				
		 	}
		   catch (Exception e)
		   {
	    
		   }
		return rst;
	}
	
	public String subjectData(String subject)
	{
		String i="";
		try {
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\testdata\\testNotepad.txt");
			filereader = new BufferedReader(fr);
			
			while((i = filereader.readLine())!=null){
				
				//System.out.println(i);
				subject= subject+i;
			}
		} catch (Exception e) {
			
		}
		
		return subject;
	}
	
	/*	// Function is just for testing purpose. Otherwise separate tese case exists
	public void signOut(WebDriver driver, String username)
	{

		WebElement profileButton = driver.findElement(By.linkText(username));
		profileButton.click();

		WebElement signoutButton = driver.findElement(By.xpath("//*[@id='gb_71']"));
		signoutButton.click();

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='signIn']")).getAttribute("value"), "Sign in");
	}*/

}
