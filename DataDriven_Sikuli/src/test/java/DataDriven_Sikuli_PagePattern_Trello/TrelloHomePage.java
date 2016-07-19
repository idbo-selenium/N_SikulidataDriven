package DataDriven_Sikuli_PagePattern_Trello;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class TrelloHomePage {

	public static Pattern profileClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\profile_click.png");
	public static Pattern signOutClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\logout_click.png");
	
	public static Screen src = new Screen();
	public static void SignOut() {
		// TODO Auto-generated method stub
		try {
			src.click(profileClick);
			src.click(signOutClick);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}