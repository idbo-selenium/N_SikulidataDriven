package DataDriven_Sikuli_PagePattern_Gmail;

public class GmailPage {

	public static void Goto() {
		// TODO Auto-generated method stub		
		Browser.OpenBrowser();
		Browser.Driver().navigate().to("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier");
	}

	public static void Sleep() throws Exception{
		// TODO Auto-generated method stub
		Thread.sleep(4000);
	}
}