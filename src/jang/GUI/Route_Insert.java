package jang.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import jang.RoundButton;
import jang.DB.Route_DB;
import jang.Data.Member_Data;
import jang.Data.Route_Insert_Data;
import jang.Data.rt_bi_id_Data;

public class Route_Insert extends JFrame {
	ArrayList<JTextField> tfList = new ArrayList<>();

	JScrollPane scrolledpane;
	JLabel panel = new JLabel();

	RoundButton btn3 = new RoundButton("노선 조회");
	RoundButton btn1 = new RoundButton("추가");
	RoundButton btn2 = new RoundButton("추가");
	RoundButton btn4 = new RoundButton("확인");
	RoundButton btn5 = new RoundButton("삭제");

	JLabel bus = new JLabel("버스 정보");
	JLabel route = new JLabel("노선 정보");

	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();
	JTextField tf7 = new JTextField();
	JTextField tf8 = new JTextField();

	JLabel l1 = new JLabel("날짜 : ");
	JLabel l2 = new JLabel("시간 : ");
	JLabel l3 = new JLabel("노선 ID : ");
	JLabel l4 = new JLabel("출발 : ");
	JLabel l5 = new JLabel("도착 : ");
	JLabel l6 = new JLabel("요금 : ");
	JLabel l7 = new JLabel("좌석 번호 : ");
	JLabel l8 = new JLabel("버스 ID : ");

	JLabel pName = new JLabel("노선 추가");

	ImageIcon image = new ImageIcon("Image/yujin_route_insert.jpg");

	Route_DB db = new Route_DB();

	JPanel p = new JPanel();

	public Route_Insert() {
		Route_Insert();

		tfList.add(tf1);
		tfList.add(tf2);
		tfList.add(tf3);
		tfList.add(tf4);
		tfList.add(tf5);
		tfList.add(tf6);
		tfList.add(tf7);
		tfList.add(tf8);

		for (int i = 0; i < tfList.size(); ++i) {
			JTextField tf = tfList.get(i);
			tf.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tf.setText("");
				}
			});
		}

	}

	public void allView() {
		try {
			remove(scrolledpane);
		} catch (NullPointerException e) {

		}

		ArrayList<Route_Insert_Data> arr = db.route_readData();

		String[] colNames = { "노선 ID", "출발지", "도착지", "요금" };
		String[][] rowData = new String[arr.size()][colNames.length];

		for (int row = 0; row < rowData.length; ++row) {
			rowData[row][0] = Integer.toString(arr.get(row).getRT_ID());
			rowData[row][1] = arr.get(row).getDepart();
			rowData[row][2] = arr.get(row).getArrive();
			rowData[row][3] = arr.get(row).getCharge();

		}

		DefaultTableModel model = new DefaultTableModel(rowData, colNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable table = new JTable(model);
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);

		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {
					System.out.println("select row : " + table.getSelectedRow());
					int row = table.getSelectedRow();
					tf3.setText(rowData[row][0]);

				}

			}
		});
		model.fireTableDataChanged();
		scrolledpane = new JScrollPane();
		scrolledpane.setViewportView(table);
