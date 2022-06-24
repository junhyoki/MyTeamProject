package jang.Route;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jang.Route_DB;
import jang.Data.BI_Insert_Data;
import jang.Data.Member_Data;
import jang.Data.Route_Insert_Data;
import jang.Data.Route_Read_Data;
import jang.Data.Seat_Insert_Data;

public class Route_Insert extends JFrame {

	JPanel panel = new JPanel();

	JButton btn1 = new JButton("�߰�");
	JButton btn2 = new JButton("�߰�");
	JButton btn3 = new JButton("�߰�");
	JButton btn4 = new JButton("Ȯ��");

	JLabel bus = new JLabel("���� ����");
	JLabel route = new JLabel("�뼱 ����");
	JLabel seat = new JLabel("�¼� ����");

	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();
	JTextField tf7 = new JTextField();
	JTextField tf8 = new JTextField();

	JLabel l1 = new JLabel("��¥ : ");
	JLabel l2 = new JLabel("�ð� : ");
	JLabel l3 = new JLabel("�뼱 ID : ");
	JLabel l4 = new JLabel("��� : ");
	JLabel l5 = new JLabel("���� : ");
	JLabel l6 = new JLabel("��� : ");
	JLabel l7 = new JLabel("�¼� �̸� : ");
	JLabel l8 = new JLabel("���� ID : ");

	JLabel pName = new JLabel("�뼱 �߰�");

	Route_DB db = new Route_DB();

	public Route_Insert() {
		Route_Insert();
	}

	public void Route_Insert() {
		setTitle("�뼱 ���� ���α׷�");
		add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		setResizable(false);
		setBounds(10, 20, 600, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		pName.setBounds(200, 30, 200, 50);
		pName.setFont(new Font("�޸ո���ü", Font.BOLD, 40));
		panel.add(pName);

		btn1.setBounds(480, 135, 70, 30);
		btn1.setBackground(new Color(0XE7E6E6));
		btn2.setBounds(480, 220, 70, 30);
		btn2.setBackground(new Color(0XE7E6E6));
		btn3.setBounds(480, 300, 70, 30);
		btn3.setBackground(new Color(0XE7E6E6));
		btn4.setBounds(250, 360, 70, 30);
		btn4.setBackground(new Color(0XE7E6E6));

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);

		route.setBounds(20, 100, 80, 30);
		route.setFont(new Font("�޸ո���ü", Font.BOLD, 20));
		panel.add(route);
		bus.setBounds(20, 181, 80, 30);
		bus.setFont(new Font("�޸ո���ü", Font.BOLD, 20));
		panel.add(bus);
		seat.setBounds(20, 260, 80, 30);
		seat.setFont(new Font("�޸ո���ü", Font.BOLD, 20));
		panel.add(seat);

		// �Է� ���� ��
		tf1.setBounds(70, 220, 80, 25);
		tf1.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf1); // ��¥
		tf2.setBounds(210, 220, 80, 25);
		tf2.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf2); // �ð�
		tf3.setBounds(370, 220, 80, 25);
		tf3.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf3); // �뼱 ID
		tf4.setBounds(70, 140, 80, 25);
		tf4.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf4); // �����
		tf5.setBounds(210, 140, 80, 25);
		tf5.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf5); // ������
		tf6.setBounds(350, 140, 80, 25);
		tf6.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf6); // ���
		tf7.setBounds(90, 300, 80, 25);
		tf7.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf7); // �¼� �̸�
		tf8.setBounds(240, 300, 80, 25);
		tf8.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(tf8); // ���� ID

		// �Է� ���� �� �̸�
		l1.setBounds(20, 220, 80, 30);
		l1.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l1); // ��¥
		l2.setBounds(160, 220, 80, 30);
		l2.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l2); // �ð�
		l3.setBounds(300, 220, 80, 30);
		l3.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l3); // �뼱 ID
		l4.setBounds(20, 140, 80, 30);
		l4.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l4); // �����
		l5.setBounds(160, 140, 80, 30);
		l5.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l5); // ������
		l6.setBounds(300, 140, 80, 30);
		l6.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l6); // ���
		l7.setBounds(20, 300, 80, 30);
		l7.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l7); // �¼� �̸�
		l8.setBounds(180, 300, 80, 30);
		l8.setFont(new Font("�޸ո���ü", Font.PLAIN, 15));
		panel.add(l8); // ���� ID

		// �뼱 �߰�
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String rt_depart_from = tf4.getText();
				String rt_arrive_at = tf5.getText();
				String rt_charge = tf6.getText();

				db.route_insertData(new Route_Insert_Data(rt_depart_from, rt_arrive_at, rt_charge));

				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
			}
		});

		// ���� ���� �߰�
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String bi_day = tf1.getText();
				String bi_time = tf2.getText();
				int rtfk_id = Integer.parseInt(tf3.getText());

				Pattern passPattern = Pattern.compile("\\d{2}/\\d{2}/\\d{2}");
				Matcher passMatcher = passPattern.matcher(bi_day);
				Pattern passPattern2 = Pattern.compile("\\d{2}:\\d{2}");
				Matcher passMatcher2 = passPattern2.matcher(bi_time);

				if (!passMatcher.find()) {
					JOptionPane.showMessageDialog(null, "�ٽ� �Է��ϼ���\nex) 22/07/27", "��¥ ����", 1);
					return;
				} else if (!passMatcher2.find()) {
					JOptionPane.showMessageDialog(null, "�ٽ� �Է��ϼ���\nex) 15:00", "�ð� ����", 1);
					return;
				} else {
					db.bus_info_insertData(new BI_Insert_Data(bi_day, bi_time, rtfk_id));
					JOptionPane.showMessageDialog(null, "�ԷµǾ����ϴ�!");
				}

				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
			}
		});

		// �¼� �߰�
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String bs_name = tf7.getText();
				int bifk_id = Integer.parseInt(tf8.getText());

				db.seat_insertData(new Seat_Insert_Data(bs_name, bifk_id));

				tf7.setText("");
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
