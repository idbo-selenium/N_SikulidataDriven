package DataDriven_Sikuli_PagePattern_Trello;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class TrelloLoginDetails {

	public String username;
	public String password;
	public Pattern usernameSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\username.png");
	public Pattern passwordSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\password.png");
	public Pattern signin = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\loginButton.png");	
	public Screen src = new Screen();
	
	public TrelloLoginDetails(String username) {
		// TODO Auto-generated constructor stub
		this.username = username;
	}
	public TrelloLoginDetails WithPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
		return this;
	}
	public void LoginAs() {
		// TODO Auto-generated method stub
		try {
			src.type(usernameSnip,username);
			src.type(passwordSnip, password);
			src.click(signin);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}