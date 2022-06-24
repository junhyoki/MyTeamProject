package jang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import jang.Data.Route_Read_Data;
import jang.Route.Route_Delete;
import jang.Route.Route_Insert;
import jang.Route.Route_Update;

public class RouteManageMentGUI extends JFrame {

	JPanel panel = new JPanel();

	JTextArea ta = new JTextArea();

	JButton btn1 = new JButton("추가");
	JButton btn2 = new JButton("조회");
	JButton btn3 = new JButton("수정");
	JButton btn4 = new JButton("삭제");
	JButton btn5 = new JButton("종료");

	JLabel pName = new JLabel("관리자");
	JLabel label = new JLabel("노선");
	JButton backBtn;
	JButton homeBtn;

	ImageIcon image = new ImageIcon("Image/back2.png");
	ImageIcon image2 = new ImageIcon("Image/back3.png");

	ImageIcon home_image = new ImageIcon("Image/home.png");
	ImageIcon home_image2 = new ImageIcon("Image/home2.png");

	RouteManageMentGUI() {
		RouteManageMentGUI();
	}

	public void RouteManageMentGUI() {
		setTitle("노선 관리 프로그램");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setBounds(10, 20, 800, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		ta.setEditable(false);

		backBtn = new JButton(image);
		backBtn.setRolloverIcon(image2);
		backBtn.setBorderPainted(false);
		backBtn.setBounds(30, 30, 48, 50);
		panel.add(backBtn);

		homeBtn = new JButton(home_image);
		homeBtn.setRolloverIcon(home_image2);
		homeBtn.setBorderPainted(false);
		homeBtn.setBounds(700, 30, 50, 50);
		panel.add(homeBtn);

		pName.setBounds(330, 30, 200, 50);
		pName.setFont(new Font("휴먼매직체", Font.BOLD, 40));
		panel.add(pName);
		label.setBounds(40, 120, 50, 30);
		label.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		panel.add(label);

		// 입력한 글이 보이는 창
		JScrollPane jsp = new JScrollPane(ta); // 창 스크롤
		jsp.setBounds(40, 320, 700, 250);
		panel.add(jsp);

		btn1.setBounds(250, 270, 70, 30);
		btn1.setBackground(new Color(0XE7E6E6));
		btn2.setBounds(145, 270, 70, 30);
		btn2.setBackground(new Color(0XE7E6E6));
		btn3.setBounds(355, 270, 70, 30);
		btn3.setBackground(new Color(0XE7E6E6));
		btn4.setBounds(460, 270, 70, 30);
		btn4.setBackground(new Color(0XE7E6E6));
		btn5.setBounds(565, 270, 70, 30);
		btn5.setBackground(new Color(0XE7E6E6));

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

		Route_DB db = new Route_DB();

		// 뒤로가기 버튼
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerMainFrame2();
				setVisible(false);
			}
		});

		// 홈 버튼
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerMainFrame2(); // 나중에 메인으로 바꾸면 됨
				setVisible(false);
			}
		});

		// 입력 버튼
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Route_Insert();

			}
		});

		// 출력 버튼 이벤트
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				ArrayList<Route_Read_Data> arr = new ArrayList<Route_Read_Data>();
				arr = db.readData();

				ta.append("\t버스 ID\t" + "출발지\t" + "도착지\t" + "요금\t" + "날짜\t" + "시간\t" + "좌석 이름\t" + "예약\n");
				ta.append("\t"
						+ "-----------------------------------------------------------------------------------------------------------------------\n");

				// 전체출력
				for (int i = 0; i < arr.size(); i++) {
					ta.append("\t" + arr.get(i).getBI_ID() + "\t" + arr.get(i).getDepart() + "\t"
							+ arr.get(i).getArrive() + "\t" + arr.get(i).getCharge() + "\t" + arr.get(i).getDay() + "\t"
							+ arr.get(i).getTime() + "\t" + arr.get(i).getBS_Name() + "\t" + arr.get(i).getReserved()
							+ "\n");
				}
			}
		});

		// 수정 버튼
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Route_Update();

			}
		});

		// 삭제 버튼 이벤트
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Route_Delete();

			}
		});
	}

}
