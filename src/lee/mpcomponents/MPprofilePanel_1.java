package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPprofilePanel_1 extends JPanel {

	String MPprofile = "<html><pre style=\"font-family:���;\">���̵�    : banana123<br><br>�̸�       : �ٳ���<br><br>����ó    : 010-1234-1234</pre><html/>";	
	
	JLabel MPprofileLb = new JLabel(MPprofile); //������ HTML�� �ٹٲ��ߴ� �� ����
	
	JButton MPeditBtn = new JButton("�����ϱ�");
	
	public MPprofilePanel_1() {	 
		
		setLayout(null);
		 

		
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
