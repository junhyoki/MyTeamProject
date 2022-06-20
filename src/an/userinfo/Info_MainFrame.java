package an.userinfo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import an.login.Login_Mainframe;

public class Info_MainFrame extends JFrame{
	JButton Reservation = new Info_JButton("����");
	JButton myinfo 		= new Info_JButton("������");
	JButton logout 		= new Info_JButton("�α� �ƿ�");
	JPanel card 		= new Info_CardPanel();
	JPanel panel = new Info_Panel(Reservation,myinfo,logout);
	public Info_MainFrame() {
		setTitle("��������");
		add(card,BorderLayout.CENTER);
		add(panel,BorderLayout.NORTH);
		/////////////////////////////////////////
		// ���� �̺�Ʈ
		Reservation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		//������ �̺�Ʈ
		myinfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
			}
		});
		
		//�α׾ƿ� �̺�Ʈ
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		setBounds(500, 200, 1000, 800);
		setResizable(false);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Info_MainFrame();
	}
}
