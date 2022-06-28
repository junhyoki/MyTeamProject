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

import jang.Data.Member_Data;
import jang.Data.Route_Read_Data;
import jang.Route.Route_Delete;
import jang.Route.Route_Insert;
import jang.Route.Route_Update;

public class RouteManageMentGUI extends JFrame {

	JScrollPane scrolledpane;
	JPanel panel = new JPanel();

	JTextArea ta = new JTextArea();

	JButton btn1 = new JButton("�߰�");
	JButton btn2 = new JButton("��ȸ");
	JButton btn3 = new JButton("����");
	JButton btn4 = new JButton("����");
	JButton btn5 = new JButton("�˻�");

	JLabel pName = new JLabel("������ - �뼱");
//	JLabel label = new JLabel("�뼱");
//	JButton backBtn;
	JButton homeBtn;

	ImageIcon image = new ImageIcon("Image/back2.png");
	ImageIcon image2 = new ImageIcon("Image/back3.png");

	ImageIcon home_image = new ImageIcon("Image/home.png");
	ImageIcon home_image2 = new ImageIcon("Image/home2.png");

	JTextField search = new JTextField();

	Route_DB db = new Route_DB();
	
	public void allView() {
		try {
			remove(scrolledpane);			
		} catch(NullPointerException e) {
			
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
//	               tf1.setText(rowData[row][0]);
//	               tf2.setText(rowData[row][1]);
//	               tf3.setText(rowData[row][2]);
//	               tf4.setText(rowData[row][3]);
//	               tf5.setText(rowData[row][4]);
	            } 
	            
	         }
	      });

		model.fireTableDataChanged();
		scrolledpane = new JScrollPane();
		scrolledpane.setViewportView(table);
//		table.setEnabled(false);

		scrolledpane.setBounds(40, 300, 700, 250);
		getContentPane().add(scrolledpane);
	}
	
	public void searchView(String arrive) {
		try {
			remove(scrolledpane);			
		} catch(NullPointerException e) {
			
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
//	               tf1.setText(rowData[row][0]);
//	               tf2.setText(rowData[row][1]);
//	               tf3.setText(rowData[row][2]);
//	               tf4.setText(rowData[row][3]);
//	               tf5.setText(rowData[row][4]);
	            } 
	            
	         }
	      });

		model.fireTableDataChanged();
		scrolledpane = new JScrollPane();
		scrolledpane.setViewportView(table);
//		table.setEnabled(false);

		scrolledpane.setBounds(40, 300, 700, 250);
		getContentPane().add(scrolledpane);
	}

	public RouteManageMentGUI() {
		RouteManageMentGUI();
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

		ta.setEditable(false);

//		backBtn = new JButton(image);
//		backBtn.setRolloverIcon(image2);
//		backBtn.setBorderPainted(false);
//		backBtn.setBounds(30, 30, 48, 50);
//		panel.add(backBtn);

		homeBtn = new JButton(home_image);
		homeBtn.setRolloverIcon(home_image2);
		homeBtn.setBorderPainted(false);
		homeBtn.setBounds(700, 30, 50, 50);
		panel.add(homeBtn);

		pName.setBounds(230, 30, 300, 50);
		pName.setFont(new Font("�޸ո���ü", Font.BOLD, 40));
		panel.add(pName);
//		label.setBounds(40, 120, 50, 30);
//		label.setFont(new Font("�޸ո���ü", Font.PLAIN, 30));
//		panel.add(label);

		// �Է��� ���� ���̴� â
//		JScrollPane jsp = new JScrollPane(ta); // â ��ũ��
//		jsp.setBounds(40, 320, 700, 250);
//		panel.add(jsp);

		btn1.setBounds(300, 160, 70, 30);
		btn1.setBackground(new Color(0XE7E6E6));
		btn2.setBounds(195, 160, 70, 30);
		btn2.setBackground(new Color(0XE7E6E6));
		btn3.setBounds(405, 160, 70, 30);
		btn3.setBackground(new Color(0XE7E6E6));
		btn4.setBounds(510, 160, 70, 30);
		btn4.setBackground(new Color(0XE7E6E6));
		btn5.setBounds(405, 220, 70, 30);
		btn5.setBackground(new Color(0XE7E6E6));

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

		search.setBounds(300, 220, 100, 30);
		panel.add(search);
		
		
		// �ڷΰ��� ��ư
//		backBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new ManagerMainFrame2();
//				setVisible(false);
//			}
//		});

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
				new Route_Update();

			}
		});

		// ���� ��ư �̺�Ʈ
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Route_Delete();

			}
		});

		// �˻�
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
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
