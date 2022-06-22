package lee.mpcomponents;

import java.awt.CardLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lee.OjdbcConnection;
import lee.mpmodel.MPprofileModel;

public class MPprofilePanel extends JPanel {

	MPprofilePanel_1 MPprofile_1 = new MPprofilePanel_1();
	MPprofilePanel_2 MPprofile_2 = new MPprofilePanel_2();
	
	CardLayout MPprofileCard = new CardLayout();
	
	String user_id  = "abc123"; //���߿� ����
	
	public MPprofilePanel() {
		
		setLayout(MPprofileCard);

		add("������ ����", MPprofile_1);
		add("������ ����", MPprofile_2);
		
		//profile_1 �� �� ���� �ߴ� �� ���̱�_____________________________________________________________________________
		String sql = "SELECT user_id, user_name, user_phonenum, user_password FROM user_info WHERE user_id = ?";
		String MPprofileLbStr = "";	
		MPprofileModel pm = null;
		try (
				Connection conn = OjdbcConnection.getConnection();				
				PreparedStatement pstmt = conn.prepareStatement(sql);		
		){
			pstmt.setString(1, user_id);  // �� pstmt.setString()�� ����ǥ ���� ä���ְ� rs��ߵ�!
		
			try(ResultSet rs = pstmt.executeQuery();){
				//��
				while(rs.next()) {
					pm = new MPprofileModel(rs);
					MPprofileLbStr = pm.toString();				
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel MPprofileLb = new JLabel(MPprofileLbStr);
		//�����ʶ� ����
		MPprofileLb.setOpaque(true);//���߿� ���� 
		//MPprofileLb.setBackground(Color.PINK);
		MPprofileLb.setFont(new Font("���", Font.BOLD, 18)); 
		MPprofileLb.setBounds(50, 50, 390, 200);
		MPprofileLb.setVerticalAlignment(JLabel.TOP);
		MPprofile_1.add(MPprofileLb);
		//__________________________________________________________________________________________________________________
		
		
		//MPprofile_2�� tf�鿡 ȸ�������� �⺻���� �� �ְ�_________________________________________________________________________
		MPprofile_2.MPnameTf.setText(pm.getUser_name());
		MPprofile_2.MPphoneTf.setText(pm.getUser_phonenum());
		MPprofile_2.MPnewpwTf.setText(pm.getUser_password());
		//__________________________________________________________________________________________________________________

	}
	

	
	
	
	
	
	public void showMPprofile_2() {
		MPprofileCard.show(this, "������ ����");
	}
	
	
	public void showMPprofile_1() {
		MPprofileCard.show(this, "������ ����");
	}
	
}
