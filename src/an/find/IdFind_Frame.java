package an.find;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.find.action.Id_FindAction;
import an.find.action.Id_OutAction;
import an.find.action.Id_PassAction;

public class IdFind_Frame extends JFrame{
	JTextField nameText = new Find_TextField(10);
	JTextField pnText = new Find_TextField(10);
	
	JButton button = new Find_Button("ã��");
	JButton button2 = new Find_Button("��й�ȣ ã��");
	JButton out = new Find_Button("������");
	
	public IdFind_Frame() {
		
		
		JPanel ipmain = new IdFind_Panel();
		
		
		JPanel idPn = new IdFind_ALLPanel(nameText,pnText);
		
		
		JPanel buttonPanel = new IdFind_ButtonPanel(button,button2,out);
		
		add(ipmain,BorderLayout.NORTH);
		add(idPn,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		Id_FindAction findevent = new Id_FindAction(this);
		Id_OutAction  outevent = new Id_OutAction(this); 
		Id_PassAction passevent = new Id_PassAction(this);
		
		button. addActionListener(findevent);
		button2.addActionListener(passevent);//��й�ȣ �̵�
		out.addActionListener(outevent);
			
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		setBounds(660, 350, 400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	
	
	//���̵� ã�� �׼�
	public void idFindAction() {
		String sql = String.format("SELECT user_id from user_info where user_name = '%s' and user_phonenum = '%s'",
				nameText.getText() ,pnText.getText());
		System.out.println(nameText.getText());
		System.out.println(pnText.getText());
		
		try(Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
				
				ResultSet rset = pstmt.executeQuery();
				
				rset.next();
				
				String id =rset.getString(1);
				
				JOptionPane.showMessageDialog(null, "���̵� :   "+id, "���̵� ã��", 1);
				
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "�ùٸ� ������ �Է��ϼ���", "���� ����", 1);
		}
		
	}
	//��й�ȣã�� �̵� �׼�
	public void idpassAction() {
		dispose();
		new PassFind_Frame();
		
	}
	//���̵�ã�� �̵� �׼�
	public void idoutAction() {
		dispose();
	}
	
}
