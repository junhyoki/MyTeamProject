package an.sign_up;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Password_Panel extends JPanel{
	
	JLabel password = new Sign_Label("��й�ȣ :");
	JTextField passtext;
	JButton checkpass = new Action_button("��й�ȣ Ȯ��");
	
public Password_Panel(JTextField passtext,JButton checkpass) {
	this.checkpass = checkpass;
	this.passtext = passtext;
	setLayout(new FlowLayout(FlowLayout.LEFT));
	add(password);add(passtext);add(checkpass);
	
}

}
