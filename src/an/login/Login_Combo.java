package an.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

public class Login_Combo extends JComboBox<String>{
	
	public Login_Combo() {
		
		setForeground(new Color(0XFFFFFF));
		setBackground(new Color(0x77757B));
		setFont(new Font("�޸�����ü", Font.BOLD, 13));
		addItem("�մ�");
		addItem("������");
	}

}