//		table.setEnabled(false);

		// 셀 안의 내용 가운데 정렬
		DefaultTableCellRenderer tcellRander = new DefaultTableCellRenderer();
		tcellRander.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcolumn = table.getColumnModel();
		for (int i = 0; i < tcolumn.getColumnCount(); ++i) {
			tcolumn.getColumn(i).setCellRenderer(tcellRander);
		}

		scrolledpane.setBounds(40, 220, 545, 190);
		getContentPane().add(scrolledpane);

	}

	public void Route_Insert() {
		setTitle("노선 관리 프로그램");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setSize(650, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		panel.setIcon(image);

		pName.setBounds(240, 10, 200, 50);
		pName.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		panel.add(pName);

		btn3.setBounds(40, 185, 100, 30); // 전체조회
		btn3.setBackground(new Color(255, 255, 255, 122));
		btn3.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		btn1.setBounds(500, 85, 70, 30); // 노선 추가
		btn1.setBackground(new Color(255, 255, 255, 122));
		btn1.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		btn2.setBounds(500, 150, 70, 30); // 버스 추가
		btn2.setBackground(new Color(255, 255, 255, 122));
		btn2.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		btn4.setBounds(320, 420, 70, 30); // 확인
		btn4.setBackground(new Color(255, 255, 255, 122));
		btn4.setFont(new Font("휴먼편지체", Font.BOLD, 15));
		btn5.setBounds(230, 420, 70, 30); // 삭제
		btn5.setBackground(new Color(255, 255, 255, 122));
		btn5.setFont(new Font("휴먼편지체", Font.BOLD, 15));

		panel.add(btn3);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn4);
		panel.add(btn5);

		route.setBounds(40, 55, 80, 30);
		route.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		panel.add(route);
		bus.setBounds(40, 117, 80, 30);
		bus.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		panel.add(bus);

		// 입력 공간 라벨
		tf1.setBounds(90, 150, 80, 25);
		tf1.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf1); // 날짜
		tf2.setBounds(230, 150, 80, 25);
		tf2.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf2); // 시간
		tf3.setBounds(390, 150, 80, 25);
		tf3.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf3); // 노선 ID
		tf4.setBounds(90, 85, 80, 25);
		tf4.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf4); // 출발지
		tf5.setBounds(230, 85, 80, 25);
		tf5.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf5); // 도착지
		tf6.setBounds(390, 85, 80, 25);
		tf6.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(tf6); // 요금

		// 입력 공간 라벨 이름
		l1.setBounds(40, 150, 80, 30);
		l1.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l1); // 날짜
		l2.setBounds(180, 150, 80, 30);
		l2.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l2); // 시간
		l3.setBounds(320, 150, 80, 30);
		l3.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l3); // 노선 ID
		l4.setBounds(40, 85, 80, 30);
		l4.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l4); // 출발지
		l5.setBounds(180, 85, 80, 30);
		l5.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l5); // 도착지
		l6.setBounds(340, 85, 80, 30);
		l6.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
		panel.add(l6); // 요금

		// 노선 추가
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String rt_depart_from = tf4.getText();
				String rt_arrive_at = tf5.getText();
				String rt_charge = tf6.getText();

				Pattern passPattern = Pattern.compile("^[가-힣]*$");
				Matcher passMatcher = passPattern.matcher(rt_depart_from);
				Pattern passPattern2 = Pattern.compile("^[가-힣]*$");
				Matcher passMatcher2 = passPattern.matcher(rt_arrive_at);
				Pattern passPattern3 = Pattern.compile("[0-9]");
				Matcher passMatcher3 = passPattern3.matcher(rt_charge);

				if (rt_depart_from.equals("") || rt_arrive_at.equals("") || rt_charge.equals("")) {
					JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요", "알림", 1);
					return;
				} else if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "출발지를 다시 입력해주세요\n(공백없이 한글만 입력 가능)", "출발지 오류", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "도착지를 다시 입력해주세요\n(공백없이 한글만 입력 가능)", "도착지 오류", 1);
					return;
				} else if (!passMatcher3.find()) {
					JOptionPane.showMessageDialog(null, "요금은 숫자만 입력 가능합니다", "요금 오류", 1);
					return;
				} else {
					db.route_insertData(rt_depart_from, rt_arrive_at, rt_charge);
					JOptionPane.showMessageDialog(null, "추가되었습니다!");

				}

				tf4.setText("");
				tf5.setText("");
				tf6.setText("");

				allView();
			}
		});

		// 버스 정보 추가
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String bi_id = tf8.getText();
				String bi_day = tf1.getText();
				String bi_time = tf2.getText();
				String rtfk_id = tf3.getText();

				ArrayList<rt_bi_id_Data> arr = new ArrayList<rt_bi_id_Data>();
				arr = db.rt_idRead(rtfk_id);

				Pattern passPattern = Pattern.compile("\\d{2}/\\d{2}/\\d{2}");
				Matcher passMatcher = passPattern.matcher(bi_day);
				Pattern passPattern2 = Pattern.compile("\\d{2}:\\d{2}");
				Matcher passMatcher2 = passPattern2.matcher(bi_time);
				Pattern passPattern3 = Pattern.compile("[0-9]");
				Matcher passMatcher3 = passPattern3.matcher(rtfk_id);

				if (bi_day.equals("") || bi_time.equals("") || tf3.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "정보를 모두 입력해주세요", "알림", 1);
					return;
				} else if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "날짜를 다시 입력해주세요\nex) xx/xx/xx", "날짜 오류", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "시간을 다시 입력해주세요\nex) 24:00", "시간 오류", 1);
					return;
				} else if (!passMatcher3.find()) {
					JOptionPane.showMessageDialog(null, "노선 ID는 숫자만 입력 가능합니다", "아이디 오류", 1);
					return;
				} else if (arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "노선 ID가 존재하지 않습니다", "아이디 오류", 1);
					return;
				} else {
					db.bus_info_insertData(bi_day, bi_time, rtfk_id);
					int i = db.get_currsq();
					db.seat_insertData(i);

					JOptionPane.showMessageDialog(null, "추가되었습니다!");
				}

				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf8.setText("");
			}
		});

		// 출력 버튼 이벤트
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String rt_id = tf3.getText();
				allView();
			}
		});

		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String bi_id = tf8.getText();
				String rt_id = tf3.getText();

				ArrayList<rt_bi_id_Data> arr = new ArrayList<rt_bi_id_Data>();
				arr = db.rt_idRead(rt_id);

				int delete = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);

				if (rt_id.equals("")) {
					if (delete == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "노선 ID를 입력해주세요", "알림", 1);
						return;
					}

				} else if (arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "노선 ID가 존재하지 않습니다", "아이디 오류", 1);
					return;
				} else if (delete == JOptionPane.YES_OPTION) {
					db.get_bi_id(rt_id);
					db.rv_delete();
					db.bs_delete();
					db.bi_delete(rt_id);
					db.route_deleteData(rt_id);
					JOptionPane.showMessageDialog(null, "삭제되었습니다!", "삭제 알림", 1);
				}

				allView();
				tf3.setText("");
				tf8.setText("");
			}
		});

		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

	}

}
