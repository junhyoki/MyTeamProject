package lee.mpcomponents;

import javax.swing.JButton;
import javax.swing.JPanel;

import hong.SaveInfo;

public class MPprofilePanel_1 extends JPanel {

	SaveInfo saveInfo;
	
	String user_id;   

	
	JButton MPeditBtn = new JButton("�����ϱ�");
	
	public MPprofilePanel_1(SaveInfo saveInfo) {	 
		this.saveInfo = saveInfo;
		this.user_id = saveInfo.get_user_id();
		
		setLayout(null);
	
		
		//�����ϱ� ��ư ����
		MPeditBtn.setBounds(400, 400, 90, 38);
		MPeditBtn.setBorderPainted(false);

		
		add(MPeditBtn);		
	}
	
}
