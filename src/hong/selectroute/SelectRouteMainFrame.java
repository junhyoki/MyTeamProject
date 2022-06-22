package hong.selectroute;

import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import an.OjdbcConnection;
import an.login.Login_Mainframe;
import an.userinfo.Info_MainFrame;
import hong.BackGroundLabel;
import hong.BeforeButton;
import hong.NextButton;
import hong.SaveInfo;
import hong.selectroute.event.BeforeButtonEvent;
import hong.selectroute.event.DayComboBoxEvent;
import hong.selectroute.event.HomeButtonEvent;
import hong.selectroute.event.MonthComboBoxEvent;
import hong.selectroute.event.NextButtonEvent;
import hong.selectroute.event.SelectArrivalButtonEvent;
import hong.selectroute.event.SelectBusButtonEvent;
import hong.selectroute.event.SelectStartingButtonEvent;
import hong.selectroute.event.SerchButtonEvent;
import hong.selectroute.event.ShowArriveTerminalEvent;
import hong.selectroute.event.ShowStartingTerminalEvent;
import hong.selectseat.SelectSeatMainFrame;

public class SelectRouteMainFrame extends JFrame {
	
	SaveInfo saveInfo;
	
	HomeButton homeButton = new HomeButton();				// Ȩ ��ư
	StartingPointButton startingPointButton = new StartingPointButton();	// ��� ��ư
	ArrivalButton arrivalButton = new ArrivalButton(); 	// ���� ��ư
	SerchButton serchButton = new SerchButton(); // ��ȸ�ϱ� ��ư
	NextButton nextButton = new NextButton();	// ���� ��ư
	BeforeButton beforeButton = new BeforeButton();
	
	MonthComboBox monBox = new MonthComboBox();				// �� ���� �޺��ڽ�
	DayComboBox dayBox = new DayComboBox();					// �� ���� �޺��ڽ�
	
	SelectStartingButtonEvent startingBtnEvent = new SelectStartingButtonEvent(this); // ����� ���� ��ư �̺�Ʈ
	SelectArrivalButtonEvent arrivalBtnEvent = new SelectArrivalButtonEvent(this); // ������ ���� ��ư �̺�Ʈ
	HomeButtonEvent homeBtnEvent = new HomeButtonEvent(this); // Ȩ ��ư �̺�Ʈ
	ShowStartingTerminalEvent showStratingBtnEvent = new ShowStartingTerminalEvent(this); // ������� �����ִ� �̺�Ʈ.
	ShowArriveTerminalEvent showArrivalBtnEvent = new ShowArriveTerminalEvent(this); // �������� �����ִ� �̺�Ʈ.
	MonthComboBoxEvent monthBoxEvent = new MonthComboBoxEvent(this); // �� ���� �޺��ڽ� �̺�Ʈ
	DayComboBoxEvent dayBoxEvent = new DayComboBoxEvent(this); // �� ���� �޺��ڽ� �̺�Ʈ
	SerchButtonEvent serchBtnEvent = new SerchButtonEvent(this); // ��ȸ�ϱ� ��ư �̺�Ʈ
	SelectBusButtonEvent selectBusBtnEvent = new SelectBusButtonEvent(this); // ���� �����ؼ� �����ϱ� ��ư �̺�Ʈ
	NextButtonEvent nextBtnEvent = new NextButtonEvent(this);	// ���� ��ư �̺�Ʈ
	BeforeButtonEvent beforeBtnEvent = new BeforeButtonEvent(this);
	
	SelectSeatMainFrame seatMainFrame; // �¼����� ������
	SelectTerminalMainFrame stmFrame;	// �͹̳� ���� ������
	SelectBusFrame busFrame;	// ���� ���� ������
	
	private String startingPoint;
	private String arrivalPoint;
	private int month;
	private int day;
	private int rt_id;
	private int bi_id;
	private String bi_time;
	
	// �޿� ���� day���� �� ���� �޺��ڽ��� �߰��ϴ� �޼���
	public void addDays(int month) {
		dayBox.addItems(month);
	}
	
	// �� ���� �޺��ڽ��� ����ִ� �޼���
	public void resetDays() {
		dayBox.reset();
	}
		
	// ������� �����ϸ� ��ư �̸��� �������(ex:������) �ٲ��ش�
	public void departFrom(String starting) {
		startingPointButton.setTextStpBtn(starting);
	}
		
	// ������� �����ϸ� ������� �Է¹޴´�.
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	
	// �������� �����ϸ� ��ư �̸��� �������(ex:�λ�) �ٲ��ش�
	public void arriveAt(String destination) {
		arrivalButton.setTextArvBtn(destination);
		
	}
		
	// �������� �����ϸ� �������� �Է¹޴´�.
	public void setArrivalPoint(String arrivalPoint) {
		this.arrivalPoint = arrivalPoint;
	}
	
