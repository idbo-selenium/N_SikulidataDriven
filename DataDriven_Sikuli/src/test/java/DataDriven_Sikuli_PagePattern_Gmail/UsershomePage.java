package DataDriven_Sikuli_PagePattern_Gmail;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class UsershomePage {
	
	public static Pattern srinivasProfileClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\srinivasProfile_click.png");
	public static Pattern profileClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\profileClick.png");
	public static Pattern signOutClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\signout_click.png");
	public static Screen src = new Screen();
	public static void SignOut(String username) {
		// TODO Auto-generated method stub
		if(username.equals("srinivas.v145")){
			try {
				src.click(srinivasProfileClick);
				GmailPage.Sleep();
				src.click(signOutClick);
				//System.out.println("!!!!!!!!!!!!!!!!!!Srinivas Profile!!!!!!!!!!!!!!!!!!!!!!");
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				src.click(profileClick);
				GmailPage.Sleep();
				src.click(signOutClick);	
				//System.out.println("!!!!!!!!!!!!!!!!!!!!Others Profile!!!!!!!!!!!!!!!!!!!!!!");
			} catch (FindFailed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
}