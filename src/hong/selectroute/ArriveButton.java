package hong.selectroute;

import java.awt.Font;

import javax.swing.JButton;

public class ArriveButton extends JButton {
	
	public ArriveButton() {
		setText("�������� �Է����ּ���");
		setFont(new Font("�������", Font.BOLD, 20));
	}
	
	public void setDestination(String str) {
		setText(str);
	}
}
