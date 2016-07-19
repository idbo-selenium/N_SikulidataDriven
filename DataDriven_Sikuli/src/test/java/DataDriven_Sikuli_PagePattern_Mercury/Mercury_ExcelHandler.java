package DataDriven_Sikuli_PagePattern_Mercury;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import DataDriven_Sikuli_PagePattern_Gmail.Browser;
import DataDriven_Sikuli_PagePattern_Gmail.GmailPage;

public class Mercury_ExcelHandler {

	@Test
	public void ExcelHandler()throws Exception{
		try {
			FileInputStream mercuryFile = new FileInputStream("MercuryLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(mercuryFile);
			XSSFSheet sheet = workbook.getSheet("MercuryLogin");
			
			int rows = sheet.getLastRowNum();
			System.out.println("Rows : "+rows);
			
			for(int i=1;i<=rows;i++){
				String username = String.valueOf(sheet.getRow(i).getCell(0));
				String password = String.valueOf(sheet.getRow(i).getCell(1));
				
				MercuryLogin.GoTo();
				MercuryLogin.LoginAs(username).WithPassword(password).Login();
				GmailPage.Sleep();
				String getURL = Browser.driver.getCurrentUrl();
				System.out.println("GetURL : "+getURL);
				String homepageURL = "http://newtours.demoaut.com/mercuryreservation.php";
				if(homepageURL.equals(getURL)){
					MercuryHomePage.SignOff();
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