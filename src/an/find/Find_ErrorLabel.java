package an.find;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Find_ErrorLabel extends JLabel{
	
	public Find_ErrorLabel(String str) {
		super(str);
		setForeground(Color.red);
		setFont(new Font("�޸�����ü", Font.BOLD, 15));
	}

}
