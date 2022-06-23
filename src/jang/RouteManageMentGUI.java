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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RouteManageMentGUI extends JFrame{
	
	
	JPanel panel = new JPanel();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();
	JTextField tf7 = new JTextField();
	JTextField tf8 = new JTextField();
	JTextField tf9 = new JTextField();
	JTextField tf10 = new JTextField();

	JTextArea ta = new JTextArea();
	
	JButton btn1 = new JButton("�߰�");
	JButton btn2 = new JButton("��ȸ");
	JButton btn3 = new JButton("����");
	JButton btn4 = new JButton("����");
	JButton btn5 = new JButton("����");
	
	JLabel l1 = new JLabel("���� ID : ");
	JLabel l2 = new JLabel("�뼱 ID : ");
	JLabel l3 = new JLabel("����� : ");
	JLabel l4 = new JLabel("������ : ");
	JLabel l5 = new JLabel("��� : ");
	JLabel l6 = new JLabel("��¥ : ");
	JLabel l7 = new JLabel("�ð� : ");
	JLabel l8 = new JLabel("�¼� ID : ");
	JLabel l9 = new JLabel("�¼� �̸� : ");
	JLabel l10 = new JLabel("���� : ");

	JLabel pName = new JLabel("������");
	JLabel label = new JLabel("�뼱");
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
		
		// �Է� ����
		tf1.setBounds(105, 170, 80, 25);
		tf1.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf1); // ���� ID
		tf2.setBounds(105, 200, 80, 25);
		tf2.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf2); // �뼱 ID
		tf3.setBounds(267, 200, 80, 25);
		tf3.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf3); // �����
		tf4.setBounds(422, 200, 80, 25);
		tf4.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf4); // ������
		tf5.setBounds(580, 200, 80, 25);
		tf5.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf5); // ���
		tf6.setBounds(267, 170, 80, 25);
		tf6.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf6); // ��¥
		tf7.setBounds(422, 170, 80, 25);
		tf7.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf7); // �ð�
		tf8.setBounds(105, 230, 80, 25);
		tf8.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf8); // �¼� ID
		tf9.setBounds(267, 230, 80, 25);
		tf9.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf9); // �¼� �̸�

		
		
		// �Է� ���� �� �̸�
		l1.setBounds(45, 170, 80, 30);
		l1.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l1); // ���� ID
		l2.setBounds(45, 200, 80, 30);
		l2.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l2); // �뼱 ID 
		l3.setBounds(195, 200, 80, 30);
		l3.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l3); // �����
		l4.setBounds(360, 200, 80, 30);
		l4.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l4); // ������
		l5.setBounds(520, 200, 80, 30);
		l5.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l5); // ���
		l6.setBounds(195, 170, 80, 30);
		l6.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l6); // ��¥
		l7.setBounds(360, 170, 80, 30); 
		l7.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l7); // �ð�
		l8.setBounds(45, 230, 80, 30);
		l8.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l8); // �¼� ID
		l9.setBounds(195, 230, 80, 30); 
		l9.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l9); // �¼� �̸�


		// �Է��� ���� ���̴� â
		JScrollPane jsp = new JScrollPane(ta); // â ��ũ��
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
		
		DialogTest dia = new DialogTest();
		
		
		 btn1.addActionListener(dia.handler);
		 btn3.addActionListener(dia.handler);
		 btn4.addActionListener(dia.handler);
		
		// �Է� ��ư �̺�Ʈ
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");

				
				String bi_day = tf6.getText();
				String bi_time = tf7.getText();
				int rtfk_id = Integer.parseInt(tf2.getText());
				
				String rt_depart_from = tf3.getText();
				String rt_arrive_at = tf4.getText();
				String rt_charge = tf5.getText();
				
				String bs_name = tf9.getText();
				int bifk_id = Integer.parseInt(tf1.getText());

				db.bus_info_insertData(new BI_Insert_Data(bi_day, bi_time, rtfk_id));
				db.route_insertData(new Route_Insert_Data(rt_depart_from, rt_arrive_at, rt_charge));
				db.seat_insertData(new Seat_Insert_Data(bs_name, bifk_id));

				ta.append("�Է� �Ϸ� \n");

				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
				tf8.setText("");
				tf9.setText("");
			}
		});

		// ��� ��ư �̺�Ʈ
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				ArrayList<Route_Read_Data> arr = new ArrayList<Route_Read_Data>();
				arr = db.readData();

				ta.append("\t���� ID\t" + "�����\t" + "������\t" + "���\t" + "��¥\t" + "�ð�\t" + "�¼� �̸�\t" + "����\n");
				ta.append("\t"
						+ "-----------------------------------------------------------------------------------------------------------------------\n");

				// ��ü���
				for (int i = 0; i < arr.size(); i++) {
					ta.append("\t" + arr.get(i).getBI_ID() + "\t" + arr.get(i).getDepart() + "\t"
							+ arr.get(i).getArrive() + "\t" + arr.get(i).getCharge() + "\t" + arr.get(i).getDay() + "\t"
							+ arr.get(i).getTime() + "\t" + arr.get(i).getBS_Name() + "\t" + arr.get(i).getReserved()
							+ "\n");
				}
			}
		});

		// ���� ��ư �̺�Ʈ
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");

				int bi_id = Integer.parseInt(tf1.getText());
				String bi_day = tf6.getText();
				String bi_time = tf7.getText();
				int rt_id = Integer.parseInt(tf2.getText());

				db.updateData(new Businfo_Data(bi_id, bi_day, bi_time, rt_id));
				ta.append("���� �Ϸ� \n");

				tf1.setText("");
				tf6.setText("");
				tf7.setText("");
				tf2.setText("");

			}
		});

		// ���� ��ư �̺�Ʈ
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");

				int bi_id = Integer.parseInt(tf1.getText());
				db.deleteData(bi_id);
						ta.append("���� �Ϸ� \n");

				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
				tf8.setText("");
				tf9.setText("");
				tf10.setText("");

			}
		});

		// ���� ��ư �̺�Ʈ
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

}
