package lee.mpcomponents;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPleavePanel extends JPanel {
	
	
	JLabel MPleaveConfirmLb = new JLabel("���� Ż���Ͻðڽ��ϱ�?");
	JButton MPleaveYesBtn = new JButton("��");
	
	
	public MPleavePanel() {
		
		setLayout(null);
		
		//Ż���Ͻð�? �� ����
		MPleaveConfirmLb.setBounds(30, 30, 300, 60);
		MPleaveConfirmLb.setOpaque(true);
		MPleaveConfirmLb.setFont(new Font("���", Font.BOLD, 15));
		//MPleaveConfirmLb.setBackground(Color.pink);
		
		//�� ��ư ����
		MPleaveYesBtn.setBounds(380, 100, 90, 38);
		MPleaveYesBtn.setBorderPainted(false);
		MPleaveYesBtn.setFont(new Font("���", Font.BOLD, 13));
		
		
		add(MPleaveConfirmLb);
		add(MPleaveYesBtn);
		
	}
}
