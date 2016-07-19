package DataDriven_Sikuli_PagePattern_GitHub;

import DataDriven_Sikuli_PagePattern_Gmail.Browser;

public class GitHubLoginPage {

	public static GitHub_LoginDetails LoginAs(String username) {
		// TODO Auto-generated method stub
		return new GitHub_LoginDetails(username);
	}

	public static void GoTo() {
		// TODO Auto-generated method stub
		Browser.OpenBrowser();
		Browser.driver.get("https://github.com/login");
	}
}