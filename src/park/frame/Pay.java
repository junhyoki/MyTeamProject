package park.frame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import an.userinfo.Info_MainFrame;
import hong.SaveInfo;
import hong.selectseat.SelectSeatMainFrame;
import park.button.PayButton;
import park.combobox.SelectPayWayBox;
import park.database.LoadRVID;
import park.database.SaveDB;
import park.event.BeforeButtonEvent;
import park.event.HomeButtonEvent;
import park.event.PayButtonEvent;
import park.label.RouteInfoLabel;
import park.panel.HomeBeforeBtnPanel;
import park.panel.RouteInfoPanel;
import park.panel.SelectSeatAgePanel;
import park.scrollpane.PayInfoScrollpane;


public class Pay extends JFrame{
	// ���̾ƿ� �η� ����� ���������� flow, table, label, combobox, button 
	static SaveInfo user;
//	static String[][] rowData ; // ���� ������
//	static String[] columnNames = {"��¥", "�����", "������", "�ð�", "�¼���ȣ"};
	static HomeBeforeBtnPanel panel1 ; // Ȩ��ư, ������ư�� ���� �ǳ� (�÷ο췹�̾ƿ�)
	//static PayInfoTable table = new PayInfoTable(user);	// �¼����� ���̺�
	//static JScrollPane scroll = new JScrollPane(table); // �¼����� ���̺� ��� ��ũ��
	static SelectSeatAgePanel seatPanel ; // �¼��� ���ɴ� �� �޺��ڽ� ����ִ� �ǳ�
	static PayButton payBtn ; // �����ϱ� ��ư
	static SelectPayWayBox payWayBox ; // ���� ��� ���� �޺��ڽ�
	static RouteInfoLabel route; // �༱�� ���� 
	static RouteInfoPanel routePanel ; // �༱�� ���� ǥ ���·� ������ �г�
	//static PayInfoScrollpane scroll;
	static JScrollPane scroll2;
	
	public void thisClose() {
		dispose();
	}
	
	
	public Pay(SaveInfo user) {
		super("���� ȭ��");
		user.setSeatId(); // �ؽ��ʿ� �ִ� �¼��̸� ��̸���Ʈ�� �ֱ�
		user.setSeatNames();
		this.user = user;
		
		// ���� ���� �����ϱ����ؼ� �� �Ű������� �޾ƿ� user�� �ʱ�ȭ ����
		seatPanel = new SelectSeatAgePanel(user); // �г� �ʱ�ȭ ���ָ鼭 user ���� ��� �����ؾ��ؼ� �Ű������� �Ѱ��ش�
		panel1 = new HomeBeforeBtnPanel(user);
		payBtn = new PayButton(user);
		payWayBox = new SelectPayWayBox(user);
		routePanel = new RouteInfoPanel(user); 
		//scroll = new PayInfoScrollpane();
		scroll2 = new JScrollPane(routePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		route = new RouteInfoLabel();


		//scroll.setViewportView(routePanel);
		
		panel1.getHomeBtn().addActionListener(new HomeButtonEvent(this));
		panel1.getBefBtn().addActionListener(new BeforeButtonEvent(this));
		payBtn.addActionListener(new PayButtonEvent(this));

		add(panel1); // Ȩ��ư, ������ư �ǳ�
		add(route); // �༱�� ����
		//add(scroll);
		//add(scroll2);
		add(routePanel); // �༱�� ���� ǥ ǥ���� �ǳ�
		add(seatPanel); // �¼��� ���� ���� �޺��ڽ�
		add(payWayBox); // ���� ���� �� �޺� �ڽ�
		add(payBtn); // �����ϱ� ��ư
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void homeButtonEvent() {
		String str = "���� ȭ������ ���ư��ðڽ��ϱ�?";
		int ok =JOptionPane.showConfirmDialog(null, str, "���� ȭ��", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(ok==JOptionPane.OK_OPTION) { // ok�� ������
			user.remove_bs_map(user.getSeatId(), user.getSeatNames());
			user.setTotalCharge();
			dispose();
			new Info_MainFrame(user);
		}
	}
	
	public void beforeButtonEvent() {
		user.remove_bs_map(user.getSeatId(), user.getSeatNames());
		user.setTotalCharge();
		dispose();
		new SelectSeatMainFrame(user);
		
	}
	
	public void payButtonEvent() {

		try {
			if((!user.getPayWay().equals(null))&&user.isTotalChargeCheck()) {
				String str =String.format("���� �ݾ� : %d\n���� ���� : %s\n���� �Ͻðڽ��ϱ�?", (int)(user.getTotalCharge()), user.getPayWay());
				int ok =JOptionPane.showConfirmDialog(null, str, "���� Ȯ��", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(ok==JOptionPane.OK_OPTION) { // ok�� ������
					new SaveDB(user); // ��� �����Ѵ�
					new LoadRVID(user); // ��� ����� ���Ź�ȣ�� �ν��Ͻ��� ������
					dispose();
					new PayInfo(user); // ���� ��ư ������ ���� ȭ������ �Ѿ��
					System.out.println("db���� ����");
				}
				else { // ok �̿��� ���� ������
					user.setTotalCharge(); // ���� �˾����� ����� ���̹Ƿ� �ѿ���� �ʱ�ȭ ���ش�

				}
			}else {
				String str ="�ùٸ��� ���� ���� �� ���� ����Դϴ�.";
				JOptionPane.showMessageDialog(null, str, "���� �޽���", JOptionPane.PLAIN_MESSAGE);
			}
		}catch(NullPointerException e1){
			String str ="�ùٸ��� ���� ���� ���� �Ǵ� ���� ����Դϴ�.";
			JOptionPane.showMessageDialog(null, str, "���� �޽���", JOptionPane.PLAIN_MESSAGE);
		}


	}
	
	
	public static void main(String[] args) {
		new Pay(new SaveInfo());
	}

}
