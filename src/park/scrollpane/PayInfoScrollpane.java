package park.scrollpane;

import java.awt.Color;

import javax.swing.JScrollPane;

import park.panel.RouteInfoColumnNamePanel;

public class PayInfoScrollpane extends JScrollPane{ 

	public PayInfoScrollpane() {
		super(new RouteInfoColumnNamePanel());
		getViewport().setBackground(Color.white); // ��ũ������ ���� ����
	    setVerticalScrollBarPolicy(0);


		setBounds(10,100,465,200);
	}
}
