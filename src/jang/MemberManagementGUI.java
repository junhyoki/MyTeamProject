package jang;

import java.awt.Color;
import java.awt.Font;
import java.awt.color.ColorSpace;
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

public class MemberManagementGUI extends JFrame{

	JPanel panel = new JPanel();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextArea ta = new JTextArea();
	
	JButton btn1 = new JButton("�߰�");
	JButton btn2 = new JButton("��ȸ");
	JButton btn3 = new JButton("����");
	JButton btn4 = new JButton("����");
	JButton btn5 = new JButton("����");
	
	JLabel l1 = new JLabel("ID : ");
	JLabel l2 = new JLabel("�̸� : ");
	JLabel l3 = new JLabel("��й�ȣ : ");
	JLabel l4 = new JLabel("��ȭ��ȣ : ");
	JLabel l5 = new JLabel("������/�մ� : ");
	
	JLabel pName = new JLabel("������");
	JLabel label = new JLabel("ȸ��");
	JButton backBtn;
	JButton homeBtn;
	
	ImageIcon image = new ImageIcon("Image/back2.png");
	ImageIcon image2 = new ImageIcon("Image/back3.png");

	ImageIcon home_image = new ImageIcon("Image/home.png");
	ImageIcon home_image2 = new ImageIcon("Image/home2.png");
	
	MemberManagementGUI() {
		ManagementGUI();
	}

	public void ManagementGUI() {
		setTitle("ȸ�� ���� ���α׷�");
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
		tf1.setBounds(55, 170, 80, 25);
		tf1.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf1); // ���̵� �Է� ����
		tf2.setBounds(187, 170, 80, 25);
		tf2.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf2); // �̸� �Է� ����
		tf3.setBounds(347, 170, 80, 25);
		tf3.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf3); // ���
		tf4.setBounds(505, 170, 80, 25);
		tf4.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf4); // ����
		tf5.setBounds(680, 170, 80, 25);
		tf5.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf5); // ����������
		
		// �Է� ���� �� �̸�
		l1.setBounds(25, 170, 80, 30);
		l1.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l1);  // ���̵� ��
		l2.setBounds(145, 170, 80, 30);
		l2.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l2);  // �̸� ��
		l3.setBounds(280, 170, 80, 30);
		l3.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l3); // ���
		l4.setBounds(440, 170, 80, 30);
		l4.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l4); // ����
		l5.setBounds(595, 170, 90, 30);
		l5.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l5); // ����������

		// �Է��� ���� ���̴� â
		JScrollPane jsp = new JScrollPane(ta); // â ��ũ��
		jsp.setBounds(40, 300, 700, 250);
		panel.add(jsp);

		
		btn1.setBounds(250, 240, 70, 30);
		btn1.setBackground(new Color(0XE7E6E6));
		btn2.setBounds(145, 240, 70, 30);
		btn2.setBackground(new Color(0XE7E6E6));
		btn3.setBounds(355, 240, 70, 30);
		btn3.setBackground(new Color(0XE7E6E6));
		btn4.setBounds(460, 240, 70, 30);
		btn4.setBackground(new Color(0XE7E6E6));
		btn5.setBounds(565, 240, 70, 30);
		btn5.setBackground(new Color(0XE7E6E6));
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);


		Member_DB db = new Member_DB();
		
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
				
				String user_id = tf1.getText();
				String user_name = tf2.getText();
				String user_password = tf3.getText();
				String user_phonenum = tf4.getText();
				String user_passenger_manager = tf5.getText();
				
				db.insertData(new Member_Data(user_id, user_name, user_password, user_phonenum, user_passenger_manager));
				
//				ta.append("�Է� �Ϸ� \n");				
				
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
			}
		});

		// ��� ��ư �̺�Ʈ
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				ArrayList<Member_Data> arr = new ArrayList<Member_Data>();
				arr = db.readData();
				
				ta.append("\t���̵�\t" + "�̸�\t" + "��й�ȣ\t" + "��ȭ��ȣ\t\t" + "������/�մ�\n");
				ta.append("\t" + "-----------------------------------------------------------------------------------------------------------------------\n");
				
				// ��ü���
				for (int i = 0; i < arr.size(); i++) {
					ta.append("\t" + arr.get(i).getID() + "\t" 
							+ arr.get(i).getName() + "\t" 
							+ arr.get(i).getPassword() + "\t"
							+ arr.get(i).getPhonenum() + "\t\t"
							+ arr.get(i).getPassenger() + "\n");
				}
			}
		});

		// ���� ��ư �̺�Ʈ
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText(""); 
				
				String user_id = tf1.getText();
				String user_name = tf2.getText();
				String user_password = tf3.getText();
				String user_phonenum = tf4.getText();

				db.updateData(new Member_Update_Data(user_id, user_name, user_password, user_phonenum));
//				ta.append("���� �Ϸ� \n");
				
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
			}
		});

		// ���� ��ư �̺�Ʈ
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				
				String user_name = tf2.getText();
				db.deleteData(user_name);
//				ta.append("���� �Ϸ� \n");
	
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
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

