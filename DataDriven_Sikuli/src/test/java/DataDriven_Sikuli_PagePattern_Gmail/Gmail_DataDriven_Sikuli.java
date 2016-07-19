package DataDriven_Sikuli_PagePattern_Gmail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Gmail_DataDriven_Sikuli {	
	
	@Test
	public void Gmail_Login(){
		Pattern usernamePattern = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\username.png");
		Pattern nextButton = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\nextButton.png");
		Pattern passwordPattern = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\password.png");
		Pattern signIn = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\signIn.png");
		Pattern composeButton = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\composeButton.png");
		Pattern toAddress = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\toAddress.png");
		Pattern subject = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\subject.png");
		Pattern body = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\body.png");
		Pattern attachFile = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\attachFile.png");
		Pattern filename = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\filename.png");
		Pattern openButton = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\openButton.png");
		Pattern sendButton = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\sendButton.png"); 		
		Pattern profileSrinivas = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\profile.png");
		Pattern profileSri = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\sriProfile.png");
		Pattern signOut = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\signOut.png");
		Screen src = new Screen();
		try {
			FileInputStream gmailFile = new FileInputStream("GmailLogin.xlsx");
			XSSFWorkbook gmailWorkBook = new XSSFWorkbook(gmailFile);
			XSSFSheet gmailSheet = gmailWorkBook.getSheet("GmailLogin");
			int rows = gmailSheet.getLastRowNum();
			System.out.println("rows : "+rows);
			for(int i=1;i<=rows;i++){
				String username = String.valueOf(gmailSheet.getRow(i).getCell(0));
				String password = String.valueOf(gmailSheet.getRow(i).getCell(1));
				System.out.println(username +" , "+password);
				
				System.setProperty("webdriver.chrome.driver", "F:\\Eclipse_Selenium\\Java_Selenium_Maven\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier");
				src.type(usernamePattern, username);
				src.click(nextButton);Thread.sleep(4000);
				String passwordPageURL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#password";
				String nextButtonClick_URL = driver.getCurrentUrl();
				//System.out.println("nextButtonClick_URL : "+nextButtonClick_URL);
				if(passwordPageURL.equals(nextButtonClick_URL)){ 
					src.type(passwordPattern, password);
					src.click(signIn);Thread.sleep(4000);
					String inboxPageURL = "https://mail.google.com/mail/u/0/#inbox";
					String inboxPageURL1 = "https://mail.google.com/mail/u/0/";
					String signInButtonClick_URL = driver.getCurrentUrl();
					System.out.println("signInButtonClick_URL : "+signInButtonClick_URL);
					if(inboxPageURL1.equals(signInButtonClick_URL) | inboxPageURL.equals(signInButtonClick_URL)){
						src.click(composeButton);
						src.type(toAddress, "knskumari@gmail.com");
						Actions action = new Actions(driver);
						action.sendKeys(Keys.TAB).build().perform();
						src.type(subject, "sample DataDriven Sikuli");
						src.type(body, "Hii nirmala");
						src.click(attachFile);
						src.type(filename, "F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\Gmail\\attachFile.png");
						Thread.sleep(2000);
						src.click(openButton);
						Thread.sleep(2000);
						src.click(sendButton);
						if(username.equals("srinivas.v145")){
							src.click(profileSrinivas);	
							System.out.println("Srinivas Profile");
						}
						else if(username.equals("srinivasvaddadi81")){
							src.click(profileSri);
							System.out.println("Sri Profile");
						}
						src.click(signOut);
					}
					else{
						System.out.println("Wrong Password");
					}
				}
				else{
					System.out.println("Invalid User");
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}