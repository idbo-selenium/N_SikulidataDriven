package com.Data.DataDriven_Sikuli;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class DataDrivenAndSikuli_Mercury {

	public WebDriver driver;
	
	@Test
	public void DataDriven_Sikuli_MercuryLogin()throws Exception{
		try {
			FileInputStream mercuryLogin = new FileInputStream("MercuryLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(mercuryLogin);
			XSSFSheet mercurySheet = workbook.getSheet("MercuryLogin");
			int mercuryRows = mercurySheet.getLastRowNum();
			System.out.println("Rows : "+mercuryRows);
			for(int i=1;i<=mercuryRows;i++){
				driver = new FirefoxDriver();
				driver.get("http://newtours.demoaut.com/");
				String username = String.valueOf(mercurySheet.getRow(i).getCell(0));				
				String password = String.valueOf(mercurySheet.getRow(i).getCell(1));
				System.out.println("Username : "+username+" , Password : "+password);
				
				Pattern signOn = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\signOn_button.png");
				Pattern usernameSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\username.png");
				Pattern passwordSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\password.png");
				Pattern signIn = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\signIn_button.png");				
				Pattern signOutClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\signOut_button.png");
				String homepageURL = "http://newtours.demoaut.com/mercuryreservation.php";				
				
				Screen src = new Screen();
				src.setAutoWaitTimeout(20);
				
				src.click(signOn);
				Thread.sleep(4000);
				
				src.type(usernameSnip, username);
				Thread.sleep(4000);
				
				src.type(passwordSnip, password);
				Thread.sleep(4000);
				
				src.click(signIn);
				Thread.sleep(4000);
				
				String currentURL = driver.getCurrentUrl();
				System.out.println("Current URL : "+currentURL);
				if(currentURL.equals(homepageURL)){//http://newtours.demoaut.com/mercurysignon.php				
					src.click(signOutClick);
					Thread.sleep(4000);
					System.out.println("Successfully Signout");
				}
				else{
					System.out.println("Wrong Credentials");
				}
				driver.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}