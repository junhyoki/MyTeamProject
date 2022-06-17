package park;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import park.panel.HomeBeforeBtnPanel;
import park.scrollpane.PayInfoScrollpane;
import park.table.PayInfoTable;


public class PayInfo extends JFrame{
	// ���̾ƿ� �η� ����� ���������� flow, table, label, combobox, button 
	static String[][] rowData = { // test�� �迭
			{"20220616", "������", "�λ�", "1750", "01"},
			{"20220616", "������", "�λ�", "1750", "02"},
	};
	static String[] columnNames = {"��¥", "�����", "������", "�ð�", "�¼���ȣ"};
	
	static HomeBeforeBtnPanel panel1 = new HomeBeforeBtnPanel(); // Ȩ��ư, ������ư�� ���� �ǳ� 
	//static PayInfoScrollpane piScrollPane = new PayInfoScrollpane(rowData, columnNames); // ���̺� ����� ��ũ������
	static PayInfoTable table = new PayInfoTable(rowData, columnNames);	
	static JScrollPane scroll = new JScrollPane(table);
	
	public PayInfo() {
		super("���� ȭ��");
		//LayoutManager manager = new GridLayout(5,1);
		
		// jcombo.getSelectedItem().toString() // �޺��ڽ����� �� �������� ��Ʈ������ �̾���
		//panel1.setBounds(50, 50, 100, 100);
		add(panel1, "South"); // Ȩ��ư, ������ư �ǳ�
		add(scroll, "Center"); // �¼����� ����ϴ� ���̺�
	
		//setLayout(manager);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new PayInfo();
	}

}