	// ����� ��ư�� ������ �͹̳ε��� �����ִ� �޼���. ������ �͹̳� ��ư�� �׼��� �߰����ش�.
	public void showStartingTerminals() {
		
		System.out.println(saveInfo.get_user_id());
		stmFrame = new SelectTerminalMainFrame();
		for (JButton btn : stmFrame.getAllBtns()) {
			btn.addActionListener(startingBtnEvent);
		}
	}
	
	// ������ ��ư�� ������ �͹̳ε��� �����ִ� �޼���. ������ �͹̳� ��ư�� �׼��� �߰����ش�.
	public void showArriveTerminals() {
		//System.out.println(saveInfo.get_user_id());
		stmFrame = new SelectTerminalMainFrame();
		for (JButton btn : stmFrame.getAllBtns()) {
			btn.addActionListener(arrivalBtnEvent);
		}
	}
		
		
	// �� �Է� �ޱ�
	public void setMonth(int month) {
		this.month = month;
	}
		
	// �� �Է� �ޱ�
	public void setDay(int day) {
		this.day = day;
	}
		
	// ������� �������� �����ϸ� �� â�� �ݾ��ش�.
	public void stmFlameClose() {
		stmFrame.dispose();
	}
	
	// �뼱, ��¥�� �´� �������� ������ �����ִ� �޼���
	public void showBus() {
		busFrame = new SelectBusFrame();
		busFrame.showBusInfo(rt_id, month, day);
		busFrame.getCanReserve();
		busFrame.addInfo();
		
		for (JButton btn : busFrame.getAllBtns()) {
			btn.getName();
			btn.addActionListener(selectBusBtnEvent);
		}
	}
	
	public void setBusID(int bi_id) {
		this.bi_id = bi_id;
	}
	
	// ���� ���� ������ ���ֱ�
	public void busFrameClose() {
		busFrame.dispose();
	}
	
	// �¼� ���� �������� ������ �޼���
	public void showSeatFrame() {
		seatMainFrame = new SelectSeatMainFrame(saveInfo);	
	}
	
	public void before() {
		new Info_MainFrame(saveInfo);
	}
	
	// �� ������ ���ֱ�
	public void thisFrameClose() {
		this.dispose();
	}
	
	public void save() {
		saveInfo.set_bi_id(bi_id);
		saveInfo.set_rt_id(rt_id); 
		saveInfo.set_depart_from(startingPoint);
		saveInfo.set_arrive_at(arrivalPoint);
		saveInfo.set_date(month, day);
		saveInfo.set_time(bi_time);
	}
	
	
	// ������ SaveInfo saveInfo
	public SelectRouteMainFrame(SaveInfo saveInfo) {
		super("���� ���� �ý���");
		
		this.saveInfo = saveInfo;
		
		this.getContentPane().setBackground(new Color(0xFFFFCC));
		// FlowLayout���� ���� / gap 10 , 30
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));
		
		// Ȩ��ư �׼Ǵް� ���̾ƿ��� ���̱�
		homeButton.addActionListener(homeBtnEvent);
		add(homeButton);
		// ���߿� �̹�������..?
		add(new BackGroundLabel("", 370, 100));
		
		// ����� ��ư �׼Ǵް� ���̱�
		startingPointButton.addActionListener(showStratingBtnEvent);
		add(startingPointButton);
		add(new BackGroundLabel("=>", 60, 200));
		
		// ������ ��ư
		arrivalButton.addActionListener(showArrivalBtnEvent);
		add(arrivalButton);
		//add(new BackGroundLabel("", 560, 10));
		add(new BackGroundLabel("��� ��¥ :",80, 30));
		
		// �� ���� �޺��ڽ�
		monBox.addItemListener(monthBoxEvent);
		add(monBox);
		add(new BackGroundLabel("��", 60, 30));
		
		// �� ���� �޺��ڽ�
		dayBox.addItemListener(dayBoxEvent);
		add(dayBox);
		add(new BackGroundLabel("��", 30, 30));
		//add(new BackGroundLabel("", 560, 10));
		
		// ��ȸ�ϱ� ��ư
		serchButton.addActionListener(serchBtnEvent);
		add(serchButton);
		
		
		add(new BackGroundLabel("", 150, 30));
		
		// ���� ���������� �Ѿ�� ��ư
		nextButton.addActionListener(nextBtnEvent);
		add(nextButton);
		
		add(new BackGroundLabel("", 30, 30));
		
		beforeButton.addActionListener(beforeBtnEvent);
		add(beforeButton);
		
		setBounds(300, 100, 600, 650);
		//getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Login_Mainframe();
	}
	
	
	// ����� �������� ���� �뼱ID��...
	public void getRouteID() {
		String sql = "SELECT rt_id FROM bus_route WHERE rt_depart_from=? AND rt_arrive_at=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){	
			pstmt.setString(1, startingPoint);
			pstmt.setString(2, arrivalPoint);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				this.rt_id = rs.getInt("rt_id");			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// �ش� bi_id �� ��� �ð���??
	public void getTime() {
		String sql = "SELECT bi_time FROM bus_info WHERE bi_id=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){	
			pstmt.setInt(1, bi_id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				this.bi_time = rs.getString("bi_time");				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
