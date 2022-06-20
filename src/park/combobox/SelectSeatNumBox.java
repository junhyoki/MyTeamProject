package park.combobox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import park.ReservationInfo;

public class SelectSeatNumBox extends JComboBox<String>{ // ���ɺ� �¼������� �� �޺��ڽ�
	
	ReservationInfo user;
	String[] ageGroup = {"����", "û�ҳ�", "���"};
	String age;
	int seatCnt;
	Set<String> key;
	String[] keyArr ;
	
	public SelectSeatNumBox(ReservationInfo user, int seatCnt) { // ���������� ���� �¼� �߰��ؾ��ؼ� Ŭ���� �״�� �̲������ � �¼��� ���� �޺��ڽ����� Ȯ���ؾ��ؼ� �迭 �ε����� �� seatnum �����´�
		this.user = user;
		this.seatCnt = seatCnt;
		
		keyArr = new String[user.seatName.size()]; // �¼�����ŭ �迭 ���� ����
		selectKey();
		
		addItem(keyArr[seatCnt]+"�� �¼�"); // i��° Ű ���� �ش��ϴ� �¼� ��ȣ�� ���� ���� ǥ��
		addItem("------");
		for(int i=0;i<ageGroup.length;i++) { // ���� û�ҳ� ��� �߰�
			addItem(ageGroup[i]);
		}
		selectSeat();
	}

	
	void selectKey() {
		int i=0;
		key = user.seatName.keySet(); // �¼� Ű ���鸸 ������� ����
		for(String keys : key) {// Ű ������ ������ �ʿ��ϱ� ������ ������� �����ϰ�
			keyArr[i++] = keys; // Ű ���� ���� �迭�� �־��ش�
		}
	}

	void selectSeat() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				age = (String) getSelectedItem().toString(); // �޺��ڽ����� �� ���� string���� ��ȯ
				if(age.equals("------")||age.equals(keyArr[seatCnt]+"�� �¼�")) {// Ű ���� ���ų� ---- ���� �ٽ� �����ϰ�
					new JOptionPane().showMessageDialog(null, "����, û�ҳ�, ��� �� �����ϼ���.","����",JOptionPane.ERROR_MESSAGE); // ���� ��� û�ҳ� ���� �����ϸ� ����â �߰�
				}else {
					user.seatName.put(keyArr[seatCnt], age); // �ش� �¼���ȣ �ڸ��� ���ɴ븦 �ִ´�
					System.out.println(user.seatName.get(keyArr[seatCnt])+" ���� �Ϸ� " ); // �ؽ��ʿ� ����Ǵ��� Ȯ��
				}
			}
		});
	}
}
