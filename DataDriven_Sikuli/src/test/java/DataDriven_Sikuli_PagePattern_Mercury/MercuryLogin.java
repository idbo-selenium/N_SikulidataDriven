package DataDriven_Sikuli_PagePattern_Mercury;

import DataDriven_Sikuli_PagePattern_Gmail.Browser;

public class MercuryLogin {

	public static MercuryData LoginAs(String username) {
		// TODO Auto-generated method stub
		return new MercuryData(username);
	}

	public static void GoTo() {
		// TODO Auto-generated method stub
		Browser.OpenBrowser();
		Browser.driver.get("http://newtours.demoaut.com/");
	}
}