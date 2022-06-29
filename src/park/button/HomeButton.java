package park.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import an.userinfo.Info_MainFrame;
import hong.SaveInfo;
import park.database.LoadRVID;
import park.database.SaveDB;
import park.frame.PayInfo;

public class HomeButton extends JButton{ // Ȩ ȭ������ ���� ��ư

	public HomeButton(SaveInfo user) {
		super("Home");
			
		setSize(40, 40);
		setFont(new Font("�ü�ü", Font.BOLD,15));
		setForeground(new Color(0x000000));
		setBackground(new Color(0xffff00));
	}
}
