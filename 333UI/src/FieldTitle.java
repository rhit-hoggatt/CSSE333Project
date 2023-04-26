import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class FieldTitle {
	public FieldTitle(JFrame frame, Component c, String title){
	JLabel l = new JLabel(title);
	
    
    l.setBounds(c.getBounds().x, c.getBounds().y - 20, c.getWidth(), 20);
    frame.add(l);
	}
}
