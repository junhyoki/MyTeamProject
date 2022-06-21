package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class BusInfoLabel extends JLabel {
	
	// ���� ��ȣ, ��߽ð�, �����¼��� ��Ÿ���ִ� ��
	
	private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(105,20);
	
	public BusInfoLabel(String info) {
		super(info);
		setOpaque(true);
		setBackground(Color.WHITE);
		setHorizontalAlignment(CENTER);
		setBorder(lb);
		setPreferredSize(dimension);
	}

}
