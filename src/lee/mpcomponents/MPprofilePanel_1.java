package lee.mpcomponents;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lee.OjdbcConnection;
import lee.mpmodel.MPuserinfoModel;

public class MPprofilePanel_1 extends JPanel {

	String user_id = "abc123"; //��� Ȩ �����ӿ��� �޾Ҵٰ� ġ�� �� 
	
	
	/*
	String MPprofile = 
			"<html><pre style=\"font-family:���;\">���̵�    : " + user_id 
			+ "<br><br>�̸�       : " + user_name + 
			"<br><br>����ó    : " + phoneNum + 
			"</pre><html/>";	
	 */
		
	//JLabel MPprofileLb = new JLabel(MPprofile); 
	
	String MPprofileLbStr;
	
	JLabel MPprofileLb = new JLabel(MPprofileLbStr); 
	
	JButton MPeditBtn = new JButton("�����ϱ�");
	
	public MPprofilePanel_1() {	 
		setLayout(null);
	
		try (
				Connection conn = OjdbcConnection.getConnection();				
				PreparedStatement pstmt = conn.prepareStatement("SELECT user_name, user_phonenum FROM user_info WHERE user_id = ?;");
				ResultSet rs = pstmt.executeQuery();
		){
			pstmt.setString(1, user_id);
			
			MPprofileLbStr = new MPuserinfoModel(rs).toString();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	
		

		
		//�����ʶ� ����
		MPprofileLb.setOpaque(true);//���߿� ���� 
		//MPprofileLb.setBackground(Color.PINK);
		MPprofileLb.setFont(new Font("���", Font.BOLD, 18)); 
		MPprofileLb.setBounds(50, 50, 390, 200);
		MPprofileLb.setVerticalAlignment(JLabel.TOP);
		
		//�����ϱ� ��ư ����
		MPeditBtn.setBounds(400, 400, 90, 38);
		MPeditBtn.setBorderPainted(false);
		
		
		add(MPprofileLb);
		add(MPeditBtn);		
	}
	
}
