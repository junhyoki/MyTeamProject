package park.panel;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import hong.SaveInfo;
import park.label.RouteInfoRowsLabel;

public class RouteInfoRowsPanel extends JPanel{ // �༱�� ���� ��� �ִ� �г� 

	public RouteInfoRowsPanel(SaveInfo user) {
		LayoutManager manager = new FlowLayout(FlowLayout.LEFT);
		for(int i=0;i<user.getSeatSize();i++) {
			add(new RouteInfoRowsLabel(user.getDate()));
			add(new RouteInfoRowsLabel(user.getTime()));
			add(new RouteInfoRowsLabel(user.getDepart()));
			add(new RouteInfoRowsLabel(user.getArrive()));
			add(new RouteInfoRowsLabel(String.format("%s",(Integer.parseInt(user.getSeatNames().get(i))+1 )))); // �¼��̸�
		}
		setLayout(manager);
		setBounds(10, 100, 450, 30);
	}
	
}
