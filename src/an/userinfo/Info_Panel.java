package an.userinfo;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Info_Panel extends JPanel{
	JButton Reservation = new Info_JButton("����");
	JButton myinfo 		= new Info_JButton("������");
	JButton logout 		= new Info_JButton("�α� �ƿ�");
	
	
	
	public Info_Panel(JButton Reservation,JButton myinfo,JButton logout) {
		this.Reservation = Reservation;
		this.myinfo = myinfo;
		this.logout = logout;
		setLayout(new GridLayout(1,0));
		add(Reservation);add(myinfo);add(logout);
	}
}
