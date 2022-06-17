package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MPmainFrame extends JFrame {
	
	JButton MPhomeBtn = new JButton();
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents = new MPcontentsPanel();
	
	
	public MPmainFrame() {
		
		setLayout(null);
		
		JLabel MPcategoryLb = new JLabel("ī�װ����� ���� �ٲ��� ��");
		MPcategoryLb.setBounds(270, 30, 700, 100);
		MPcategoryLb.setFont(new Font("�ü�ü", Font.PLAIN, 25));
		
		MPhomeBtn.setBounds(10, 10, 50, 50);
		MPhomeBtn.setBorderPainted(false);
		MPhomeBtn.setBackground(Color.cyan);
		
		
		
		
		
		add(MPcategoryLb);
		add(MPnav);
		add(MPcontents);	
		add(MPhomeBtn);
				
		//������ ����
		setTitle("����������");
		getContentPane().setBackground(Color.WHITE);//���� ���߿� ���߱�		
		setBounds(0, 0, 900, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MPmainFrame();
	}
}
