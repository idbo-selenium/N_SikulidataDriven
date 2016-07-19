package DataDriven_Sikuli_PagePattern_GitHub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import DataDriven_Sikuli_PagePattern_Gmail.Browser;
import DataDriven_Sikuli_PagePattern_Gmail.GmailPage;

public class GitHub_ExcelHandler {

	@Test
	public void ExcelHandler()throws Exception{
		try {
			FileInputStream githubFile =  new FileInputStream("GitHub.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(githubFile);
			XSSFSheet sheet = workbook.getSheet("GitHubLogin");
			
			int githubSheetRows = sheet.getLastRowNum();
			System.out.println("githubSheetRows : "+githubSheetRows);
			
			for(int i=1;i<=githubSheetRows;i++){
				String username = String.valueOf(sheet.getRow(i).getCell(0));
				String password = String.valueOf(sheet.getRow(i).getCell(1));
				System.out.println(username+" , "+password);
				
				GitHubLoginPage.GoTo();
				GitHubLoginPage.LoginAs(username).WithPassword(password).LoginAs();
				GmailPage.Sleep();
				String homepageURL = "https://github.com/";
				String getURL = Browser.driver.getCurrentUrl();
				System.out.println("getURL : "+getURL);
				if(getURL.equals(homepageURL)){
					GitHubHomePage.SignOut();
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