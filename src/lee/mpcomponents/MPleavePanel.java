package lee.mpcomponents;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPleavePanel extends JPanel {
	
	
	JLabel MPleaveConfirmLb = new JLabel("���� Ż���Ͻðڽ��ϱ�?");
	JButton MPleaveYesBtn = new JButton("��");
	
	
	public MPleavePanel() {
		
		setLayout(null);
		
		//Ż���Ͻð�? �� ����
		MPleaveConfirmLb.setBounds(30, 30, 400, 60);
		MPleaveConfirmLb.setOpaque(true);
		MPleaveConfirmLb.setBackground(Color.pink);
		
		//�� ��ư ����
		MPleaveYesBtn.setBounds(380, 100, 90, 38);
		MPleaveYesBtn.setBorderPainted(false);
		

		
		
		add(MPleaveConfirmLb);
		add(MPleaveYesBtn);
		
	}
}
