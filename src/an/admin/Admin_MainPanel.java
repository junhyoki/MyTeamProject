package an.admin;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Admin_MainPanel extends JPanel{
	JButton userModify = new Admin_Button("ȸ������ ����");
	JButton routemodify = new Admin_Button("�뼱���� ����");
	public Admin_MainPanel(JButton j1, JButton j2) {
		userModify = j1;
		routemodify = j2;
		
		setLayout(new FlowLayout());
		add(userModify);add(routemodify);
		
		
	}

}
