package park.scrollpane;

import java.awt.Color;

import javax.swing.JScrollPane;

import park.panel.RouteInfoColumnNamePanel;

public class PayInfoScrollpane extends JScrollPane{ // �̰� �־�ߵǴ��� �Ǵ��غ��ߵ�

	public PayInfoScrollpane() {
		add(new RouteInfoColumnNamePanel());
		setBackground(Color.white);
		setBounds(10,100,465,200);
	}
}
