package DataDriven_Sikuli_PagePattern_Mercury;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class MercuryHomePage {

	public static Pattern signOff = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\signOut_button.png");
	public static Screen src = new Screen();
	public static void SignOff() {
		// TODO Auto-generated method stub
		try {
			src.click(signOff);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}