package an.admin;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Admin_MainPanel extends JPanel{
	JButton userModify = new Admin_Button("ȸ������ ����");
	JButton routemodify = new Admin_Button("�뼱���� ����");
	JButton out 		= new Admin_Button("������");
	public Admin_MainPanel(JButton j1, JButton j2, JButton j3) {
		userModify = j1;
		routemodify = j2;
		out = j3;
		
		setLayout(new GridLayout(1,0));
		add(userModify);add(routemodify);
		add(out);
		
	}

}
