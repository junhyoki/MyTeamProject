package lee.mpcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MPincorrectphonenumSF extends JFrame implements ActionListener{

	public MPincorrectphonenumSF() {
		
		
		super("�Է� ����");
		JButton closeBtn = new JButton("�ݱ�");
		JLabel label = new JLabel("�ùٸ� �ڵ�����ȣ�� �Է����ּ���.");
		JLabel label1 = new JLabel("ex. 01012341234");
		
		// �� ����
		label.setBounds(78, 60, 300, 30);
		add(label);
		
		label1.setBounds(120, 87, 300, 30);
		add(label1);

		
		//�ݱ� ��ư ����
		closeBtn.setBounds(125, 130, 80, 30);
		
		closeBtn.addActionListener(this);
		add(closeBtn);	
		
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MPincorrectphonenumSF();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
