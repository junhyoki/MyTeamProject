package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lee.OjdbcConnection;
import lee.mpmodel.MPreservationlistModel;

public class MPreservationlistPanel extends JPanel {
	
	//�� Ŭ������ ���Ź�ȣ �����ϴ� ���� �ϳ� �����߰��� �׷��� üũ�ڽ� ������ �� � ���Ź�ȣ ������ ���� �� �� ���� �� ����
	int br_id;//���Ź�ȣ
	String reservationdetailStr;
	
	
	int MPticketNum;
	
	
	public MPreservationlistPanel(Integer br_id, String reservationdetailStr) {
		
		this.br_id = br_id;//���Ź�ȣ �޴°� ����!
		this.reservationdetailStr = reservationdetailStr;
		
		
		JLabel MPreservationdetailLb = new JLabel(reservationdetailStr);
		//�������� �ߴ� �� ����
		MPreservationdetailLb.setBounds(20, 0, 300, 150);
		MPreservationdetailLb.setFont(new Font("���", Font.BOLD, 14));


		add(MPreservationdetailLb);		

		
		setLayout(null);
		setOpaque(true);
		//setBackground(Color.LIGHT_GRAY);  
		setSize(470, 180);
	}
}
