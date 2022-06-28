package lee.mpcomponents;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class MPleavePanel extends JPanel {
	
	
	JLabel MPleaveConfirmLb = new JLabel("<html>���� Ż�� ���Ͻø� ��й�ȣ�� �Է����ּ���.</html>");
	JButton MPleaveYesBtn = new JButton("Ȯ��");
	JPasswordField MPleavePf = new JPasswordField();
	
	public MPleavePanel() {
		
		setLayout(null);
		
		//Ż���Ͻðڽ��ϱ�? �� ����
		MPleaveConfirmLb.setBounds(30, 30, 300, 60);
		MPleaveConfirmLb.setOpaque(true);
		MPleaveConfirmLb.setFont(new Font("���", Font.BOLD, 15));
		add(MPleaveConfirmLb);

		JLabel MPleavePwLb = new JLabel();
		MPleavePwLb.setText("��й�ȣ ");
		MPleavePwLb.setBounds(30, 100, 100, 27);
		MPleavePwLb.setFont(new Font("���", Font.BOLD, 15));
		add(MPleavePwLb);
		
		//��й�ȣ �ؽ�Ʈ�ʵ� ����
		MPleavePf.setBounds(100, 100, 250, 27);
		MPleavePf.setEchoChar('��');
		add(MPleavePf);
		
		//Ȯ�� ��ư ����
		MPleaveYesBtn.setBounds(380, 170, 90, 38);
		MPleaveYesBtn.setBorderPainted(false);
		MPleaveYesBtn.setFont(new Font("���", Font.BOLD, 13));
		add(MPleaveYesBtn);

	}


	//��й�ȣ �ؽ�Ʈ ��� �޼���
	public String MPgetPwd(JPasswordField MPnewpwTf) {
		StringBuilder pw = new StringBuilder();	
		char[] secret_pw = MPnewpwTf.getPassword(); 

	    for(char cha : secret_pw){         
	        Character.toString(cha); 
	        pw.append(cha);
	    }
		return pw.toString();
	}


}
