package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ArrivalButton extends JButton {
	
	private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(240,200);
	
	public ArrivalButton() {
		super("�������� �Է����ּ���");
		setOpaque(true);
		setBackground(new Color(0xFFE5CC));
		setFont(new Font("�������", Font.BOLD, 20));
		setBorder(lb);
		setPreferredSize(dimension);
	}
	
	public void setTextArvBtn(String str) {
		setText(str);
	}
}
