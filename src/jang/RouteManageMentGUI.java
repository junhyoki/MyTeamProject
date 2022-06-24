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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jang.Data.Route_Read_Data;
import jang.Route.Route_Delete;
import jang.Route.Route_Insert;
import jang.Route.Route_Update;

public class RouteManageMentGUI extends JFrame {

	JPanel panel = new JPanel();

	JTextArea ta = new JTextArea();

	JButton btn1 = new JButton("�߰�");
	JButton btn2 = new JButton("��ȸ");
	JButton btn3 = new JButton("����");
	JButton btn4 = new JButton("����");
	JButton btn5 = new JButton("�˻�");

	JLabel pName = new JLabel("������");
	JLabel label = new JLabel("�뼱");
	JButton backBtn;
	JButton homeBtn;

	ImageIcon image = new ImageIcon("Image/back2.png");
	ImageIcon image2 = new ImageIcon("Image/back3.png");

	ImageIcon home_image = new ImageIcon("Image/home.png");
	ImageIcon home_image2 = new ImageIcon("Image/home2.png");

	JTextField search = new JTextField();

	Route_DB db = new Route_DB();

	RouteManageMentGUI() {
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
		pName.setFont(new Font("�޸ո���ü", Font.BOLD, 40));
		panel.add(pName);
		label.setBounds(40, 120, 50, 30);
		label.setFont(new Font("�޸ո���ü", Font.PLAIN, 30));
		panel.add(label);

		// �Է��� ���� ���̴� â
		JScrollPane jsp = new JScrollPane(ta); // â ��ũ��
		jsp.setBounds(40, 320, 700, 250);
		panel.add(jsp);

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
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerMainFrame2();
				setVisible(false);
			}
		});

		// Ȩ ��ư
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManagerMainFrame2(); // ���߿� �������� �ٲٸ� ��
				setVisible(false);
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
				ta.setText("");
				ArrayList<Route_Read_Data> arr = new ArrayList<Route_Read_Data>();
				arr = db.readData();

				ta.append("     ���� ID\t" + "�����\t" + "������\t" + "���\t" + "��¥\t" + "�ð�\t" + "�¼� �̸�\t" + "����\n");
				ta.append("     "
						+ "-----------------------------------------------------------------------------------------------------------------------------------------------------\n");

				// ��ü���
				for (int i = 0; i < arr.size(); i++) {
					ta.append("     " + arr.get(i).getBI_ID() + "\t" + arr.get(i).getDepart() + "\t"
							+ arr.get(i).getArrive() + "\t" + arr.get(i).getCharge() + "\t" + arr.get(i).getDay() + "\t"
							+ arr.get(i).getTime() + "\t" + arr.get(i).getBS_Name() + "\t" + arr.get(i).getReserved()
							+ "\n");
				}
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

				ta.append("     ���� ID\t" + "�����\t" + "������\t" + "���\t" + "��¥\t" + "�ð�\t" + "�¼� �̸�\t" + "����\n");
				ta.append("     "
						+ "-----------------------------------------------------------------------------------------------------------------------------------------------------\n");

				if (arr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "����� �뼱�� �����ϴ�", "���̵� ����", 1);
					return;
				} else {
					// ��ü���
					for (int i = 0; i < arr.size(); i++) {
						ta.append("     " + arr.get(i).getBI_ID() + "\t" + arr.get(i).getDepart() + "\t"
								+ arr.get(i).getArrive() + "\t" + arr.get(i).getCharge() + "\t" + arr.get(i).getDay()
								+ "\t" + arr.get(i).getTime() + "\t" + arr.get(i).getBS_Name() + "\t"
								+ arr.get(i).getReserved() + "\n");
					}

				}
			}

		});

	}

}
