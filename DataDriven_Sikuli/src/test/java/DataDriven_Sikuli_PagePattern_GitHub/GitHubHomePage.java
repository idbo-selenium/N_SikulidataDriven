package DataDriven_Sikuli_PagePattern_GitHub;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import DataDriven_Sikuli_PagePattern_Gmail.GmailPage;

public class GitHubHomePage {

	static Pattern profileClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\profile.png");
	static Pattern signOut = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\signout.png");
	static Screen src = new Screen();
	public static void SignOut() {
		// TODO Auto-generated method stub
		try {
			src.click(profileClick);
			GmailPage.Sleep();
			src.click(signOut);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}