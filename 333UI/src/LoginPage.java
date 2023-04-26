import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Login {
	
	private JButton createAccount;
	private JButton logIn;
	private JLabel lastName;
	private JLabel password;
	private JTextField lastNameInput;
	private JTextField passwordInput;
	private UserService userS;
	private boolean loggedIn;
	private MainPage mainPage;
	private JFrame frame;
	
	public Login(UserService userS, MainPage mainPage) {
		this.userS = userS;
		this.loggedIn = false;
		this.mainPage = mainPage;
	}
	
    public JFrame loginPage() {

        //Creating the Frame
        frame = new JFrame("Whisk and Wander: Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        
        JPanel loginPanel = new JPanel(); // the panel is not visible in output
        lastNameInput = new JTextField(20); // accepts up to 20 characters
        passwordInput = new JTextField(20); // accepts up to 20 characters
//        FieldTitle lastNameTitle = new FieldTitle(frame, lastNameInput, "Last Name");
//        FieldTitle passwordTitle = new FieldTitle(frame, passwordInput, "Password");
        lastName = new JLabel("Username: ");
        password = new JLabel("Password: ");
        lastNameInput.setHorizontalAlignment(JTextField.CENTER);  
        passwordInput.setHorizontalAlignment(JTextField.CENTER);
        
        loginPanel.add(lastName);
        loginPanel.add(lastNameInput);
        
        loginPanel.add(password);
        loginPanel.add(passwordInput);
        loginPanel.setAlignmentY(250);
        loginPanel.setAlignmentX(250);
        
        JPanel loginButtons = new JPanel();
        createAccount = new JButton("Create Account");
        logIn = new JButton("Log In");
        
        createAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				registerPressed();
			}
		});
        
        logIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logInPressed();
			}
		});
        
        loginButtons.add(logIn);
        loginButtons.add(createAccount);
        
    
        
        
//        frame.getContentPane().add(BorderLayout.CENTER, loginPanel);
        frame.add(loginPanel, BorderLayout.NORTH);
        frame.add(new JLabel(new ImageIcon("src/loginImage.jpeg")));
        frame.add(loginButtons, BorderLayout.SOUTH);
        frame.setVisible(true);
        
        return frame;
    }
    
    private void registerPressed(){
    	String username = lastNameInput.getText();
    	String pass = passwordInput.getText();
    	if(userS.register(username, pass)) {
    		this.loggedIn = true;
    		System.out.println("Registered!");
    	} else {
    		System.out.println("An Error has Occurred");
    	}
    }
    
    private void logInPressed() {
    	String username = lastNameInput.getText();
    	String pass = passwordInput.getText();
    	if(userS.login(username, pass)) {
    		this.loggedIn = true;
    		System.out.println("Logged In!");
    		JFrame mainPageFrame = mainPage.getMainPage();
    		mainPageFrame.setVisible(true);
    		frame.setVisible(false);
    	} else {
    		System.out.println("An Error has Occurred");
    	}
    }
    
    public boolean isUserLogedIn() {
    	return this.loggedIn;
    }
    
    
    
}