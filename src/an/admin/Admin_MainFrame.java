package an.admin;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Admin_MainFrame extends JFrame{
	JButton userModify = new Admin_Button("ȸ������ ����");
	JButton routemodify = new Admin_Button("�뼱���� ����");
	
	JPanel main = new Admin_MainPanel(userModify, routemodify);
	public Admin_MainFrame() {
		setTitle("������ ������");
		
		add(main,BorderLayout.NORTH);
		
		setBounds(500, 200, 1000, 800);
		setResizable(false);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); 
	}
	
	public static void main(String[] args) {
		new Admin_MainFrame();
		
	}

}
