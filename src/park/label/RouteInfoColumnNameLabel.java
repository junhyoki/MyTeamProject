package park.label;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class RouteInfoColumnNameLabel extends JLabel{
	
	public RouteInfoColumnNameLabel(String title) {
		super(title);
		setFont(new Font("����ü",Font.BOLD,20));
		setBackground(Color.blue);
	}

}
