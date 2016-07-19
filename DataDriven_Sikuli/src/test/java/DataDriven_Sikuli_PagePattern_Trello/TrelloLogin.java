package DataDriven_Sikuli_PagePattern_Trello;

import DataDriven_Sikuli_PagePattern_Gmail.Browser;

public class TrelloLogin {

	public static TrelloLoginDetails LoginAs(String username) {
		// TODO Auto-generated method stub
		return new TrelloLoginDetails(username);
	}

	public static void GoTo() {
		// TODO Auto-generated method stub
		Browser.OpenBrowser();
		Browser.driver.get("https://trello.com/login"); 
	}
}