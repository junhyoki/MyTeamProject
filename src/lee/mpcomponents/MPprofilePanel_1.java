package lee.mpcomponents;

import javax.swing.JButton;
import javax.swing.JPanel;

import hong.SaveInfo;

public class MPprofilePanel_1 extends JPanel {
	
	JButton MPeditBtn = new JButton("�����ϱ�");
	
	public MPprofilePanel_1() {

		setLayout(null);
		
		//�����ϱ� ��ư ����
		MPeditBtn.setBounds(400, 400, 90, 38);
		MPeditBtn.setBorderPainted(false);
		
		add(MPeditBtn);		
	}
	
}
