package an.login;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FindPanel extends JPanel{
	JButton find = new Lg_Button("���̵�/��й�ȣ ã��");
	
	public FindPanel() {
		new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(find);
	}

}
