package an.find;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.OjdbcConnection;
import an.find.action.Pass_FindAction;
import an.find.action.Pass_IdAction;
import an.find.action.Pass_OutAction;
import an.sign_up.Password_Panel;

public class PassFind_Frame extends JFrame{
	JTextField nameText = new Find_TextField(10);
	JTextField idText = new Find_TextField(10);
	
	ImageIcon buttonimage = new ImageIcon("image/find2.png");
	ImageIcon idimage = new ImageIcon("image/findid.png");
	ImageIcon outimage = new ImageIcon("image/out.png");
	
	JButton button = new Find_Button("");
	JButton button2 = new Find_Button("");
	JButton out = new Find_Button("");
	
	public PassFind_Frame() {
		
		button.setIcon(buttonimage);
		button2.setIcon(idimage);
		out.setIcon(outimage);
		
		
		
		JPanel passMain = new Pass_Mainpanel();
		
		
		JPanel all = new Pass_AllPanel(idText,nameText);
		JPanel buttonPanel = new Pass_ButtonPanel(button, button2,out);
		
		
		add(passMain,BorderLayout.NORTH);
		add(all,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		//////////////////////////////////////////////////////////////////////////
		Pass_IdAction idevent = new Pass_IdAction(this);
		Pass_FindAction findevent = new Pass_FindAction(this);
		Pass_OutAction outevent = new Pass_OutAction(this);
		
		button2.addActionListener(idevent); 
		button.addActionListener(findevent);
		out.addActionListener(outevent); 
			
		
		//////////////////////////////////////////////////////////////////////////
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	
	//??????????
	public void findAction() {
		String sql = String.format("SELECT user_password from user_info where user_id = '%s' and user_name = '%s'",
				idText.getText() ,nameText.getText());	
		
		
		try(Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
				
				ResultSet rset = pstmt.executeQuery();
				
				rset.next();
				String pass =rset.getString(1);
				
				JOptionPane.showMessageDialog(null, "???????? :   "+pass, "???????? ????", 1);
				
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "?????? ?????? ??????????", "???? ????", 1);
		}
		
	}
	//?????? ??????
	
	public void outAction() {
		dispose();
	}
	
	//?????? ??????
	public void idAction() {
		dispose();
		new IdFind_Frame();
	}
}
