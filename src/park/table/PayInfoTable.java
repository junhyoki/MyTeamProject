package park.table;

import javax.swing.JTable;

import park.ReservationInfo;

public class PayInfoTable extends JTable {
	static ReservationInfo user;
	static String[][] rowData = {
			{user.date,user.depart,user.time,user.seatName}	// �̰͵� Ŭ���� �ϳ� �������ߵ�
	};
	static String[] columnNames = {"��¥", "�����","������","�ð�","�¼���ȣ","�⺻����"};


	public PayInfoTable(ReservationInfo user) {
		this.user = user;
		super(setRowData(user.seatName.size()),columnNames ); // �̰� �����
		getTableHeader().setReorderingAllowed(false); // �÷� �̵� �Ұ�
		setEnabled(false); // ���̺� ���� ���� �Ұ�
	}

	public static String[][] setRowData(int size) {
		String[][] rowData;
		for(int i=0;i<size;i++) {
			//rowData = 

			return ;
		}

	}
}

//	static String[][] rowData = { // test�� �迭
//			{"20220616", "������", "�λ�", "1750", "01"},
//			{"20220616", "������", "�λ�", "1750", "02"},
//	};
//	static String[] columnNames = {"��¥", "�����", "������", "�ð�", "�¼���ȣ"};

