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

public class DataDrivenAndSikuli_Trello {
	
	public WebDriver driver;
	@Test
	public void Trello_Login()throws Exception{
		try {
			FileInputStream trelloDetails = new FileInputStream("TrelloLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(trelloDetails);
			XSSFSheet trelloSheet = workbook.getSheet("Trello_Login");
			int rows = trelloSheet.getLastRowNum();
			System.out.println("Trello rows : "+rows);
			for(int i=1;i<=rows;i++){
				driver = new FirefoxDriver();
				driver.get("https://trello.com/login");
				String username = String.valueOf(trelloSheet.getRow(i).getCell(0));
				String password = String.valueOf(trelloSheet.getRow(i).getCell(1));
				System.out.println("Username : "+username+" , Password : "+password);
				
				Pattern usernameSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\username.png");
				Pattern passwordSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\password.png");
				Pattern login = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\loginButton.png");
				Pattern profileClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\profile_click.png");
				Pattern signoutClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\logout_click.png");
				Screen src = new Screen();
				src.setAutoWaitTimeout(20);
				src.type(usernameSnip, username);
				Thread.sleep(4000);
				
				src.type(passwordSnip, password);
				Thread.sleep(4000);
				
				src.click(login);
				Thread.sleep(4000);
				
				String currentURL = driver.getCurrentUrl();
				System.out.println("CurrentURL : "+currentURL);
				if(currentURL.equals("https://trello.com/")){
					src.click(profileClick);
					Thread.sleep(4000);
					
					src.click(signoutClick);
					Thread.sleep(4000);
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