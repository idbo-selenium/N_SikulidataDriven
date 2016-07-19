package DataDriven_Sikuli_PagePattern_Mercury;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class MercuryData {

	public String username;
	public String password;
	Pattern signOn = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\signOn_button.png");
	Pattern usernameSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\username.png");
	Pattern passwordSnip = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\password.png");
	Pattern submit = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\submit.png");
	Screen src = new Screen();
	public MercuryData(String username) {
		// TODO Auto-generated constructor stub
		this.username = username;
	}
	public MercuryData WithPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
		return this;
	}
	public void Login() {
		// TODO Auto-generated method stub
		try {
			src.click(signOn);
			src.type(usernameSnip, username);
			src.type(passwordSnip, password);
			src.click(submit);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}