package an.admin;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class User_CheckPanel extends JPanel{
	JTextField checktext = new Admin_textFeild(10);
	JLabel checkLabel = new Admin_userLabel("������/�մ� :");
	public User_CheckPanel(JTextField text) {
		this.checktext = text;
		setLayout(new FlowLayout());
		add(checkLabel);add(checktext);
	}

}
