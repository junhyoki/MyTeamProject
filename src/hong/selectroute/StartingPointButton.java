package hong.selectroute;

import java.awt.Font;

import javax.swing.JButton;

public class StartingPointButton extends JButton {
	
	public StartingPointButton() {
		super("������� �������ּ���");
		setFont(new Font("�������", Font.BOLD, 20));
	}
	
	public void setStarting(String str) {
		setText(str);
	}
}
