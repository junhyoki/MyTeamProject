package an.login;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class findPanel extends JPanel{
	JButton find = new Lg_Button("���̵�/��й�ȣ ã��");
	
	public findPanel() {
		new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(find);
	}

}
