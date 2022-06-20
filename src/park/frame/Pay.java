package park.frame;

import javax.swing.JFrame;

import park.ReservationInfo;
import park.panel.HomeBeforeBtnPanel;
import park.panel.PayWayPanel;

public class Pay extends JFrame{ // ���� ��� ���� ������ ȭ��
	
	static ReservationInfo user;
	static HomeBeforeBtnPanel panel1 = new HomeBeforeBtnPanel(); // Ȩ��ư, ������ư�� ���� �ǳ� (�÷ο췹�̾ƿ�)
	static PayWayPanel payPanel = new PayWayPanel();
	
	public Pay(ReservationInfo user) {
		super("���� ȭ��");
		this.user = user;
		add(panel1); 
		add(payPanel);
		
		setLayout(null);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Pay(user);
	}
}
