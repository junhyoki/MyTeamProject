package lee.mpcomponents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MPreservationPanel extends JPanel {

	
	JPanel MPreservationlistPanel = new JPanel();
	JButton MPreservationcancleBtn = new JButton("�������");

	public MPreservationPanel() {
		
		setLayout(null);

		
		//���ų��� ���� �� / ���ų��� ���� �г�  
		//���ų��� ���� �г� �ȿ��� ������� ����Ƽ�� ����� ���� �ϴµ� �װ� �гη� ������ �ϳ�... �г� ������ ���Ű����� ���� ���ؾ߰ڳ�
		MPreservationlistPanel.setBounds(65, 30, 390, 350);
		MPreservationlistPanel.setOpaque(true);
		MPreservationlistPanel.setBackground(Color.YELLOW);
		
		
		
		//���� ��� ��ư ���� (���ų��� ������ setVisible(false) ����ߵ� �����)
		MPreservationcancleBtn.setBounds(400, 400, 90, 38);
		MPreservationcancleBtn.setBorderPainted(false);
		
		
		add(MPreservationlistPanel);
		add(MPreservationcancleBtn);
		
	}
}
