package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPprofilePanel_1 extends JPanel {

	
	public MPprofilePanel_1() {
		 
		setLayout(null);
		
		
		JLabel MPprofileLb = new JLabel("�� ������ �¶�� (��񿡼� �ܾ����) "); //������ HTML�� �ٹٲ��ߴ� �� ����
		JButton MPeditBtn = new JButton("�����ϱ�");
		
		
		
		//�����ʶ� ����
		MPprofileLb.setOpaque(true);//���߿� ���� 
		MPprofileLb.setBackground(Color.PINK);
		MPprofileLb.setFont(new Font("�ü�ü", Font.PLAIN, 20)); //���߿� ����
		MPprofileLb.setBounds(30, 30, 520, 360);
		
		
		//�����ϱ� ��ư ����
		MPeditBtn.setBounds(480, 415, 90, 38);
		MPeditBtn.setBorderPainted(false);
		
		
		add(MPprofileLb);
		add(MPeditBtn);		
	}
}
