package park;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import park.button.PayButton;
import park.panel.HomeBeforeBtnPanel;
import park.panel.SelectSeatNumPanel;
import park.table.PayInfoTable;


public class PayInfo extends JFrame{
	// ���̾ƿ� �η� ����� ���������� flow, table, label, combobox, button 
	static String[][] rowData ; // ���� ������
	static String[] columnNames = {"��¥", "�����", "������", "�ð�", "�¼���ȣ"};
	static HomeBeforeBtnPanel panel1 = new HomeBeforeBtnPanel(); // Ȩ��ư, ������ư�� ���� �ǳ� (�÷ο췹�̾ƿ�)
	//static PayInfoTable table = new PayInfoTable(user);	// �¼����� ���̺�
	//static JScrollPane scroll = new JScrollPane(table); // �¼����� ���̺� ��� ��ũ��
	static SelectSeatNumPanel seatPanel ; // �¼��� ���ɴ� �� �޺��ڽ� ����ִ� �ǳ�
	static PayButton payBtn = new PayButton(); // �����ϱ� ��ư
	static ReservationInfo user;
	
	
	public PayInfo(ReservationInfo user) {
		super("���� ȭ��");
		this.user = user;
		seatPanel = new SelectSeatNumPanel(user);
		
		//panel1.setBounds(10, 10, 80, 80); // �ǳ�(�÷ο췹�̾ƿ�) ���� ��ư ��ġ ���� �������� �����ؾߵ�
		//scroll.setBounds(10, 100 , 450, 100);
		
		add(panel1, "South"); // Ȩ��ư, ������ư �ǳ�
		//add(scroll, "Center"); // �¼����� ����ϴ� ���̺�
		add(seatPanel);
		add(payBtn);
	
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new PayInfo(new ReservationInfo());
	}

}
