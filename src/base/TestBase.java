package base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import util.CommonUtils;
import util.ExcelReader;

public class TestBase {
	
	public static WebDriver driver;
	
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\testdata\\testdata.xlsx");	
	//public final String username= "maulik190@gmail.com";
	//public final String password= "9426981398";
	public static String username= "";
	public final String password= "OTQyNjk4MTM5OA==";
	public static ResultSet rst;
	public Statement st;
	public Connection con;
	public FileReader fr;
	public BufferedReader filereader;
	public static WebDriverWait wait;
	
	public static CommonUtils cu;
	
	
	@BeforeSuite
	public void setUp()
	{
		
		if(driver==null)
		{
			 driver = new FirefoxDriver();
		}
		 driver.get("http://gmail.com");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		 wait = new WebDriverWait(driver,60);
		 cu = new CommonUtils();
		 
			
		
			
	}
	
	@AfterSuite
	public void tearDown()
	{
		//driver.quit();
	}

}
