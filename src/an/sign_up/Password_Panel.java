package an.sign_up;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Password_Panel extends JPanel{
	
	JLabel password = new Sign_Label("��й�ȣ :");
	JTextField passtext;
	
public Password_Panel(JTextField passtext) {
	this.passtext = passtext;
	setLayout(new FlowLayout(FlowLayout.RIGHT));
	add(password);add(passtext);
	
}

}
