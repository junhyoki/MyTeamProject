package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPreservationPanel extends JPanel {

	
	JPanel MPreservationlistPanel = new JPanel();
	JButton MPreservationcancleBtn = new JButton("�������");

	public MPreservationPanel() {
		
		setLayout(null);

		MPreservationlistPanel.setBounds(65, 30, 390, 350);
		MPreservationlistPanel.setOpaque(true);
		MPreservationlistPanel.setBackground(Color.PINK);
		
		/*
		JLabel MPreservationLb = new JLabel("���� ���ų����� �������� �ʽ��ϴ�.");
		�̰� �гη� �ٲ㼭 ���ų��� ���� �� / ���ų��� ���� �г� ����� �� 
		���ų��� ���� �г� �ȿ��� ������� ����Ƽ�� ����� ���� �ϴµ� �װ� �гη� ������ �ϳ�... �г� ������ ���Ű����� ���� ���ؾ߰ڳ�
	
		//���ų��� ��� �� ���� (�������� x / ���ų���) 
		MPreservationLb.setOpaque(true);
		MPreservationLb.setBackground(Color.PINK);
		MPreservationLb.setBounds(65, 30, 450, 350);
		MPreservationLb.setFont(new Font("�ü�ü", Font.PLAIN, 17));
		
		add(MPreservationLb);
		*/
				
		//���� ��� ��ư ���� (���ų��� ������ setVisible(false))
		MPreservationcancleBtn.setBounds(400, 400, 90, 38);
		MPreservationcancleBtn.setBorderPainted(false);
		
		
		add(MPreservationlistPanel);
		add(MPreservationcancleBtn);
	}

	
}
