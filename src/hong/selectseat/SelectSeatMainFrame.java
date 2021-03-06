package hong.selectseat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import an.OjdbcConnection;
import hong.BackGroundLabel;
import hong.SaveInfo;
import hong.selectroute.SelectRouteMainFrame;
import hong.selectseat.event.BeforeButtonEvent;
import hong.selectseat.event.NextButtonEvent;
import hong.selectseat.event.SeatButtonEvent;
import lee.RoundedButton;
import park.frame.Pay;

public class SelectSeatMainFrame extends JFrame {
	
	final private static int MAX_SEAT = 21;
	private static SeatButton[] seatBtns = new SeatButton[MAX_SEAT];
	
	private SaveInfo saveInfo;
	
	private int bi_id;
	private int bs_id;
	private int selectCnt = 0;
	
	private SeatButton seatBtn;
	
	private ArrayList<Integer> bs_id_list = new ArrayList<>();
	private ArrayList<Integer> bs_is_reserved = new ArrayList<>();
	private ArrayList<String> bs_name_list = new ArrayList<>();
	
//	private NextButton nextBtn = new NextButton();
//	private BeforeButton beforeBtn = new BeforeButton();
	private RoundedButton nextBtn = new RoundedButton("확인");
	private RoundedButton beforeBtn = new RoundedButton("이전으로");
	
	
	private SeatButtonEvent seatBtnEvent = new SeatButtonEvent(this);
	private NextButtonEvent nextBtnEvent = new NextButtonEvent(this);
	private BeforeButtonEvent beforeBtnEvent = new BeforeButtonEvent(this);
	
//	public void save_seat_name() {
//		saveInfo.set_seat_name(bs_name_list);
//	}
	
	public void nextFrame() {
		new Pay(saveInfo);
	}
	
	public void thisClose() {
		dispose();
	}
	
	public void beforeFrame() {
		new SelectRouteMainFrame(saveInfo);
	}
	
	public void selectSeat(int seatNum) {
		
//		if(!seatBtns[seatNum].get_is_selected()) {
//			saveInfo.put_bs_id(seatBtns[seatNum].get_bs_id());
//			saveInfo.put_bs_name("" + seatNum, seatBtns[seatNum].get_bs_id()); // 좌석 번호와 좌석이름을 SaveInfo HashMap에..
//		} else {
//			
//			saveInfo.removeIdMap(seatBtns[seatNum].get_bs_id());
//			saveInfo.removeNameMap("" + seatNum);
//		}
		seatBtns[seatNum].selectedCheck();
	}
	
	public void putSeat() {
		for(int i = 0; i < MAX_SEAT; ++i) {
			if(seatBtns[i].get_is_selected()) {
				++selectCnt;
				saveInfo.put_bs_id(seatBtns[i].get_bs_id());
				saveInfo.put_bs_name("" + i, seatBtns[i].get_bs_id());
			}
		}
	}
	
	public int getSelectCnt() {
		return selectCnt;
	}
	
	
	public SelectSeatMainFrame(SaveInfo saveInfo) {
		
		super("좌석 선택");
		this.saveInfo = saveInfo;
		this.bi_id = saveInfo.get_bi_id();
		setSeatTable();
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		add(new BackGroundLabel("", 10, 50, 30));
		add(new BackGroundLabel("좌석 선택", 400, 50, 30));
		
		for(int i = 0; i < MAX_SEAT; ++i) {
			seatBtn = new SeatButton();
			seatBtns[i] = seatBtn;
			seatBtns[i].addActionListener(seatBtnEvent);
			seatBtns[i].setName("" + i);
			seatBtns[i].set_seat_id(bs_id_list.get(i));
			seatBtns[i].setSeatName(bs_name_list.get(i));
			seatBtns[i].set_is_reserved(bs_is_reserved.get(i));
		}
		
		for(int i = 0; i < MAX_SEAT; ++i) {
			if (i % 3 == 2) {
				add(new BackGroundLabel("", 90, 69, 0));
			} 
			
			add(seatBtns[i]);
			
			if (seatBtns[i].get_is_reserved() == 1) {
				seatBtns[i].btn_break();
			}
		}
		
		nextBtn.setBackground(Color.WHITE);
		nextBtn.setForeground(Color.BLACK);
		
		nextBtn.setPreferredSize(new Dimension(110,40));
		nextBtn.addActionListener(nextBtnEvent);
		add(nextBtn);
		
		beforeBtn.setBackground(Color.WHITE);
		beforeBtn.setForeground(Color.BLACK);
		
		beforeBtn.setPreferredSize(new Dimension(110,40));
		beforeBtn.addActionListener(beforeBtnEvent);
		add(beforeBtn);
		
		setSize(450, 720);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0xA0A0F6));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	// bi_id 에 따른 bus_seat 테이블 정보를 리스트에 초기화
	private void setSeatTable() {
		String sql = "SELECT * FROM bus_seat WHERE bi_id=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){	
			pstmt.setInt(1, bi_id);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bs_id_list.add(rs.getInt("bs_id"));
				bs_is_reserved.add(rs.getInt("bs_is_reserved"));
				bs_name_list.add(((Integer)rs.getInt("bs_name")).toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
