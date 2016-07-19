package DataDriven_Sikuli_PagePattern_Gmail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class Gmail_Handler {

	@Test
	public void PagePattern_ExcelHandler(){
		try {
			FileInputStream gmailFile = new FileInputStream("GmailLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(gmailFile);
			XSSFSheet sheet = workbook.getSheet("GmailLogin");
			
			int gmailSheetRows = sheet.getLastRowNum();
			System.out.println("gmailSheetRows : "+gmailSheetRows);
			
			for(int i = 1;i<=gmailSheetRows;i++){
				String username =String.valueOf(sheet.getRow(i).getCell(0));
				String password = String.valueOf(sheet.getRow(i).getCell(1));
				
				GmailPage.Goto();
				GmailLogin.LoginAs(username);
				GmailPage.Sleep();
				String usernamepageURL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier";
				String passwordPageURL = "https://accounts.google.com/ServiceLoginAuth#password";
				String nextButtonClickURL = Browser.driver.getCurrentUrl();
				
				if(nextButtonClickURL.equals(usernamepageURL)){
					System.out.println("*********************Invalid Username************");
				}
				else{
					GmailLogin.WithPassword(password);
					GmailPage.Sleep();
					String signInButtonClick=Browser.driver.getCurrentUrl();
					System.out.println("signInButtonClick : "+signInButtonClick);
					if(signInButtonClick.equals(passwordPageURL)){
						System.out.println("^^^^^^^^^^^^^^^^^Wrong Credentials^^^^^^^^^^^^^^^^^");
					}
					else{
						UsershomePage.SignOut(username);
						GmailPage.Sleep();
						System.out.println("@@@@@@@@@@@@@@@@@Succesfully SignOut@@@@@@@@@@@@@@@");
					}
				}
				Browser.CloseBrowser();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}