package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class SerchButton extends JButton {
	
	private Dimension dimension = new Dimension(560,50);
	
	public SerchButton() {
		super("��ȸ�ϱ�");
		setOpaque(true);
		setBackground(Color.WHITE);
		setFont(new Font("HY������M", Font.PLAIN, 18));
		setPreferredSize(dimension);
	}
}
