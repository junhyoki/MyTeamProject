package an.login;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Login_MainPanel extends JPanel{
	
	JButton login = new Lg_Button("�α���");
	
	public Login_MainPanel(JButton login) {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(login);
	}

}
