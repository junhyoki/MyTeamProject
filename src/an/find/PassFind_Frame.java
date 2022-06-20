package an.find;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
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
import an.sign_up.Password_Panel;

public class PassFind_Frame extends JFrame{
	JTextField nameText = new Find_TextField(10);
	JTextField idText = new Find_TextField(10);
	
	JButton button = new Find_Button("ã��");
	JButton button2 = new Find_Button("���̵� ã��");
	JButton out = new Find_Button("������");
	
	public PassFind_Frame() {
		
		
		JPanel passMain = new Pass_Mainpanel();
		
		
		JPanel all = new Pass_AllPanel(idText,nameText);
		JPanel buttonPanel = new Pass_ButtonPanel(button, button2,out);
		
		
		add(passMain,BorderLayout.NORTH);
		add(all,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		//////////////////////////////////////////////////////////////////////////
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new IdFind_Frame();
				
			}
		});
		
	
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = String.format("SELECT su_password from sign_up where user_id = '%s' and su_user_name = '%s'",
						idText.getText() ,nameText.getText());	
				
				
				try(Connection conn = OjdbcConnection.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql);) {
						
						ResultSet rset = pstmt.executeQuery();
						
						rset.next();
						String pass =rset.getString(1);
						
						JOptionPane.showMessageDialog(null, "��й�ȣ :   "+pass, "��й�ȣ ã��", 1);
						
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "�ùٸ� ������ �Է��ϼ���", "���� ����", 1);
				}
				
				
			}
		});
		
		out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		//////////////////////////////////////////////////////////////////////////
		setBounds(650, 350, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PassFind_Frame();
	}

}
