package an.admin;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import an.login.Login_Mainframe;

public class Admin_MainFrame extends JFrame{
	JButton userModify = new Admin_Button("ȸ������ ����");
	JButton routemodify = new Admin_Button("�뼱���� ����");
	JButton out 		= new Admin_Button("������");
	
	JPanel main = new Admin_MainPanel(userModify, routemodify, out);
	JPanel imagepanel = new Admin_MainImagePanel();
	public Admin_MainFrame() {
		setTitle("������ ������");
		
		add(main,BorderLayout.SOUTH);
		add(imagepanel,BorderLayout.CENTER);
		//////////////////////////////////////////////////////////////////
		
		//ȸ������ �����̵� �׼�
		userModify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//�뼭���� �����̵� �׼�
		routemodify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//������ �׼�
		out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login_Mainframe();
				
			}
		});
		///////////////////////////////////////////////////////////////////
		setBounds(500, 200, 800, 500);
		setResizable(false);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Admin_MainFrame();
		
	}

}
