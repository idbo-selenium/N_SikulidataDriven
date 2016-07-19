package DataDriven_Sikuli_PagePattern_Gmail;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class GmailLogin {

//	public static LoginAs LoginAs(String username) {
//		// TODO Auto-generated method stub
//		return new LoginAs(username);
//	}
	
	public static Pattern usernameSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\username.png");
	public static Pattern nextButton = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\nextButton.png");
	public static Pattern passwordSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\password.png");
	public static Pattern signInButton = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\signinButton.png");
	
	public static Screen src = new Screen();
	
	public static void Goto() {
		// TODO Auto-generated method stub
		Browser.driver.get("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier");
	}

	public static void LoginAs(String username) {
		// TODO Auto-generated method stub
		try {
			src.type(usernameSnip, username);
			src.click(nextButton);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void WithPassword(String password) {
		// TODO Auto-generated method stub
		try {
			src.type(passwordSnip, password);
			src.click(signInButton);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}