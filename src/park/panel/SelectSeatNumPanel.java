package park.panel;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import park.ReservationInfo;
import park.combobox.SelectSeatNumBox;

public class SelectSeatNumPanel extends JPanel {

	public SelectSeatNumPanel(ReservationInfo test) {
		LayoutManager manager = new FlowLayout(FlowLayout.LEFT);
		
		for(int i=0;i<test.seatName.size();i++) {// �¼�����ŭ �޺��ڽ��� �����Ѵ�
			add(new SelectSeatNumBox(test,i));
			
		}
		setLayout(manager);
		setBounds(10,100,450,250);
		
	}
}
