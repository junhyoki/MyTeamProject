package park.table;

import javax.swing.JTable;

public class PayInfoTable extends JTable {
	
	public PayInfoTable(String[][] rowData, String[] columnNames) {
		super(rowData, columnNames);
		setEnabled(false); // ���̺� ���� ���� �Ұ�
	}
	
//	static String[][] rowData = { // test�� �迭
//			{"20220616", "������", "�λ�", "1750", "01"},
//			{"20220616", "������", "�λ�", "1750", "02"},
//	};
//	static String[] columnNames = {"��¥", "�����", "������", "�ð�", "�¼���ȣ"};
}
