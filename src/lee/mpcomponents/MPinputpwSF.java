package lee.mpcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class MPinputpwSF extends JFrame {
	JButton completeBtn = new JButton("�Է�");	
	JPasswordField inputpwPf = new JPasswordField(25);
	
	public MPinputpwSF() {
		super("��й�ȣ �Է�");
		
		JLabel label = new JLabel("��й�ȣ�� �Է��ϼ���.");

		// �� ����
		label.setBounds(110, 40, 300, 30);
		add(label);
		
		//�Է� ��ư ����
		completeBtn.setBounds(125, 130, 80, 30);
		add(completeBtn);	
		
		inputpwPf.setBounds(85, 80, 170, 30);
		inputpwPf.setEchoChar('��');
		add(inputpwPf);
		
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	

	
	
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
