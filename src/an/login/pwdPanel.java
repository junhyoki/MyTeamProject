package an.login;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class pwdPanel extends JPanel{
	JLabel pwl = new IdPwd_Label("��й�ȣ : ");
	
	public pwdPanel() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(pwl);
	}

}
