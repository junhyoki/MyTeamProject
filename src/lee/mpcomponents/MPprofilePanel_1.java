package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPprofilePanel_1 extends JPanel {

	JLabel MPprofileLb = new JLabel("�� ������ �¶�� (��񿡼� �ܾ����) "); //������ HTML�� �ٹٲ��ߴ� �� ����
	
	JButton MPeditBtn = new JButton("�����ϱ�");
	
	public MPprofilePanel_1() {	 
		
		setLayout(null);
		 
		
		
		
		//�����ʶ� ����
		MPprofileLb.setOpaque(true);//���߿� ���� 
		MPprofileLb.setBackground(Color.PINK);
		MPprofileLb.setFont(new Font("�ü�ü", Font.PLAIN, 20)); //���߿� ����
		MPprofileLb.setBounds(65, 30, 390, 350);
		
		
		//�����ϱ� ��ư ����
		MPeditBtn.setBounds(400, 400, 90, 38);
		MPeditBtn.setBorderPainted(false);
		
		
		add(MPprofileLb);
		add(MPeditBtn);		
	}
	
}
