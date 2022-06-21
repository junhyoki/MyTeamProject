package park.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import park.ReservationInfo;
import park.frame.Pay;

public class BeforePayInfoButton extends JButton{ // ���� ȭ������ ���� ��ư

	public BeforePayInfoButton(ReservationInfo user) {
	super("Before");
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("before��ư Ŭ��"); // �׽�Ʈ��
				new Pay(user);
			}
		});
		
		setSize(40, 40);
		setFont(new Font("�ü�ü", Font.BOLD,15));
		setForeground(new Color(0x000000));
		setBackground(new Color(0xffff00));		
	}
	
}
