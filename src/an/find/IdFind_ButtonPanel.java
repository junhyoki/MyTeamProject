package an.find;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class IdFind_ButtonPanel extends JPanel{
	
	JButton button = new Find_Button("ã��");
	JButton button2 = new Find_Button("��й�ȣ ã��");
	JButton out = new Find_Button("������");
	
	public IdFind_ButtonPanel(JButton b,JButton b2 ,JButton b3) {
		button = b;
		button2 = b2;
		out = b3;
		
		setLayout(new FlowLayout());
		setBackground(new Color(0X4D7F86));
		
		add(button); add(button2);add(out);
	}

}
