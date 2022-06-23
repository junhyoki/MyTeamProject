package park.combobox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import park.ReservationInfo;

public class SelectSeatAgeBox extends JComboBox<String>{ // ���ɺ� �¼������� �� �޺��ڽ�
	
	ReservationInfo user;
	String[] ageGroup = {"����", "û�ҳ�", "�Ƶ�"};
	String age;
	int seatCnt;
	double discountRate=0;
	//Integer seatKey = user.getSeatKeys().get(seatCnt); // üũ�ڽ� ������ ������ �ش��ϴ� �ڼ���ȣ
	
	public SelectSeatAgeBox(ReservationInfo user, int seatCnt) { // ���������� ���� �¼� �߰��ؾ��ؼ� Ŭ���� �״�� �̲������ � �¼��� ���� �޺��ڽ����� Ȯ���ؾ��ؼ� �迭 �ε����� �� seatnum �����´�
		this.user = user;
		this.seatCnt = seatCnt;
		//Integer seatKey = user.getSeatKeys().get(seatCnt);
		
		addItem(String.format("%d�� �¼�", user.getSeatKeys().get(seatCnt))); // i��° Ű ���� �ش��ϴ� �¼� ��ȣ�� ���� ���� ǥ��
		addItem("------");
		for(int i=0;i<ageGroup.length;i++) { // ���� û�ҳ� ��� �߰�
			addItem(ageGroup[i]);
		}
		setBackground(Color.white);
		setSize(10, 10);
		selectSeat();
	}

	void selectSeat() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				age = (String) getSelectedItem().toString(); // �޺��ڽ����� �� ���� string���� ��ȯ
				if(age.equals("------")||age.equals(String.format("%d�� �¼�", user.getSeatKeys().get(seatCnt)))) {// Ű ���� ���ų� ---- ���� �ٽ� �����ϰ�
					new JOptionPane().showMessageDialog(null, "����, û�ҳ�, �Ƶ� �� �����ϼ���.","����",JOptionPane.ERROR_MESSAGE); // ���� ��� û�ҳ� ���� �����ϸ� ����â �߰�
				}else {
					discount(age);
					user.getSeatName().put(user.getSeatKeys().get(seatCnt), discountRate); // �ش� �¼���ȣ �ڸ��� ������ �ִ´�
					System.out.println(user.getSeatName().get(user.getSeatKeys().get(seatCnt))+" ���� �Ϸ� " ); // �ؽ��ʿ� ����Ǵ��� Ȯ��
				}
			}
		});
	}
	
	void discount(String age) {
		if(age.equals("����")) {
			discountRate = 1;
			user.setAgeBySeat(user.getSeatKeys().get(seatCnt), age);
		}else if(age.equals("û�ҳ�")) {
			discountRate = 0.85;
			user.setAgeBySeat(user.getSeatKeys().get(seatCnt), age);
		}else if(age.equals("�Ƶ�")){
			discountRate = 0.7;
			user.setAgeBySeat(user.getSeatKeys().get(seatCnt), age);
		}
	}
}
