package an.find;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Find_MainFrame extends JFrame{
	JButton id = new Find_Button("���̵� ã��");
	JButton pass = new Find_Button("��й�ȣ ã��"); 
	JButton out = new Find_Button("������");
	
	
	public Find_MainFrame() {
		
		
		JPanel main  = new Find_Panel();
		JPanel bt = new Find_ButtonPanel(id,pass,out);
		/////////////////////////////////////////////////////////////
		id.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new IdFind_Frame();
				
			}
		});
		out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 dispose();
				
			}
		});
		
		
		pass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new PassFind_Frame();
				
			}
		});
		
		
		///////////////////////////////////////////////////////
		add(main,BorderLayout.NORTH);
		add(bt,BorderLayout.SOUTH);
		
		setBounds(610, 200, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Find_MainFrame();
	}

}