package an.sign_up;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pass_Explanation extends JPanel{
	JLabel label = new Pass_Explanation_Label("��й�ȣ�� ����+Ư������+���� 8�ڷ� �����Ǿ�� �մϴ�");
	public Pass_Explanation() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		add(label);
	}
}
