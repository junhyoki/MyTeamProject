package an.find;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import an.find.action.Find_IdAction;
import an.find.action.Find_PassAction;

public class Find_MainFrame extends JFrame{
	JButton id = new Find_Button("���̵� ã��");
	JButton pass = new Find_Button("��й�ȣ ã��"); 
	
	
	public Find_MainFrame() {
		
		
		JPanel main  = new Find_Panel();
		JPanel bt = new Find_ButtonPanel(id,pass);
		
		/////////////////////////////////////////////////////////////
		Find_IdAction idevent = new Find_IdAction(this);
		Find_PassAction passevent = new Find_PassAction(this);
		
		id.addActionListener(idevent);
		pass.addActionListener(passevent);
		
		
		///////////////////////////////////////////////////////
		add(main,BorderLayout.NORTH);
		add(bt,BorderLayout.CENTER);
		
		setBounds(660, 350, 400, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	//���̵� ã�� �̵� �̺�Ʈ
	public void Find_id() {		
		new IdFind_Frame();
		dispose();
		
	}
	
	//��й�ȣ ã�� �̵� �̺�Ʈ
	public void Find_pass() {
		new PassFind_Frame();
		 dispose();
	}

}
