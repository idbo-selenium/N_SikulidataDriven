package com.Data.DataDriven_Sikuli;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class DataDrivenAndSikuli_Github {
	
	WebDriver driver;
	@Test
	public void GitHubLogin()throws Exception{
		try {
			FileInputStream githubLogin = new  FileInputStream("GitHub.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(githubLogin);
			XSSFSheet githubSheet = workbook.getSheet("GitHubLogin");
			int rows = githubSheet.getLastRowNum();
			System.out.println("Github Rows : "+rows);
			for(int i=1;i<=rows;i++){
				String username = String.valueOf(githubSheet.getRow(i).getCell(0));
				String password = String.valueOf(githubSheet.getRow(i).getCell(1));
				System.out.println("Username : "+username+" , Password : "+password);
				
				driver = new FirefoxDriver();
				driver.get("https://github.com/login");
				Pattern usernameSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\username_textbox.png");
				Pattern passwordSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\password_textbox.png");
				Pattern signIn = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\signin_button.png");
				Pattern profile_click = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\profile.png");
				Pattern signout_click = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\signout.png");
				
				Screen src = new Screen();
				src.setAutoWaitTimeout(20);
				src.type(usernameSnip, username);
				Thread.sleep(4000);
				
				src.type(passwordSnip, password);
				Thread.sleep(4000);
				
				src.click(signIn);
				Thread.sleep(4000);
				
				String currentURL = driver.getCurrentUrl();
				String homepageURL = "https://github.com/";
				if(currentURL.equals(homepageURL)){
					src.click(profile_click);
					Thread.sleep(4000);
					
					src.click(signout_click);
					Thread.sleep(4000);
					System.out.println("Successfully signout");
				}
				else{
					System.out.println("Wrong Credentials");
				}
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