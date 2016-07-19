package com.Data.DataDriven_Sikuli;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class DataDrivenAndSikuli_Gmail {

	public WebDriver driver;
	@Test
	public void GmailLogin() throws Exception{
		try {
			FileInputStream gmailLogin = new FileInputStream("GmailLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(gmailLogin);
			XSSFSheet gmailSheet = workbook.getSheet("GmailLogin");
			int rows = gmailSheet.getLastRowNum();
			System.out.println("Rows : "+rows);
			for(int i=1;i<=rows;i++){
				driver = new FirefoxDriver();
				driver.get("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier");
				String username = String.valueOf(gmailSheet.getRow(i).getCell(0));
				String password = String.valueOf(gmailSheet.getRow(i).getCell(1));
				System.out.println("Username : "+username+" , Password : "+password);
				Pattern usernameSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\username.png");
				Pattern nextButton = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\nextButton.png");
				Pattern passwordSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\password.png");
				Pattern signin = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\signinButton.png");
				//Pattern profileClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\profile_click.png");
				Pattern signOutClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\signout_click.png");
				
				String usernamePageURL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier";
				String passwordPageURL = "https://accounts.google.com/ServiceLoginAuth#password";
				Screen src = new Screen();
				src.setAutoWaitTimeout(20);
				src.type(usernameSnip, username);
				Thread.sleep(4000);
				
				src.click(nextButton);
				Thread.sleep(4000);
				String nextButtonClickURL = driver.getCurrentUrl();
				if(usernamePageURL.equals(nextButtonClickURL)){
					System.out.println("invalid username");
				}
				else{
					src.type(passwordSnip, password);
					Thread.sleep(4000);
					
					src.click(signin);
					Thread.sleep(4000);
					String signInClickURL = driver.getCurrentUrl();	
					System.out.println("SignInClickURL : "+signInClickURL);
					if(signInClickURL.equals(passwordPageURL)){
						System.out.println("Wrong Credentials");
					}
					else{
						driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
						Thread.sleep(4000);
						
						src.click(signOutClick);
						Thread.sleep(4000);
						System.out.println("successfully signout");
					}
				}
				driver.close();
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}