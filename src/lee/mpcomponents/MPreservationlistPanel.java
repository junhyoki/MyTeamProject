package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPreservationlistPanel extends JPanel {
	
	//�� Ŭ������ ���Ź�ȣ �����ϴ� ���� �ϳ� �����߰��� �׷��� üũ�ڽ� ������ �� � ���Ź�ȣ ������ ���� �� �� ���� �� ���� ��
	
	JLabel MPreservationdetailLb = new JLabel(
			"<html>���Ź�ȣ : 01204<br>"
			+ "2022/05/12  12�� 24��<br>"
			+ "������ ��� �͹̳� - ���� ��� �͹̳�<br>"
			+ "�¼� : 01<br>"
			+ "���ɱ��� : ���<br>"
			+ "��� : 5500(���� ���� ��)</html>"); //�̰� ����. db���� ���� ���� ������ �ٲٱ�
	
	JCheckBox MPcheckbox = new JCheckBox();
	
	
	public MPreservationlistPanel() {
		
		setLayout(null);
		setOpaque(true);
		//setBackground(Color.LIGHT_GRAY);  
		setSize(470, 180);
		
		
		//�������� �ߴ� �� ����
		MPreservationdetailLb.setBounds(20, 0, 300, 150);
		MPreservationdetailLb.setFont(new Font("���", Font.BOLD, 14));
		
		
		//�n�� ����
		MPcheckbox.setBounds(400, 77, 18, 18);
		//MPcheckbox.setBackground(Color.LIGHT_GRAY);
		
		
		add(MPreservationdetailLb);		
		add(MPcheckbox);
	}
}
