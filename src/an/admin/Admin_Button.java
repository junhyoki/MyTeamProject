package an.admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Admin_Button extends JButton{
	
	public Admin_Button(String str) {
		super(str);
		EmptyBorder b1 = new EmptyBorder(5,3,5,3);
		setBorder(b1);
		setFont(new Font("�޸�����ü", Font.BOLD, 25));
		setForeground(new Color(0X000000));
		setBackground(new Color(0xFFFFFF));
	}

}
