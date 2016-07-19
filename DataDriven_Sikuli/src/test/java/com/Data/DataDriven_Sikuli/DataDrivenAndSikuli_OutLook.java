package com.Data.DataDriven_Sikuli;

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

public class DataDrivenAndSikuli_OutLook {

	@Test
	public void OutLook_Login(){
		Pattern usernamePattern = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\username.png");
		Pattern passwordPattern = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\password.png");
		Pattern signIn = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\signIn.png");
		Pattern newMail = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\newMail.png");
		Pattern toAddress = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\toAddress.png");
		Pattern subject = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\subject.png");
//		Pattern body = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\body.png");
//		Pattern insert = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\insert.png");
//		Pattern attachments = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\attachments.png");
//		Pattern fileName = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\fileName.png");
//		Pattern openButton = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\openButton");
//		Pattern send = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\send.png");
		Screen src = new Screen();
		try {
			FileInputStream outlookFile = new FileInputStream("OutLookLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(outlookFile);
			XSSFSheet sheet = workbook.getSheet("OutLookLogin");
			int rows = sheet.getLastRowNum();
			System.out.println("rows : "+rows);
			for(int i = 1;i<=rows;i++){
				String username = String.valueOf(sheet.getRow(i).getCell(0));
				String password = String.valueOf(sheet.getRow(i).getCell(1));
				
				System.setProperty("webdriver.chrome.driver", "F:\\Eclipse_Selenium\\Java_Selenium_Maven\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://email.i-dbo.com/owa/#path=/mail");
				src.type(usernamePattern, username);
				src.type(passwordPattern, password);
				src.click(signIn);
				Thread.sleep(20000);
				String homepageURL = "https://email.i-dbo.com/owa/#path=/mail";
				String signInClick_URL = driver.getCurrentUrl();
				System.out.println("signInClick_URL : "+signInClick_URL);
				if(homepageURL.equals(signInClick_URL)){
					src.click(newMail);Thread.sleep(20000);
					src.type(toAddress, "nirmala@proconstructor");
					Actions action = new Actions(driver);
					action.sendKeys(Keys.TAB).build().perform();
					src.type(subject, "drfgthyujk");
					System.out.println("success");
				}
				else{
					System.out.println("Wrong Credentials");
				}
//				src.click(insert);
//				src.click(attachments);
				//driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/div[1]/div[6]/div/div/div[2]/div[1]/span[1]/div[3]/button/span[2]")).click();
				//driver.findElement(By.xpath("//*[@id='_ariaId_499']/div/div/div/div/div[1]/div/div/span[2]")).click();
//				src.click(attachments);
//				src.type(fileName, "F:\\Eclipse_Selenium\\Java_Selenium_Maven\\DataDriven_Sikuli\\OutLook\\attachments.png");
//				src.click(openButton);	
			//	src.click(send);
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}