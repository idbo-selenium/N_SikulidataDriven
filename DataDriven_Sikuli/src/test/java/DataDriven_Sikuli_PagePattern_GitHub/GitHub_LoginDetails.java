package DataDriven_Sikuli_PagePattern_GitHub;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class GitHub_LoginDetails {

	public String username;
	public String password;
	Pattern usernameSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\username_textbox.png");
	Pattern passwordSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\password_textbox.png");
	Pattern signin = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\signin_button.png");
	Screen src = new Screen();
	
	public GitHub_LoginDetails(String username){
		this.username = username;
	}
	public GitHub_LoginDetails WithPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
		return this;
	}
	public void LoginAs() {
		// TODO Auto-generated method stub
		try {
			src.type(usernameSnip, username);
			src.type(passwordSnip, password);
			src.click(signin);			
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}