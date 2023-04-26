import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RecipePage {
	public RecipePage() {
		
	}
	
	public JFrame getRecipePage() {
        JFrame frame = new JFrame("Whisk and Wander");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("All Recipes");
        JMenu m2 = new JMenu("My Recipes");
        JButton logOut = new JButton("Log Out");
        mb.add(m1);
        mb.add(m2);
        mb.add(Box.createHorizontalGlue());
        mb.add(logOut);
        
        JMenuItem m11 = new JMenuItem("Seach");
        JMenuItem m22 = new JMenuItem("Favorites");
        m1.add(m11);
        m1.add(m22);
        
        JTextArea recipeTitle = new JTextArea("Recipe Info Here");


        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(recipeTitle);

        frame.setVisible(true);
        
        return frame;
	}
}
