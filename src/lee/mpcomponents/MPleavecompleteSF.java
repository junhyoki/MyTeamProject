package lee.mpcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MPleavecompleteSF extends JFrame {

	JButton yesBtn = new JButton("��");
	
	public MPleavecompleteSF() {
		super("Ż�� �Ϸ�");
		
		JLabel label = new JLabel("Ż�� �Ϸ�. Ȩȭ������ �̵��մϴ�.");
		
			
		
		//�������? �� ����
		label.setBounds(80, 60, 300, 30);
		add(label);
		
		//�� ��ư ����
		yesBtn.setBounds(123, 130, 80, 30);
		add(yesBtn);
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	


}
