package an.login;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class loginPanel extends JPanel{
	
	JButton login = new Lg_Button("�α���");
	
	public loginPanel() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(login);
	}

}
