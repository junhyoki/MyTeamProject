package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MPnavPanel extends JPanel {
	
	
	// ������ ��ư�� ������ �� ��ư�� �ش��ϴ� �гε��� MP���������ӿ� �ߵ���
	JButton MPprofileBtn = new JButton("�� ���� ��ȸ/����");
	JButton MPreservationBtn = new JButton("���� Ȯ��");
	JButton MPleaveBtn = new JButton("���� Ż��");
	
	GridLayout gl = new GridLayout(3, 1);
	
	public MPnavPanel() {
	
		setLayout(gl);
		
		
		//��ư �׵θ� ���ֱ�
		MPprofileBtn.setBorderPainted(false);
		MPreservationBtn.setBorderPainted(false);
		MPleaveBtn.setBorderPainted(false);
		
		
		MPprofileBtn.setFont(new Font("���", Font.BOLD, 14));
		MPreservationBtn.setFont(new Font("���", Font.BOLD, 14));
		MPleaveBtn.setFont(new Font("���", Font.BOLD, 14));
		
		add(MPprofileBtn);
		add(MPreservationBtn);
		add(MPleaveBtn);
		
		setBackground(Color.CYAN);
		setBounds(0, 120, 180, 150);
		setVisible(true);
	}
	
}
