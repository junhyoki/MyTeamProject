package lee.mpcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MPincorrectpwSF extends JFrame implements ActionListener{
	JButton closeBtn = new JButton("�ݱ�");	
	
	public MPincorrectpwSF() {
		super("�߸��� ��й�ȣ");
		
		JLabel label = new JLabel("<html>�߸��� ��й�ȣ�Դϴ�.<br>�ٽ� �Է����ּ���.</html>");

		// �� ����
		label.setBounds(110, 60, 300, 30);
		add(label);
		
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
		new MPincorrectpwSF();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
	
}
