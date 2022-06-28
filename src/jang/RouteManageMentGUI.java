package jang;

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import jang.Data.Route_Read_Data;
import jang.Route.Route_Insert;

public class RouteManageMentGUI extends JFrame {
	ArrayList<JTextField> tfList = new ArrayList<>();

	JScrollPane scrolledpane;
	JPanel panel = new JPanel();

	JTextArea ta = new JTextArea();

	JButton btn1 = new JButton("�߰�");
	JButton btn2 = new JButton("��ü ��ȸ");
	JButton btn3 = new JButton("����");
	JButton btn4 = new JButton("����");
	JButton btn5 = new JButton("�˻�");

	JLabel pName = new JLabel("�뼱");

	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField search = new JTextField("������ �Է�");
	JTextField delete = new JTextField();
	JTextField tf5 = new JTextField();

	JLabel l1 = new JLabel("���� ID : ");
	JLabel l2 = new JLabel("�뼱 ID : ");
	JLabel l3 = new JLabel("��¥ : ");
	JLabel l4 = new JLabel("�ð� : ");

	JButton homeBtn;

	ImageIcon image = new ImageIcon("Image/back2.png");
	ImageIcon image2 = new ImageIcon("Image/back3.png");

	ImageIcon home_image = new ImageIcon("Image/home.png");
	ImageIcon home_image2 = new ImageIcon("Image/home2.png");

	Route_DB db = new Route_DB();

	public RouteManageMentGUI() {
		RouteManageMentGUI();
		tfList.add(tf1);
		tfList.add(tf2);
		tfList.add(tf3);
		tfList.add(tf4);
		tfList.add(search);
		tfList.add(delete);

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

		ArrayList<Route_Read_Data> arr = db.readData();

		String[] colNames = { "���� ID", "�뼱 ID", "�����", "������", "���", "��¥", "�ð�" };
		String[][] rowData = new String[arr.size()][colNames.length];

		for (int row = 0; row < rowData.length; ++row) {
			rowData[row][0] = Integer.toString(arr.get(row).getBI_ID());
			rowData[row][1] = Integer.toString(arr.get(row).getRT_ID());
			rowData[row][2] = arr.get(row).getDepart();
			rowData[row][3] = arr.get(row).getArrive();
			rowData[row][4] = arr.get(row).getCharge();
			rowData[row][5] = arr.get(row).getDay();
			rowData[row][6] = arr.get(row).getTime();
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
					tf1.setText(rowData[row][0]);
					tf2.setText(rowData[row][1]);
					tf3.setText(rowData[row][5]);
					tf4.setText(rowData[row][6]);
//					tf5.setText(rowData[row][0]);
//					search.setText(rowData[row][3]);
				}

			}
		});

		model.fireTableDataChanged();
		scrolledpane = new JScrollPane();
		scrolledpane.setViewportView(table);
//		table.setEnabled(false);

		scrolledpane.setBounds(40, 200, 700, 330);
		getContentPane().add(scrolledpane);
	}

	public void searchView(String arrive) {
		try {
			remove(scrolledpane);
		} catch (NullPointerException e) {

		}

		ArrayList<Route_Read_Data> arr = db.searchRoute(arrive);

		String[] colNames = { "���� ID", "�뼱 ID", "�����", "������", "���", "��¥", "�ð�" };
		String[][] rowData = new String[arr.size()][colNames.length];

		for (int row = 0; row < rowData.length; ++row) {
			rowData[row][0] = Integer.toString(arr.get(row).getBI_ID());
			rowData[row][1] = Integer.toString(arr.get(row).getRT_ID());
			rowData[row][2] = arr.get(row).getDepart();
			rowData[row][3] = arr.get(row).getArrive();
			rowData[row][4] = arr.get(row).getCharge();
			rowData[row][5] = arr.get(row).getDay();
			rowData[row][6] = arr.get(row).getTime();
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
					tf1.setText(rowData[row][0]);
					tf2.setText(rowData[row][1]);
					tf3.setText(rowData[row][5]);
					tf4.setText(rowData[row][6]);
//					tf5.setText(rowData[row][0]);
//	               tf5.setText(rowData[row][4]);
				}

			}
		});

		model.fireTableDataChanged();
		scrolledpane = new JScrollPane();
		scrolledpane.setViewportView(table);
