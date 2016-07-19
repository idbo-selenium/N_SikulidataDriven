package DataDriven_Sikuli_PagePattern_Trello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import DataDriven_Sikuli_PagePattern_Gmail.Browser;
import DataDriven_Sikuli_PagePattern_Gmail.GmailPage;

public class Trello_Handler {

	@Test
	public void Trello_Login()throws Exception{
		try {
			FileInputStream trelloFile = new FileInputStream("TrelloLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(trelloFile);
			XSSFSheet sheet = workbook.getSheet("Trello_Login");
			
			int rows = sheet.getLastRowNum();
			System.out.println("Rows : "+rows);
			
			for(int i=1;i<=rows;i++){
				String username = String.valueOf(sheet.getRow(i).getCell(0));
				String password = String.valueOf(sheet.getRow(i).getCell(1));
				
				TrelloLogin.GoTo();
				TrelloLogin.LoginAs(username).WithPassword(password).LoginAs();
				GmailPage.Sleep();
				String getURL = Browser.driver.getCurrentUrl();
				System.out.println("Get URL : "+getURL);				
				String homepageURL = "https://trello.com/";
				
				if(getURL.equals(homepageURL)){
					TrelloHomePage.SignOut();
					GmailPage.Sleep(); 
					System.out.println("Success");
				}	
				else{
					System.out.println("Wrong Credentials");
				}
				Browser.CloseBrowser();
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