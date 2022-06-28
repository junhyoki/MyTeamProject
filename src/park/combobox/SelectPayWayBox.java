package park.combobox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import hong.SaveInfo;

public class SelectPayWayBox extends JComboBox{ // ���� ��� ������ �޺��ڽ�
	
	SaveInfo user;
	public SelectPayWayBox(SaveInfo user) {
		
		this.user = user;
		
		addItem("���� ���");
		addItem("------");
		addItem("�ſ�ī��");
		addItem("�Ｚ����");
		addItem("������");
		
		selectPayWay();
		setBackground(Color.white);
		setBounds(190, 440, 100, 30);
	}

	void selectPayWay() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String way = (String) getSelectedItem().toString();
				if(way.equals("------")||way.equals("���� ���")) {// Ű ���� �����ų� ---- ������ �ٽ� �����ϰ�
					user.setPayWay(null);
					new JOptionPane().showMessageDialog(null, "���� ����� �����ϼ���.","����",JOptionPane.ERROR_MESSAGE); 
				}else {
					user.setPayWay((String) getSelectedItem().toString()) ;
					System.out.println(user.getPayWay() + "���� ���� ���� �Ϸ�");
				}
			}
		});
	}
}