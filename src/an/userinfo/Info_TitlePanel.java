package an.userinfo;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import an.admin.Admin_TitleLabel;

public class Info_TitlePanel extends JPanel{
	JLabel title = new Admin_TitleLabel("���� ���");
	public Info_TitlePanel() {
		setBackground(new Color(0X182535));
		add(title);
	}

}
