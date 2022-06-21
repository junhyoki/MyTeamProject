package park.panel;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import park.ReservationInfo;
import park.combobox.SelectSeatAgeBox;

public class SelectSeatAgePanel extends JPanel {

	public SelectSeatAgePanel(ReservationInfo user) {
		LayoutManager manager = new FlowLayout(FlowLayout.LEFT);
		
		for(int i=0;i<user.seatName.size();i++) {// �¼�����ŭ �޺��ڽ��� �����Ѵ�
			add(new SelectSeatAgeBox(user,i));
			
		}
		setLayout(manager);
		setBounds(10,200,450,100);
		
	}
}