//		table.setEnabled(false);

		scrolledpane.setBounds(40, 200, 700, 330);
		getContentPane().add(scrolledpane);
	}

	public void RouteManageMentGUI() {
		setTitle("�뼱 ���� ���α׷�");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setBounds(10, 20, 800, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		homeBtn = new JButton(home_image);
		homeBtn.setRolloverIcon(home_image2);
		homeBtn.setBorderPainted(false);
		homeBtn.setBounds(700, 30, 50, 50);
		panel.add(homeBtn);

		pName.setBounds(230, 30, 300, 50);
		pName.setFont(new Font("�޸ո���ü", Font.BOLD, 40));
		panel.add(pName);

		btn1.setBounds(160, 100, 70, 30);
		btn1.setBackground(new Color(0XE7E6E6));
		btn2.setBounds(40, 100, 100, 30);
		btn2.setBackground(new Color(0XE7E6E6));
		btn3.setBounds(250, 100, 70, 30);
		btn3.setBackground(new Color(0XE7E6E6));
		btn4.setBounds(240, 550, 70, 30);
		btn4.setBackground(new Color(0XE7E6E6));
		btn5.setBounds(160, 550, 70, 30);
		btn5.setBackground(new Color(0XE7E6E6));

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

		search.setBounds(40, 550, 100, 30);
		panel.add(search);

		// �Է� ���� ��
		tf1.setBounds(100, 150, 80, 25);
		tf1.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf1); // ��¥ // ���� ID
		tf2.setBounds(250, 150, 80, 25);
		tf2.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf2); // �ð� // �뼱 ID
		tf3.setBounds(390, 150, 80, 25);
		tf3.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf3); // �뼱 ID // ��¥
		tf4.setBounds(530, 150, 80, 25);
		tf4.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf4); // ���� ID // �ð�

		// �Է� ���� �� �̸�
		l1.setBounds(40, 150, 80, 30);
		l1.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l1); // ���� ID
		l2.setBounds(190, 150, 80, 30);
		l2.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l2); // �뼱 ID
		l3.setBounds(340, 150, 80, 30);
		l3.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l3); // ��¥
		l4.setBounds(480, 150, 80, 30);
		l4.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l4); // �ð�

		// Ȩ ��ư
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				new Admin_MainFrame(); // ���߿� �������� �ٲٸ� ��
				new ManagerMainFrame2();
				dispose();
			}
		});

		// �Է� ��ư
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Route_Insert();
				allView();

			}
		});

		// ��� ��ư �̺�Ʈ
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				allView();
			}
		});

		// ���� ��ư
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int bi_id = Integer.parseInt(tf1.getText());
				int rt_id = Integer.parseInt(tf2.getText());
				String bi_day = tf3.getText();
				String bi_time = tf4.getText();

				Pattern passPattern = Pattern.compile("\\d{2}/\\d{2}/\\d{2}");
				Matcher passMatcher = passPattern.matcher(bi_day);
				Pattern passPattern2 = Pattern.compile("\\d{2}:\\d{2}");
				Matcher passMatcher2 = passPattern2.matcher(bi_time);
				
				if (bi_day.equals("") || bi_time.equals("")) {
					JOptionPane.showMessageDialog(null, "������ ��� �Է����ּ���", "�˸�", 1);
					return;
				} 
				else if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "��¥�� �ٽ� �Է��ϼ���\nex) xx/xx/xx", "��¥ ����", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "�ð��� �ٽ� �Է��ϼ���\nex) 24:00", "�ð� ����", 1);
					return;
				} else {
					db.updateData(bi_id, rt_id, bi_day, bi_time);

					JOptionPane.showMessageDialog(null, "�߰��Ǿ����ϴ�!");
				}

				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");

				allView();

			}
		});

		// ���� ��ư �̺�Ʈ
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int bi_id = Integer.parseInt(tf1.getText());

				int delete = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "���� Ȯ��", JOptionPane.YES_NO_OPTION);
				if(delete == JOptionPane.YES_OPTION) {
					db.deleteData(bi_id);					
				} 
//				JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�!", "�˸�", 1);
				allView();
			}
		});

		// �˻�
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String arrive = search.getText();
				ArrayList<Route_Read_Data> arr = new ArrayList<Route_Read_Data>();
				arr = db.searchRoute(arrive);

				// ��ü ���
				if (arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "����� �뼱�� �����ϴ�", "����", 1);
					return;
				} else {
					searchView(arrive);

				}

				search.setText("");
			}

		});

	}

}
