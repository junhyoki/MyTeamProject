package park.panel;

import javax.swing.JPanel;

import hong.SaveInfo;
import park.label.RouteInfoRowsLabel;

public class RouteInfoRowsPanel extends JPanel{ // �༱�� ���� ��� �ִ� �г� 

	public RouteInfoRowsPanel(SaveInfo user) {
		for(int i=0;i<user.getSeatSize();i++) {
			add(new RouteInfoRowsLabel(user.getDate()));
			add(new RouteInfoRowsLabel(user.getTime()));
			add(new RouteInfoRowsLabel(user.getDepart()));
			add(new RouteInfoRowsLabel(user.getArrive()));
			add(new RouteInfoRowsLabel(user.getSeatNames().get(i))); // �¼��̸�
		}
	}
	
}
