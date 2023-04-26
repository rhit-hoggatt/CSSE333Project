import javax.swing.JFrame;

public class Controller {
	JFrame mainPageFrame;
	JFrame loginFrame;
	JFrame recipePageFrame;
	Login login;
	
	public Controller() {
		
		MainPage mainPage = new MainPage();
		
		DatabaseConnectionService dbService = new DatabaseConnectionService("titan.csse.rose-hulman.edu", "WhiskAndWander");
		
		if(dbService.connect("hoggatjw", "VerySecurePassword2")) {	//this is a throwaway pass for me but plz dont dox me
			System.out.println("Connection Successful");
		} else {
			System.out.println("A connection error has occurred");
		}
		
		UserService userS = new UserService(dbService);
		
		makeLoginPage(userS, mainPage);
		if(login.isUserLogedIn()) {
			closeLoginPage();
			makeMainPage(mainPage);
		}
		
	}
	
	
	
	public void makeMainPage(MainPage mainPage) {
		
		mainPageFrame = mainPage.getMainPage();
		mainPageFrame.setVisible(true);
	}
	
	public void closeMainPage() {
		mainPageFrame.setVisible(false);
	}
	
	public void makeLoginPage(UserService userS, MainPage mainPage) {
		login = new Login(userS, mainPage);
		loginFrame = login.loginPage();
		loginFrame.setVisible(true);
	}
	
	public void closeLoginPage() {
		loginFrame.setVisible(false);
	}
	
	public void makeRecipePage() {
		RecipePage recipePage = new RecipePage();
    	recipePageFrame = recipePage.getRecipePage();
    	recipePageFrame.setVisible(true);
	}
	
	public void closeRecipePage() {
		recipePageFrame.setVisible(false);
	}
}
