package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPreservationPanel extends JPanel {

	
	JLabel MPreservationLb = new JLabel("���� ���ų����� �������� �ʽ��ϴ�.");
	JButton MPreservationcancleBtn = new JButton("�������");

	public MPreservationPanel() {
		
		setLayout(null);
		
		//���ų��� ��� �� ���� (�������� x / ���ų���) 
		MPreservationLb.setOpaque(true);
		MPreservationLb.setBackground(Color.PINK);
		MPreservationLb.setBounds(65, 30, 450, 350);
		MPreservationLb.setFont(new Font("�ü�ü", Font.PLAIN, 17));
		
		//���� ��� ��ư ���� (���ų��� ������ setVisible(false))
		MPreservationcancleBtn.setBounds(450, 400, 90, 38);
		MPreservationcancleBtn.setBorderPainted(false);
		
		
		add(MPreservationLb);
		add(MPreservationcancleBtn);
	}

	
}
