package lee.mpcomponents;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MPprofilePanel_1 extends JPanel {

	String user_id = "abc123"; //��� Ȩ �����ӿ��� �޾Ҵٰ� ġ�� �� 

	
	JButton MPeditBtn = new JButton("�����ϱ�");
	
	public MPprofilePanel_1() {	 
		setLayout(null);
	
		
		//�����ϱ� ��ư ����
		MPeditBtn.setBounds(400, 400, 90, 38);
		MPeditBtn.setBorderPainted(false);

		
		add(MPeditBtn);		
	}
	
}
