package an.login;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PwdPanel extends JPanel{
	JLabel pwl = new IdPwd_Label("��й�ȣ : ");
	
	public PwdPanel() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		setBackground(new Color(0x77757B));
		add(pwl);
	}

}
