package park.frame;

import javax.swing.JFrame;

import park.ReservationInfo;
import park.button.HomeButton;
import park.database.LoadRVID;
import park.label.SucceedPayLabel;
import park.panel.RouteInfoColumnNamePanel;
import park.panel.RouteInfoPanel;

public class PayInfo extends JFrame{
	
	ReservationInfo user;
	HomeButton homeBtn = new HomeButton(user);
	SucceedPayLabel payLabel = new SucceedPayLabel(); 
	RouteInfoColumnNamePanel columnNamePanel = new RouteInfoColumnNamePanel();
	RouteInfoPanel routePanel = new RouteInfoPanel(user);
	
	public PayInfo(ReservationInfo user) {
		super("���� �Ϸ�");
		this.user = user;
		//new LoadRVID(user); // �������� ����Ǵ� ���Ź�ȣ�� user�� �����ϰ� ���
		homeBtn.setBounds(190, 500, 100, 50);
		add(payLabel);
		add(homeBtn);
		add(routePanel);
		
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
}
